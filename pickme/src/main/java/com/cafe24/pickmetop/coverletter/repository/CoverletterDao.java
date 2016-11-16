package com.cafe24.pickmetop.coverletter.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pickmetop.coverletter.model.CoverletterCompanyJobInfoVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterCompanyJobVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberArticleSaveVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberArticleVo;
import com.cafe24.pickmetop.coverletter.model.CoverletterMemberVo;

@Repository
public class CoverletterDao {
	final static Logger logger = LoggerFactory.getLogger(CoverletterDao.class);
	private final String nameSpace = "com.cafe24.pickmetop.coverletter.repository.CoverletterMapper";
	@Autowired
	@Resource(name="sqlSessionCoverletter")
	private SqlSessionTemplate sqlSessionFactoryCoverletter;
	
	// 01 ȸ���� �ۼ��� �ڱ�Ұ��� ����Ʈ
	public List<CoverletterMemberVo> selectCoverletterMemberList(){
		return sqlSessionFactoryCoverletter.selectList(nameSpace + ".selectCoverletterMemberList");
	}
	
	// 02 ���ä������� ����������Ʈ(�ڱ�Ұ����� �˻��̳� üũ����Ʈ üũ�� ���� �Է�ȭ������ �̵�)
	public List<CoverletterCompanyJobInfoVo> selectCoverletterCompanyJobList(){
		return sqlSessionFactoryCoverletter.selectList(nameSpace+".selectCoverletterCompanyJobList");
	}
	
	// 03_01 �ڱ�Ұ��� �Է�ȭ��(ä������/ä���/ä������/ä�������/ä�븶������)
	public CoverletterCompanyJobInfoVo selectOneCletterCompanyJobInfo(String recruitJobCd){
		logger.info("�ڼҼ��Է�ȭ�� : ������ ä������ {} ", recruitJobCd.toString());
		return sqlSessionFactoryCoverletter.selectOne(nameSpace+".selectOneCletterCompanyJobInfo", recruitJobCd);
	}
	
	// 03_02 �ڱ�Ұ��� �Է�ȭ��(�ڱ�Ұ��� �׸񸮽�Ʈ)
	public List<CoverletterCompanyJobVo> selectListCletterArticleByJobCd(String recruitJobCd){
		logger.info("�ڼҼ��Է�ȭ��: �ڼҼ��׸񸮽�Ʈ {}", recruitJobCd.toString());
		return sqlSessionFactoryCoverletter.selectList(nameSpace+".selectListCletterArticleByJobCd", recruitJobCd);
	}
	
	// 03_03 �ڱ�Ұ��� �Է�ó��
	public int insertCoverletter(CoverletterMemberVo coverletterMember){
		return sqlSessionFactoryCoverletter.insert(nameSpace + ".insertCoverletter", coverletterMember);
	}
	// 03_04 �ڱ�Ұ��� �׸� �Է�ó��
	public int insertCoverletterArticle(CoverletterMemberArticleVo memberArticle){
		return sqlSessionFactoryCoverletter.insert(nameSpace + ".insertCoverletterArticle", memberArticle);
	}
	// 03_05 �ڱ�Ұ��� ������ �Է�ó��
	public int insertCoverletterSaveRecord(CoverletterMemberArticleSaveVo saveRecord){
		return sqlSessionFactoryCoverletter.insert(nameSpace + ".insertCoverletterSaveRecord", saveRecord);
	}
	
	// 04_01 ȸ���� �ڱ�Ұ��� ����
	public CoverletterMemberVo selectOneMemeberCoverletterInfo(String mCletterCd){
		logger.info("�ڱ�Ұ��� ���� : {}", mCletterCd.toString());
		return sqlSessionFactoryCoverletter.selectOne(nameSpace+".selectOneMemeberCoverletterInfo", mCletterCd);
	}
	
	// 04_02 ȸ���� �ۼ��� �ڱ�Ұ��� �׸� �� ���� ����Ʈ
	public List<CoverletterMemberArticleVo> selectMemeberCoverletterArticleList(String mCletterCd){
		logger.info("�ڱ�Ұ��� �׸� �� ���� ����Ʈ : {}", mCletterCd.toString());
		return sqlSessionFactoryCoverletter.selectList(nameSpace+".selectMemeberCoverletterArticleList", mCletterCd);
	}
	
	// 04_03 ȸ���� �ۼ��� �ڱ�Ұ��� ������
	public CoverletterMemberArticleSaveVo selectMemeberCoverletterArticleSaveRecord(String mCletterCd){
		logger.info("�ڱ�Ұ��� ������ : {}", mCletterCd.toString());
		return sqlSessionFactoryCoverletter.selectOne(nameSpace+".selectMemeberCoverletterArticleSaveRecord", mCletterCd);
	}
	
}
