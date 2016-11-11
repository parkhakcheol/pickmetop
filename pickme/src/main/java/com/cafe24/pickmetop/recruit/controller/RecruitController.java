package com.cafe24.pickmetop.recruit.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pickmetop.recruit.model.Recruit;
import com.cafe24.pickmetop.recruit.service.RecruitService;
import com.cafe24.pickmetop.recruit.service.Commons;

@Controller
public class RecruitController {
	final static Logger logger = LoggerFactory.getLogger(RecruitController.class);
	@Autowired
	@Resource
	RecruitService recruitService;	
	@Autowired
	Commons commons;
	
	
	/* ä�� ���� ó��*/
	@RequestMapping(value="/recruitUpdate")
	public String recruitUpdate(){
		
		return "/recruit/company/companyRecruitUpdate";
	}
	
	
	/* ä�� ���� ȭ��*/
	@RequestMapping(value="/recruitUpdateForm")
	public String recruitUpdateForm(
			@RequestParam(value="recruitCompanyCd", defaultValue="0") String recruitCompanyCd){
		logger.info("recruitCompanyCd : {}",recruitCompanyCd);
		return "/recruit/company/companyRecruitUpdate";
	}
	
	
	/* ä�� ������*/
	@RequestMapping(value="/recruitDetail")
	public String recruitDetail(Model model,HttpSession session,
			@RequestParam(value="recruitCompanyCd", defaultValue="0") String recruitCompanyCd,
			@RequestParam(value="checked", defaultValue="") String bookmarkChecked){
		logger.info("recruitCd : {}",recruitCompanyCd);
		logger.info("recruitCompanyInfoForDetail :{}",recruitService.selectForRecruitCompanyDetail(recruitCompanyCd));
		model.addAttribute("recruitCompanyInfoForDetail",recruitService.selectForRecruitCompanyDetail(recruitCompanyCd));
		
		//�ϸ�ũ ���,����
		logger.info("bookmarkChecked :{}",bookmarkChecked);
		if(bookmarkChecked!=""){
			recruitService.insertBookmark(recruitCompanyCd,bookmarkChecked,session);
		}
		//�ϸ�ũ üũ����
		String checkBookmark=recruitService.checkBookmarkByLoginId(session,recruitCompanyCd);
		if(checkBookmark.equals("checkBookmark")){
			model.addAttribute("checkBookmark","checkBookmark");
		}
		return "/recruit/company/companyRecruitDetail"; 
	}

	
	/* ä�� ����Ʈ               {} : �迭��û. */
	@RequestMapping(value="/diary")
	public String diary(Model model,HttpSession session,
							@RequestParam(value="ddayYear", defaultValue="0") int ddayYear,
							@RequestParam(value="ddayMonth", defaultValue="0") int ddayMonth,
							@RequestParam(value="ddayOption", defaultValue="default") String ddayOption,
							@RequestParam(value="searchCompanyName", defaultValue="") String searchCompanyName,
							@RequestParam(value="bookmark", defaultValue="") String bookmark,
							@RequestParam(value="jobTopIndexCd", defaultValue="") List<String> jobTopIndexCd,
							@RequestParam(value="industryTopindexCd", defaultValue="") List<String> industryTopindexCd,
							@RequestParam(value="recruitJobWorkstatus", defaultValue="") String recruitJobWorkstatus){
		logger.info("�˻����Է��� �˻���ư �ϸ� searchCompanyName:{}",searchCompanyName);
		logger.info("bookmark���⸦ ������ true:{}",bookmark);
		logger.info("jobTopIndexCd[]:{}",jobTopIndexCd);
		logger.info("industryTopindexCd[]:{}",industryTopindexCd);
		logger.info("recruitJobWorkstatus[]:{}",recruitJobWorkstatus);

		Map<String,Object> map = recruitService.getOneDayList(ddayYear,ddayMonth,ddayOption,
				searchCompanyName,bookmark,jobTopIndexCd,industryTopindexCd,recruitJobWorkstatus,session);

		model.addAttribute("oneDayList",map.get("oneDayList"));
		model.addAttribute("ddayYear",map.get("ddayYear"));
		model.addAttribute("ddayMonth",map.get("ddayMonth"));
		model.addAttribute("today",map.get("today"));

		//��ü ���� ��з�
		model.addAttribute("jobTopIndex", recruitService.getJobTopIndexCd());
		//��ü ����� ��з�
		model.addAttribute("topIndustry",recruitService.selectAllTopIndustry());
		return "/recruit/company/companyRecruitList";
	}
	
	
	/* ä�� �Է� ó�� */
	@RequestMapping(value = "/recruitInsert", method = RequestMethod.POST)
	public String recruitInsert(Recruit recruit,HttpSession session,Model model) {
		//���� Ÿ�� �˻� �޼��� 
		boolean result =commons.checkFileType(recruit);
		
		logger.info("tes t{}",recruit.toString());
		//Recruit�� �ʵ��� ����Ʈ�� 0��° - List<CoverletterCompanyJobVo> cCletterArticle �� 0��° �̷���
		logger.info("tes t{}",recruit.getRecruitList().get(0).getcCletterArticle().get(0).getCletterArticle());
		
		//���� Ÿ���� �̹����ϰ�� 
		if(result){
			//��������� ����ڵ带 �˻��Ѵ�
			String companyCd = recruitService.getCompanyCd(recruit.getCompanyName());
			recruit.setCompanyCd(companyCd);
			if(companyCd==null){//db���� �Է��ϰ����ϴ� ����� ������ 
				//������ �ڵ尪�� �����
				int a = recruitService.selectDefaultCd() +1;
				String newConpanyCd = "default" + a;
				//�ڵ尪�� vo�� �����Ѵ� 
				recruit.setCompanyCd(newConpanyCd);
				//��� table�� ������ �ڵ尪�� ȭ�鿡�� �Է¹��� ������� insert�Ѵ�.
				recruitService.insertTemporaryCompany(recruit);
				logger.info("recruit.getCompanyCd(): {}",recruit.getCompanyCd());
			}
				recruitService.insertRecruitCompany(recruit,session);
				recruitService.insertRecruitCompanyJob(recruit);	
			return "redirect:/diary";
		//����Ÿ���� �̹����� �ƴҰ��
		}else{
			model.addAttribute("errorMsg","������Ÿ�� ����ġ");
			
		}
		return "/recruit/company/companyRecruitInsert";
		
	}
	
	
	/* ä�� �Է� ȭ�� */
	@RequestMapping(value = "/recruit", method = RequestMethod.GET)
	public String recruitInsert(Model model,HttpSession session) {
		//��ü ���� ��з�
		model.addAttribute("jobTopIndex", recruitService.getJobTopIndexCd());
		
		//db���� ������ ��ü �����ߺз� �ڵ�� ��������Ʈ�� �𵨿� ��´�
		model.addAttribute("jobMidIndex",recruitService.getJobMidIndexCd());
		//logger.info("recruitService.getJobMidIndexCd() : {}",recruitService.getJobMidIndexCd());
		
		//db���� ������ ��ü �������Ʈ�� �𵨿� ��´�
		List<String> companyList = recruitService.selectCompany();
		//logger.info("companyList : {}",companyList);
		model.addAttribute("companyList", companyList);
		
		//test������ ���ǿ� ���̵� �Է�
		session.setAttribute("id", "id001");
		return "/recruit/company/companyRecruitInsert";
	}
}
