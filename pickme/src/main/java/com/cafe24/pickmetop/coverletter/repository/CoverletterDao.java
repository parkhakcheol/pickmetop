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
		logger.info("�ڼҼ��Է�ȭ�� : ������ ä������ {} ", recruitJobCd);
		return sqlSessionFactoryCoverletter.selectOne(nameSpace+".selectOneCletterCompanyJobInfo", recruitJobCd);
	}
	
	// 03_02 �ڱ�Ұ��� �Է�ȭ��(�ڱ�Ұ��� �׸񸮽�Ʈ)
	public List<CoverletterCompanyJobVo> selectListCletterArticleByJobCd(String recruitJobCd){
		logger.info("�ڼҼ��Է�ȭ��: �ڼҼ��׸񸮽�Ʈ {}", recruitJobCd);
		return sqlSessionFactoryCoverletter.selectList(nameSpace+".selectListCletterArticleByJobCd", recruitJobCd);
	}
	
}
