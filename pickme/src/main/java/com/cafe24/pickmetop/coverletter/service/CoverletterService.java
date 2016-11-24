package com.cafe24.pickmetop.coverletter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pickmetop.coverletter.model.CoverletterCompanyJobInfoVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberArticleSaveVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberArticleVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberVo;
import com.cafe24.pickmetop.coverletter.repository.CoverletterDao;


@Service
public class CoverletterService {
	final static Logger logger = LoggerFactory.getLogger(CoverletterService.class);
	@Autowired
	CoverletterDao coverletterDao;
	
	// 00 ���� ������ �����ӹ� ���ä�����(10��)
	public List<CoverletterCompanyJobInfoVo> getCompanyJobCoverletterListForInfo(String LoginId){
		return coverletterDao.selectCoverletterCompanyJobListForInfo(LoginId);
	}
	
	// 01 �ڱ�Ұ��� ����Ʈ(ȸ���� ���� �ۼ��� �ڱ�Ұ��� ����Ʈ)
	public List<CoverletterMemberVo> getMemberCoverletterList(String loginId){
		return coverletterDao.selectCoverletterMemberList(loginId);
	}
	
	// 02 ���ä������� �ڱ�Ұ��� ����Ʈ(�ڱ�Ұ����� �˻��̳� üũ����Ʈ üũ�� ���� �Է�ȭ������ �̵�)
	public List<CoverletterCompanyJobInfoVo> getCompanyJobCoverletterList(){
		return coverletterDao.selectCoverletterCompanyJobList();
	}
	
	// 03_01 �ڱ�Ұ��� �Է�ȭ��(�ڱ�Ұ����̸�(ä������+ä���+������), �ڱ�Ұ��� ���� ��������, ä�������� �ڱ�Ұ����׸񸮽�Ʈ)
	public Map<String, Object> getCompanyOneJobCletter(String recruitJobCd){
		Map<String, Object> companyOneJobMap = new HashMap<String, Object>();
		companyOneJobMap.put("companyOneJobCletterInfo", coverletterDao.selectOneCletterCompanyJobInfo(recruitJobCd));
		logger.info("companyOneJobCletterInfo {}", companyOneJobMap.toString());
		companyOneJobMap.put("companyOneJobArticleList", coverletterDao.selectListCletterArticleByJobCd(recruitJobCd));
		logger.info("companyOneJobArticleList {}", companyOneJobMap.toString());
		return companyOneJobMap;
	}
	
	// 03_02 �ڱ�Ұ��� �Է�ó��(�ڱ�Ұ��� �̸�/�����ð�/����/����)
	public void addCoverletter(CoverletterMemberVo coverletterMember, 
							CoverletterMemberArticleVo memberArticle,
							CoverletterMemberArticleSaveVo saveRecord,
							HttpSession session
							){
		coverletterMember.setLoginId((String) session.getAttribute("generalId"));
		coverletterDao.insertCoverletter(coverletterMember);
		coverletterDao.insertCoverletterArticle(memberArticle);
		coverletterDao.insertCoverletterSaveRecord(saveRecord);
		logger.info("coverletterMember {}", coverletterMember.toString());
		logger.info("memberArticle {}", memberArticle.toString());
		logger.info("saveRecord {}", saveRecord.toString());
	}
	
	// 03_02 �ڱ�Ұ��� �󼼺���
	public Map<String, Object> getMemberCoverletter(String mCletterCd){
		Map<String, Object> memberCoverletterMap = new HashMap<String, Object>();
		memberCoverletterMap.put("memeberCoverletterInfo", coverletterDao.selectOneMemeberCoverletterInfo(mCletterCd));
		logger.info("memeberCoverletterInfo {}", memberCoverletterMap.toString());
		memberCoverletterMap.put("memeberCoverletterArticleList", coverletterDao.selectMemeberCoverletterArticleList(mCletterCd));
		logger.info("memeberCoverletterArticleList {}", memberCoverletterMap.toString());
		memberCoverletterMap.put("memeberCoverletterArticleSaveRecord", coverletterDao.selectMemeberCoverletterArticleSaveRecord(mCletterCd));
		logger.info("memeberCoverletterArticleSaveRecord {}", memberCoverletterMap.toString());
		return memberCoverletterMap;
	}
	
	// 04_01 ���� �ڱ�Ұ��� & �̷¼� ����
	public Map<String, Object> getMemberInfo(String loginId){
		return null;
	}
	
	// 05_01_01 �հ��ڱ�Ұ��� ����Ʈ(�˾���:�����)
	// 05_01_02 �հ��ڱ�Ұ��� ����Ʈ(��������������: ������)
	// 05_02 �հ��ڱ�Ұ��� �Է���
	// 05_03 �հ��ڱ�Ұ��� �Է�ó��
	// 05_04 �հ��ڱ�Ұ��� �󼼺���
	// 05_05 �հ��ڱ�Ұ��� ����
	// 05_06 �հ��ڱ�Ұ��� ����
	
	
}
