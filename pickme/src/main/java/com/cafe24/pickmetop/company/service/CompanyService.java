package com.cafe24.pickmetop.company.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pickmetop.admin.model.JobTopIndexVo;
import com.cafe24.pickmetop.commons.PageHelper;
import com.cafe24.pickmetop.company.model.*;
import com.cafe24.pickmetop.company.repository.CompanyDao;


@Service
public class CompanyService {
	private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);
	private final int MAX_LINE_COUNT = 5; //������ ���� ��
    private final int MAX_PAGE_COUNT = 5; //������ �ִ� ������ ��
    
	@Autowired
	CompanyDao companyDao;
	/*---------------------------------------------------------------------------------- 
	 * 									������� ����
	 * ---------------------------------------------------------------------------------*/
	//��� ���� Top10
	public List<CompanyInfoVo> getCompanyTotalRateTop(){
		return companyDao.selectCompanyByTotalRate();
	}
	/*---------------------------------------------------------------------------------- 
	 * 									������� ������
	 * ---------------------------------------------------------------------------------*/ 
	//������� ��� ����Ʈ �� (��������� �˻�����)
	public Map<String, Object> getCompantInfoList(int page, String searchCompanyName){
		PageHelper pageHelper = new PageHelper(page,MAX_LINE_COUNT);
		pageHelper.setLastPage(companyDao.selectCompanyInfoListCount(searchCompanyName), MAX_LINE_COUNT);
		Map<String, Object> companyInfoMap = new HashMap<String, Object>();
		Map<String, Object> companyoInfoSearchMap = new HashMap<String, Object>();
		
		companyoInfoSearchMap.put("pageHelp", pageHelper);
		companyoInfoSearchMap.put("searchCompanyName", searchCompanyName);
		
		companyInfoMap.put("startPage", pageHelper.startPage(page, MAX_PAGE_COUNT));
		companyInfoMap.put("endPage", pageHelper.endPage());
		companyInfoMap.put("companyInfoList", companyDao.selectCompanyInfoList(companyoInfoSearchMap));
		logger.info("listsize : {}", companyDao.selectCompanyInfoList(companyoInfoSearchMap).size());
		return companyInfoMap;
	}
	//������� ������
	public CompanyInfoVo getCompnayInfoDetail(String companyName){
		return companyDao.selectCompanyInfoDetailByCompanyName(companyName);
	}
	
	/*---------------------------------------------------------------------------------- 
	 * 									�����ı� ����
	 * ---------------------------------------------------------------------------------*/ 
	//�����ı� ���
	public int addCompnayInterview(CompanyInterviewVo companyInterviewVo){
		companyInterviewVo.setCompanyCd(companyDao.selectCompanyInfoByCompanyCd(companyInterviewVo.getCompanyName()));
		companyInterviewVo.setLoginId("kji212@naver.com");
		return companyDao.insertCompanyInterview(companyInterviewVo);
	}
	//�����ı� ����� ���
	public Map<String, Object> getCompanyInterviewUnreceivedList(int page){
		//����θ�� ������ ó��
		PageHelper pageHelper = new PageHelper(page,MAX_LINE_COUNT);
		//���λ��°� 0�� ����λ����ΰ͸� ������ ���ͼ� ������������ SET
		String tbName = "tb_company_interview";
		String tbColumn = "interview_allow";
		pageHelper.setLastPage(companyDao.selectAllowTotalCount(tbName, tbColumn, 0),MAX_LINE_COUNT);
		Map<String, Object> interviewUnreceivedMap = new HashMap<String, Object>();
		interviewUnreceivedMap.put("startPage", pageHelper.startPage(page, MAX_PAGE_COUNT));
		interviewUnreceivedMap.put("endPage", pageHelper.endPage());
		interviewUnreceivedMap.put("interviewListUnreceived", companyDao.selectCompanyInterviewListByInterviewUnreceived(pageHelper));
		return interviewUnreceivedMap;
	}
	//�����ı� ������
	public CompanyInterviewVo getCompanyInterviewDetail(int interviewCd){
		return companyDao.selectCompanyInterviewDetailByCompanyInterviewCd(interviewCd);
	}
	//�����ı� ����ó��
	public int updateCompanyInterviewAllow(int interviewCd){
		Map<String, Object> allow = new HashMap<String, Object>();
		allow.put("loginId", "admin");
		allow.put("interviewCd", interviewCd);
		return companyDao.updateCompanyInterviewAllow(allow);
	}
	//�����ı� ����ó��
	public int delectCompanyInterview(int interviewCd){
		return companyDao.deleteCompanyInterview(interviewCd);
	}
	
	 /*---------------------------------------------------------------------------------- 
	 * 									������� ����
	 * ---------------------------------------------------------------------------------*/ 
	 
	//���������(����)
	public Map<String, Object> getCompanyReviewAllowList(int page, String jobTopIndexCd, String searchCompanyName){
		//���θ�� ������ ó��
		PageHelper pageHelper = new PageHelper(page,MAX_LINE_COUNT);
		String tbName = "tb_company_review";
		String tbColumn = "review_allow";
		//���λ��°� 1�� ���λ����ΰ͸� ������ ���ͼ� ������������ SET
		if(jobTopIndexCd.equals("") && searchCompanyName.equals("")){
			logger.info("null");
			pageHelper.setLastPage(companyDao.selectAllowTotalCount(tbName, tbColumn, 1),MAX_LINE_COUNT);
		}else{
			logger.info("not null : {}", companyDao.selectAllowSearchCount(jobTopIndexCd, searchCompanyName));
			pageHelper.setLastPage(companyDao.selectAllowSearchCount(jobTopIndexCd, searchCompanyName),MAX_LINE_COUNT);
		}
		//����¡ ó������ ������������ ��������
		Map<String, Object> reviewAllowMap = new HashMap<String, Object>();
		reviewAllowMap.put("startPage", pageHelper.startPage(page, MAX_PAGE_COUNT));
		reviewAllowMap.put("endPage", pageHelper.endPage());
		
		//�˻��� ������ ���� �˻����ǵ� ��
		Map<String, Object> reviewSearchMap = new HashMap<String, Object>();
		reviewSearchMap.put("pageHelp", pageHelper);
		reviewSearchMap.put("jobTopIndexCd", jobTopIndexCd);
		reviewSearchMap.put("searchCompanyName", searchCompanyName);
		logger.info("pageHelper {}", pageHelper.toString());
		logger.info("jobTopIndexCd {}", jobTopIndexCd.toString());
		logger.info("searchCompanyName {}", searchCompanyName.toString());
		reviewAllowMap.put("reviewListAllow", companyDao.selectCompanyReviewListByReviewAllow(reviewSearchMap));
		return reviewAllowMap;
	}
	
	//������� ����ó��
	public int deleteCompanyReview(int companyReviewCd){
		return companyDao.deleteCompanyReview(companyReviewCd);
	}
	
	//������� ����ó��
	public int updateCompanyReviewAllow(int companyReviewCd){
		Map<String, Object> allow = new HashMap<String, Object>();
		allow.put("loginId", "admin");
		allow.put("companyReviewCd", companyReviewCd);
		companyDao.updateCompanyInfoTotalRate(allow);
		return companyDao.updateCompanyReviewAllow(allow);
	}
	//������� �󼼺���
	public CompanyReviewVo getCompanyReviewDetail(int companyReviewCd){
		return companyDao.selectCompanyListByReviewCd(companyReviewCd);
	}
	
	//���������(�����)
	public Map<String, Object> getCompanyReviewUnreceivedList(int page){
		//����θ�� ������ ó��
		PageHelper pageHelper = new PageHelper(page,MAX_LINE_COUNT);
		String tbName = "tb_company_review";
		String tbColumn = "review_allow";
		//���λ��°� 0�� ����λ����ΰ͸� ������ ���ͼ� ������������ SET
		pageHelper.setLastPage(companyDao.selectAllowTotalCount(tbName, tbColumn, 0),MAX_LINE_COUNT);
		Map<String, Object> reviewUnreceivedMap = new HashMap<String, Object>();
		reviewUnreceivedMap.put("startPage", pageHelper.startPage(page, MAX_PAGE_COUNT));
		reviewUnreceivedMap.put("endPage", pageHelper.endPage());
		reviewUnreceivedMap.put("reviewListUnreceived", companyDao.selectCompanyReviewListByReviewUnreceived(pageHelper));
		return reviewUnreceivedMap;
	}
	
	//���������(�����) �޼���
	public int addCompanyReview(CompanyReviewVo companyReviewVo){
		companyReviewVo.setCompanyCd(companyDao.selectCompanyInfoByCompanyCd(companyReviewVo.getCompanyName()));
		companyReviewVo.setLoginId("kji212@naver.com");
		/*SimpleDateFormat setToday;
		setToday = new SimpleDateFormat("yyyy-mm-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		String today = setToday.format(calendar.getTime());
		companyReviewVo.setReviewRegDate(today);
		companyReviewVo.setReviewModiDate(today);
		logger.info("CompanyService -> today {}",today);*/
		logger.info("CompanyService -> companyCd2 {}", companyReviewVo.getCompanyCd());
		return companyDao.insertCompanyReview(companyReviewVo);
	}
	
	//����̸� ����Ʈ��� �޼���
	public List<CompanyInfoVo> getCompanyNameList(){
		return companyDao.selectCompanyNameList();
	}
	
	//�����ߺз� ����Ʈ ��� �޼���
	public List<JobTopIndexVo> getJobTopIndexList(){
		return companyDao.selectJobTopIndexAllList();
	}
	
}
