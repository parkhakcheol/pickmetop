package com.cafe24.pickmetop.resume.repository;


import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pickmetop.resume.model.ResumeHighschoolVo;
import com.cafe24.pickmetop.resume.model.ResumeLanguageVo;
import com.cafe24.pickmetop.resume.model.ResumeAwardVo;
import com.cafe24.pickmetop.resume.model.ResumeCareerVo;
import com.cafe24.pickmetop.resume.model.ResumeCertificateVo;
import com.cafe24.pickmetop.resume.model.ResumeClubVo;
import com.cafe24.pickmetop.resume.model.ResumeEtcVo;
import com.cafe24.pickmetop.resume.model.ResumeFamilyVo;
import com.cafe24.pickmetop.resume.model.ResumeMilitaryserviceVo;
import com.cafe24.pickmetop.resume.model.ResumePersonalVo;
import com.cafe24.pickmetop.resume.model.ResumeTrainingVo;
import com.cafe24.pickmetop.resume.model.ResumeUniversityVo;
import com.cafe24.pickmetop.resume.model.ResumeVo;

@Repository
public class ResumeDao {
	private final String nameSpace = "com.cafe24.pickmetop.resume.repository.ResumeMapper";
	@Autowired
	@Resource(name="sqlSessionResume")
	private SqlSessionTemplate sqlSessionFactoryResume;
	
	//01_00 �̷¼��Է�
	public int insertResume(ResumeVo resume){
		return sqlSessionFactoryResume.insert(nameSpace +".insertResume",resume);
	}
	//01_01 ���νŻ�
	public int insertResumePersonal(ResumePersonalVo personal){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumePersonal", personal);
	}
	//01_02 ����б�
	public int insertResumeHighschool(ResumeHighschoolVo highschool){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeHighschool", highschool);
	}
	//01_03 ���б� �����Է�
	public int insertResumeUniversity(ResumeUniversityVo university){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeUniversity", university);
	}
	//01_04 ���� �����Է�
	public int insertResumeFamily(ResumeFamilyVo family){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeFamily", family);
	}
	//01_05 ����
	public int insertResumeMilitaryservice(ResumeMilitaryserviceVo militaryService){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeMilitaryservice", militaryService);
	}
	//01_06 �ڰ��� �����Է�
	public int insertResumeCertificate(ResumeCertificateVo certificate){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeCertificate", certificate);
	}
	//01_07 ��»��� �����Է�
	public int insertResumeCareer(ResumeCareerVo career){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeCareer", career);
	}
	//01_08 ���� �����Է�
	public int insertResumeLanguage(ResumeLanguageVo language){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeLanguage", language);
	}
	//01_09 ������ �����Է�
	public int insertResumeAward(ResumeAwardVo award){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeAward", award);
	}
	//01_10 �����ܿ��� �����Է�
	public int insertResumeTraining(ResumeTrainingVo training){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeTraining", training);
	}
	//01_11 ���Ƹ� �����Է�
	public int insertResumeClub(ResumeClubVo club){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeClub", club);
	}
	//01_12 ��Ÿ �����Է�
	public int insertResumeEtc(ResumeEtcVo etc){
		return sqlSessionFactoryResume.insert(nameSpace + ".insertResumeEtc", etc);
	}
	
	
	
	//02 �̷¼� ����Ʈ
	public List<ResumeVo> selectResumeList(){
		return sqlSessionFactoryResume.selectList(nameSpace + ".selectResumeList");
	}
	//03 �̷¼� �󼼺���
	public ResumeVo selectResumeDetailByResumeCd(String resumeCd){
		return sqlSessionFactoryResume.selectOne(nameSpace + ".selectResumeDetailByResumeCd", resumeCd);
	}
	
	//�̷¼� ����
	
	//�̷¼� ����
	
}
