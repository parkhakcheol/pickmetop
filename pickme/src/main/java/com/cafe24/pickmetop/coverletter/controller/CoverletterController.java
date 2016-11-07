package com.cafe24.pickmetop.coverletter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	// 02 ���ä�� ���� ����Ʈ(�ڱ�Ұ��� �˻��̳� üũ����Ʈ üũ�� ���� �Է�ȭ������ �̵�)
	
	// 03 �ڱ�Ұ��� �Է�ȭ��(ä�������Ʈ �˻��� ������� ȭ�鱸��)
	
	// 04 �ڱ�Ұ��� �Է�ȭ��(�⺻�ڼҼ� ȭ�� ����)
	
	// 05 �ڱ�Ұ��� �󼼺���(����ȭ��� ����, �����ϸ���Ʈ)
	
	// 06 �ڱ�Ұ��� ����ó��(����Ʈ���� �ٷ� ����ó��)
}
