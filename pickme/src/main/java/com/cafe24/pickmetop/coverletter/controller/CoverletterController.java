package com.cafe24.pickmetop.coverletter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pickmetop.coverletter.model.CoverletterMemberVo;
import com.cafe24.pickmetop.coverletter.service.CoverletterService;

@Controller
public class CoverletterController {
	final static Logger Logger = LoggerFactory.getLogger(CoverletterController.class);
	@Autowired
	private CoverletterService coverletterService;
	
	// 01 �ڱ�Ұ��� ����Ʈ(ȸ���� ���� �ۼ��� �ڱ�Ұ��� ����Ʈ)
	@RequestMapping(value="/memberCoverletterList", method = RequestMethod.GET)
	public String memberCoverletterList(Model model){
		model.addAttribute("memberCoverletterList", coverletterService.getMemberCoverletterList());
		Logger.info("ȸ���ڱ�Ұ��� ����Ʈ : {}", model.toString());
		return "/coverletter/member/memberCoverletterList";
	}
	
	// 02 ���ä������� �ڱ�Ұ��� ����Ʈ(�ڱ�Ұ����� �˻��̳� üũ����Ʈ üũ�� ���� �Է�ȭ������ �̵�)
	@RequestMapping(value="/companyJobCoverletterList", method = RequestMethod.GET)
	public String companyJobCoverletterList(Model model){
		model.addAttribute("companyJobCoverletterList", coverletterService.getCompanyJobCoverletterList());
		Logger.info("���ä������� �ڱ�Ұ��� ����Ʈ {}", model.toString());
		return "/coverletter/admin/companyJobCoverletterList";
	}
	// 03 �ڱ�Ұ��� �Է�ȭ��() = �ϳ��� ���ä����� �ڱ�Ұ��� �׸񸮽�Ʈ �󼼺���
	@RequestMapping(value="/memberCoverletterInsert", method = RequestMethod.GET)
	public String memberCoverletterInsert(Model model, @RequestParam(value="recruitJobCd") String recruitJobCd){
		model.addAttribute("memberCoverletterInsert", coverletterService.getCoverletterCompanyJobVo(recruitJobCd));
		Logger.info("memberCoverletterInsert �ڱ�Ұ��� �Է�ȭ�� {}", model.toString());
		Logger.info("recruitJobCd ��������ڵ� {}", recruitJobCd.toString());
		return "/coverletter/member/memberCoverletterInsert";
	}
	// 04 �ڱ�Ұ��� �Է�ó��()
	@RequestMapping(value="/memberCoverletterInsert", method = RequestMethod.POST)
	public String memberCoverletterInsert(Model model, CoverletterMemberVo coverletterMemberVo){
		//model.addAttribute("memberCoverletterInsert", coverletterService.get)
		coverletterService.addMemberCoverletter(coverletterMemberVo);
		return "/coverletter/member/memberCoverletterInsert";
	}
	// 05 �ڱ�Ұ��� �󼼺���(����ȭ��� ����, �����ϸ���Ʈ)
	
	// 06 �ڱ�Ұ��� ����ó��(����Ʈ���� �ٷ� ����ó��)
}
