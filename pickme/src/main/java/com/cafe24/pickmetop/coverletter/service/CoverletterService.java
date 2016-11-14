package com.cafe24.pickmetop.coverletter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 01 �ڱ�Ұ��� ����Ʈ(ȸ���� ���� �ۼ��� �ڱ�Ұ��� ����Ʈ)
	public List<CoverletterMemberVo> getMemberCoverletterList(){
		return coverletterDao.selectCoverletterMemberList();
	}
	
	// 02 ���ä������� �ڱ�Ұ��� ����Ʈ(�ڱ�Ұ����� �˻��̳� üũ����Ʈ üũ�� ���� �Է�ȭ������ �̵�)
	public List<CoverletterCompanyJobInfoVo> getCompanyJobCoverletterList(){
		return coverletterDao.selectCoverletterCompanyJobList();
	}
	
	// 03 �ڱ�Ұ��� �Է�ȭ��(ä������/ä���/ä������/������/ä�븶������, ä�������� �ڱ�Ұ����׸񸮽�Ʈ)
	public Map<String, Object> getCompanyOneJobCletter(String recruitJobCd){
		Map<String, Object> companyOneJobMap = new HashMap<String, Object>();
		companyOneJobMap.put("companyOneJobCletterInfo", coverletterDao.selectOneCletterCompanyJobInfo(recruitJobCd));
		companyOneJobMap.put("companyOneJobArticleList", coverletterDao.selectListCletterArticleByJobCd(recruitJobCd));
		return companyOneJobMap;
	}

	public void addCoverletter(CoverletterMemberVo coverletterMember, CoverletterMemberArticleVo memberArticle,	CoverletterMemberArticleSaveVo saveRecord){
		coverletterMember.setLoginId("walbatrossw@gmail.com");
		coverletterDao.insertCoverletter(coverletterMember);
		coverletterDao.insertCoverletterArticle(memberArticle);
		coverletterDao.insertCoverletterSaveRecord(saveRecord);
	}
	
	// 03_02 �ڱ�Ұ��� �Է� ó��(�ڱ�Ұ��� �̸�/�����ð�/����/����)
	
}
