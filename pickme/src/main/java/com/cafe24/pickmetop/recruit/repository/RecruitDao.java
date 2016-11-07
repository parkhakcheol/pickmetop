package com.cafe24.pickmetop.recruit.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pickmetop.admin.model.JobMidIndexVo;
import com.cafe24.pickmetop.admin.model.JobTopIndexVo;
import com.cafe24.pickmetop.company.model.CompanyInfoVo;
import com.cafe24.pickmetop.recruit.model.Recruit;
import com.cafe24.pickmetop.recruit.model.RecruitCompany;
import com.cafe24.pickmetop.recruit.model.RecruitCompanyJobVo;
import com.cafe24.pickmetop.recruit.service.RecruitService;

@Repository
public class RecruitDao {
	final static Logger logger = LoggerFactory.getLogger(RecruitDao.class);
	private final String NS = "com.cafe24.pickmetop.recruit.repository.RecruitMapper";
	@Autowired
	@Resource(name = "sqlSessionRecruit")
	private SqlSessionTemplate sqlSessionFactoryRecruit;	
	
	public int insertTemporaryCompany(Recruit recruit){
		return sqlSessionFactoryRecruit.insert(NS+".insertTemporaryCompany",recruit);
	}
	
	//default����ڵ� ������ 
	public int selectDefaultCd(){
		return sqlSessionFactoryRecruit.selectOne(NS+".selectDefaultCd");
	}
	
	//��ü ���� ��з�
	public List<JobTopIndexVo> getJopTopIndexCd(){
		return sqlSessionFactoryRecruit.selectList(NS+".getJobTopIndexCd");
	}
	
	//��ü ���� �ߺз� 
	public List<JobMidIndexVo> getJobMidIndexCd(){
		return sqlSessionFactoryRecruit.selectList(NS+".getJobMidIndexCd");
	}
	
	//RecruitCompanyJob�� ��ü���� �˻�
	public int getCountOfRecruitJob(){
		return sqlSessionFactoryRecruit.selectOne(NS+".getCountOfRecruitJob");
	}
	
	//RecruitCompany ��ü �Է°����� �˻�
	public int getCountOfRecruit(){
		return sqlSessionFactoryRecruit.selectOne(NS+".getCountOfRecruit");
	}
	
	//��������� ����ڵ带 �˻�
	public String getCompanyCd(String companyName){
		return sqlSessionFactoryRecruit.selectOne(NS+".getCompanyCd",companyName);
	}
	
	//��ü ������� �˻�
	public List<String> selectCompany(){
		return sqlSessionFactoryRecruit.selectList(NS+".selectCompany");
	}
	
	//RecruitCompanyJob�Է� 
	public int insertRecruitJob(RecruitCompanyJobVo recruitCompanyJobVo){
		return sqlSessionFactoryRecruit.insert(NS+".insertRecruitJob",recruitCompanyJobVo);
	}
	
	
	//RecruitCompany�Է�
	public int insertRecruitCompany(RecruitCompany recruitCompany){
		return sqlSessionFactoryRecruit.insert(NS+".insertRecruit",recruitCompany);
	}
}
