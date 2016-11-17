package com.cafe24.pickmetop.coverletter.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pickmetop.coverletter.model.CoverletterMemberArticleSaveVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberArticleVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberVo;
import com.cafe24.pickmetop.coverletter.service.CoverletterService;

@Controller
public class CoverletterController {
	final static Logger Logger = LoggerFactory.getLogger(CoverletterController.class);
	@Autowired
	private CoverletterService coverletterService;
	
	
	// 00 �ڱ�Ұ��� ����������
	@RequestMapping(value="/coverletterIndex", method = RequestMethod.GET)
	public String coverletterIndex(Model model){
		Logger.info("�ڱ�Ұ��� ����������:{}" , model.toString());
		return "/coverletter/coverletterIndex";
	}
	
	// 01_01 �ڱ�Ұ��� ����Ʈ(ȸ���� ���� �ۼ��� �ڱ�Ұ��� ����Ʈ) : ����Ʈ������ ����
	@RequestMapping(value="/memberCoverletterList", method = RequestMethod.GET)
	public String memberCoverletterList(Model model){
		model.addAttribute("memberCoverletterList", coverletterService.getMemberCoverletterList());
		Logger.info("ȸ���ڱ�Ұ��� ����Ʈ : {}", model.toString());
		return "/coverletter/member/memberCoverletterList";
	}
	
	// 01_02 �ڱ�Ұ��� ����Ʈ(ȸ���� ���� �ۼ��� �ڱ�Ұ��� ����Ʈ) : ��������� ����
	@RequestMapping(value="/memberCoverletterListForModal", method = RequestMethod.GET)
	public String memberCoverletterListForMordal(Model model){
		model.addAttribute("memberCoverletterListForModal", coverletterService.getMemberCoverletterList());
		Logger.info("ȸ���ڱ�Ұ��� ����Ʈ for Mordal : {}", model.toString());
		return "/coverletter/member/memberCoverletterListForModal";
	}
	
	// 02 ���ä������� �ڱ�Ұ��� ����Ʈ(�ڱ�Ұ����� �˻��̳� üũ����Ʈ üũ�� ���� �Է�ȭ������ �̵�)
	@RequestMapping(value="/companyJobCoverletterList", method = RequestMethod.GET)
	public String companyJobCoverletterList(Model model){
		model.addAttribute("companyJobCoverletterList", coverletterService.getCompanyJobCoverletterList());
		Logger.info("���ä������� �ڱ�Ұ��� ����Ʈ {}", model.toString());
		return "/coverletter/admin/companyJobCoverletterList"; 
	}
	
	// 03_01 �ڱ�Ұ��� �Է�ȭ��(ä�������ڵ�/ä������/ä���/�����ߺз���/��������/ä�븶������/����ڱ�Ұ����׸񸮽�Ʈ)
	@RequestMapping(value="/memberCoverletterInsert", method = RequestMethod.GET)
	public String memberCoverletterInsertForm(Model model, @RequestParam(value="recruitJobCd") String recruitJobCd){
		Map<String, Object> companyOneJobCletter = coverletterService.getCompanyOneJobCletter(recruitJobCd);
		Logger.info("�ڱ�Ұ��� �Է�ȭ�� {}", model.toString());
		model.addAttribute("companyOneJobCletterInfo", companyOneJobCletter.get("companyOneJobCletterInfo"));
		Logger.info("companyOneJobCletterInfo : {}", companyOneJobCletter.get("companyOneJobCletterInfo").toString());
		model.addAttribute("companyOneJobArticleList", companyOneJobCletter.get("companyOneJobArticleList"));
		Logger.info("companyOneJobArticleList : {}", companyOneJobCletter.get("companyOneJobArticleList").toString());
		return "/coverletter/member/memberCoverletterInsert";
	}
	
	// 03_02 �ڱ�Ұ��� �Է�ó��(�ڱ�Ұ��� �̸�/�����ð�/����/����)
	@RequestMapping(value="/memberCoverletterInsert", method = RequestMethod.POST)
	public String memberCoverletterInsert(CoverletterMemberVo coverletterMember, CoverletterMemberArticleVo memberArticle, CoverletterMemberArticleSaveVo saveRecord){
		coverletterService.addCoverletter(coverletterMember, memberArticle, saveRecord);
		Logger.info("coverletterMember {}", coverletterMember.toString());
		Logger.info("memberArticle {}", memberArticle.toString());
		Logger.info("saveRecord {}", saveRecord.toString());
		
		return "redirect:/memberCoverletterList";
	}
	
	// 04_01 ȸ���� �ۼ��� �ڱ�Ұ��� �󼼺���  
	@RequestMapping(value="/memberCoverletterDetail", method = RequestMethod.GET)
	public String memberCoverletterDetail(Model model, @RequestParam(value="mCletterCd") String mCletterCd){
		Map<String, Object> memberCoverletter = coverletterService.getMemberCoverletter(mCletterCd);
		model.addAttribute("memeberCoverletterInfo", memberCoverletter.get("memeberCoverletterInfo"));
		Logger.info("memeberCoverletterInfo {}", model.toString());
		model.addAttribute("memeberCoverletterArticleList", memberCoverletter.get("memeberCoverletterArticleList"));
		Logger.info("memeberCoverletterArticleList{}", model.toString());
		model.addAttribute("memeberCoverletterArticleSaveRecord", memberCoverletter.get("memeberCoverletterArticleSaveRecord"));
		Logger.info("memeberCoverletterArticleSaveRecord{}", model.toString());
		return "/coverletter/member/memberCoverletterDetail";
	}
	
	// 04_01 ȸ���� �ۼ��� �ڱ�Ұ��� ������Ʈ  
	@RequestMapping(value="/memberCoverletterUpdateForm", method = RequestMethod.GET)
	public String memberCoverletterUpdateForm(Model model, @RequestParam(value="mCletterCd") String mCletterCd){
		Map<String, Object> memberCoverletter = coverletterService.getMemberCoverletter(mCletterCd);
		model.addAttribute("memeberCoverletterInfo", memberCoverletter.get("memeberCoverletterInfo"));
		Logger.info("memeberCoverletterInfo {}", model.toString());
		model.addAttribute("memeberCoverletterArticleList", memberCoverletter.get("memeberCoverletterArticleList"));
		Logger.info("memeberCoverletterArticleList{}", model.toString());
		model.addAttribute("memeberCoverletterArticleSaveRecord", memberCoverletter.get("memeberCoverletterArticleSaveRecord"));
		Logger.info("memeberCoverletterArticleSaveRecord{}", model.toString());
		return "/coverletter/member/memberCoverletterUpdate";
	}	
		
}
