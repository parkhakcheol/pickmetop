package com.cafe24.pickmetop.resume.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.pickmetop.resume.model.ResumeAwardVo;
import com.cafe24.pickmetop.resume.model.ResumeCareerVo;
import com.cafe24.pickmetop.resume.model.ResumeCertificateVo;
import com.cafe24.pickmetop.resume.model.ResumeClubVo;
import com.cafe24.pickmetop.resume.model.ResumeEtcVo;
import com.cafe24.pickmetop.resume.model.ResumeFamilyVo;
import com.cafe24.pickmetop.resume.model.ResumeHighschoolVo;
import com.cafe24.pickmetop.resume.model.ResumeLanguageVo;
import com.cafe24.pickmetop.resume.model.ResumeMilitaryserviceVo;
import com.cafe24.pickmetop.resume.model.ResumePersonalVo;
import com.cafe24.pickmetop.resume.model.ResumeTrainingVo;
import com.cafe24.pickmetop.resume.model.ResumeUniversityVo;
import com.cafe24.pickmetop.resume.model.ResumeVo;
import com.cafe24.pickmetop.resume.repository.ResumeDao;

@Service
public class ResumeService {
	final static Logger Logger = LoggerFactory.getLogger(ResumeService.class);
	@Autowired
	ResumeDao resumeDao;
	
	// 01_�̷¼� �Է�
	@Transactional
	public void addResume(ResumeVo resumeVo, ResumePersonalVo resumePersonalVo, ResumeHighschoolVo resumeHighschoolVo, ResumeUniversityVo resumeUniversityVo, 
			ResumeFamilyVo resumeFamilyVo, ResumeMilitaryserviceVo resumeMilitaryserviceVo, ResumeCertificateVo resumeCertificateVo, ResumeCareerVo resumeCareerVo, 
			ResumeLanguageVo resumeLanguageVo, ResumeAwardVo resumeAwardVo, ResumeTrainingVo resumeTrainingVo, ResumeClubVo resumeClubVo, ResumeEtcVo resumeEtcVo){
		
		resumeVo.setLoginId("walbatrossw@gmail.com");
		
		resumeDao.insertResume(resumeVo);
		resumeDao.insertResumePersonal(resumePersonalVo);
		resumeDao.insertResumeHighschool(resumeHighschoolVo);
		resumeDao.insertResumeUniversity(resumeUniversityVo);
		resumeDao.insertResumeFamily(resumeFamilyVo);
		resumeDao.insertResumeMilitaryservice(resumeMilitaryserviceVo);
		resumeDao.insertResumeCertificate(resumeCertificateVo);
		resumeDao.insertResumeCareer(resumeCareerVo);
		resumeDao.insertResumeLanguage(resumeLanguageVo);
		resumeDao.insertResumeAward(resumeAwardVo);
		resumeDao.insertResumeTraining(resumeTrainingVo);
		resumeDao.insertResumeClub(resumeClubVo);
		resumeDao.insertResumeEtc(resumeEtcVo);
		Logger.info("�̷¼� �Է� : {}", resumeVo.toString());
		Logger.info("���νŻ� �Է� : {}", resumePersonalVo.toString());
		Logger.info("����б� �Է� : {}", resumeHighschoolVo.toString());
		Logger.info("���б� �Է� : {}", resumeUniversityVo.toString());
		Logger.info("���� �Է� : {}", resumeFamilyVo.toString());
		Logger.info("���� �Է� : {}", resumeMilitaryserviceVo.toString());
		Logger.info("�ڰ��� �Է� : {}", resumeCertificateVo.toString());
		Logger.info("��� �Է� : {}", resumeCareerVo.toString());
		Logger.info("���� �Է� : {}", resumeLanguageVo.toString());
		Logger.info("�����̷� �Է� : {}", resumeAwardVo.toString());
		Logger.info("�����ܿ��� �Է� : {}", resumeTrainingVo.toString());
		Logger.info("���Ƹ�, ��ȣȸ �Է� : {}", resumeClubVo.toString());
		Logger.info("��Ÿ,��Ʈ������ �Է� : {}", resumeEtcVo.toString());
	}
	
	// 02_�̷¼� ����Ʈ
	public List<ResumeVo> getResumeList(){
		return resumeDao.selectResumeList();
	}
	
	// 03_�̷¼� �󼼺���
	public ResumeVo getResumeDetail(String resumeCd){
		return resumeDao.selectResumeDetailByResumeCd(resumeCd);
	}
	
}
