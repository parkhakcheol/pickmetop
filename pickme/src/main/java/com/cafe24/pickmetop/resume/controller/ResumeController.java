package com.cafe24.pickmetop.resume.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.cafe24.pickmetop.resume.service.ResumeService;


@Controller
public class ResumeController {
	final static Logger Logger = LoggerFactory.getLogger(ResumeController.class);
	@Autowired
	private ResumeService resumeService;
	
	//01 �̷¼� �Է�ȭ��
	@RequestMapping(value="/resumeInsert", method = RequestMethod.GET)
	public String resumeInsert(){
		return "/resume/resumeInsert";
	}
	/*//02 �̷¼� �Է�ó��
	@RequestMapping(value="/resumeInsert", method = RequestMethod.POST)
	public String resumeInsert(ResumeVo resume){
		resumeService.addResume(resume);
		Logger.info(resume.toString());
		return "/resume/resumeInsert";
	}*/
	//02 �̷¼� �Է�ó��
	@RequestMapping(value="/resumeInsert", method = RequestMethod.POST)
	public String resumeInsert(ResumeVo resumeVo, ResumePersonalVo resumePersonalVo, ResumeHighschoolVo resumeHighschoolVo, ResumeUniversityVo resumeUniversityVo, 
			ResumeFamilyVo resumeFamilyVo, ResumeMilitaryserviceVo resumeMilitaryserviceVo, ResumeCertificateVo resumeCertificateVo, ResumeCareerVo resumeCareerVo, 
			ResumeLanguageVo resumeLanguageVo, ResumeAwardVo resumeAwardVo, ResumeTrainingVo resumeTrainingVo, ResumeClubVo resumeClubVo, ResumeEtcVo resumeEtcVo){
		Logger.info("�̷¼� �Է� : {}", resumeVo.toString());
		Logger.info("���νŻ� �Է� : {}", resumePersonalVo.toString());
		Logger.info("����б� �Է� : {}", resumeHighschoolVo.toString());
		Logger.info("���б� �Է� : {}", resumeUniversityVo.toString());
		Logger.info("���� �Է� : {}", resumeFamilyVo.getResumeFamilyVoList().toString());
		Logger.info("���� �Է� : {}", resumeMilitaryserviceVo.toString());
		Logger.info("�ڰ��� �Է� : {}", resumeCertificateVo.toString());
		Logger.info("��� �Է� : {}", resumeCareerVo.toString());
		Logger.info("���� �Է� : {}", resumeLanguageVo.toString());
		Logger.info("�����̷� �Է� : {}", resumeAwardVo.toString());
		Logger.info("�����ܿ��� �Է� : {}", resumeTrainingVo.toString());
		Logger.info("���Ƹ�, ��ȣȸ �Է� : {}", resumeClubVo.toString());
		Logger.info("��Ÿ,��Ʈ������ �Է� : {}", resumeEtcVo.toString());
		resumeService.addResume(resumeVo, resumePersonalVo, resumeHighschoolVo, resumeUniversityVo, resumeFamilyVo, resumeMilitaryserviceVo, 
				resumeCertificateVo, resumeCareerVo, resumeLanguageVo, resumeAwardVo, resumeTrainingVo, resumeClubVo, resumeEtcVo);
		return "/resume/resumeInsert";
	}
	
	//03 �̷¼� ����Ʈ
	@RequestMapping(value="/resumeList", method = RequestMethod.GET)
	public String resumeList(Model model){
		model.addAttribute("resumeList", resumeService.getResumeList());
		Logger.info("�̷¼� ����Ʈ : {}", model.toString());
		return "/resume/resumeList";
	}
	
	//04 �̷¼� �󼼺���
	@RequestMapping(value="/resumeDetail", method = RequestMethod.GET)
	public String resumeDetail(Model model, @RequestParam(value="resumeCd") String resumeCd){
		model.addAttribute("resumeDetail", resumeService.getResumeDetail(resumeCd));
		Logger.info(model.toString());
		Logger.info(resumeCd.toString());
		return "/resume/resumeDetail";
	}
	
	
	//05 �̷¼� ����ó��
	//@RequestMapping(value="/resumeUpdate", method = RequestMethod.POST)
	//06 �̷¼� ����
	//@RequestMapping(value="/resumeDelete", method = RequestMethod.POST)
	
	//00 �ڰ��� �� ���� �˻�������
	@RequestMapping(value="/resumeCertilangIndex", method = RequestMethod.GET)
	public String resumeCertilangIndex(){
		return "/resume/resumeCertilangIndex";
	}
}
