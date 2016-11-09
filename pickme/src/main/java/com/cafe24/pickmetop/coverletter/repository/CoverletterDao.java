package com.cafe24.pickmetop.coverletter.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	// 02 ���ä������� �ڱ�Ұ��� ����Ʈ(�ڱ�Ұ����� �˻��̳� üũ����Ʈ üũ�� ���� �Է�ȭ������ �̵�)
	public List<CoverletterCompanyJobVo> selectCoverletterCompanyJobList(){
		return sqlSessionFactoryCoverletter.selectList(nameSpace+".selectCoverletterCompanyJobList");
	}
	
	// 03 �ڱ�Ұ��� �Է�ȭ��() = �ϳ��� ���ä����� �ڱ�Ұ��� �׸񸮽�Ʈ �󼼺���
	public CoverletterCompanyJobVo selectCoverletterCompanyJobByRecruitJobCd(String recruitJobCd){
		return sqlSessionFactoryCoverletter.selectOne(nameSpace+".selectCoverletterCompanyJobByRecruitJobCd", recruitJobCd);
	}
	
	public int insertMemberCoverletter(CoverletterMemberVo coverletterMemberVo){
		return sqlSessionFactoryCoverletter.insert(nameSpace+".insertMemberCoverletter", coverletterMemberVo);
	}
}
