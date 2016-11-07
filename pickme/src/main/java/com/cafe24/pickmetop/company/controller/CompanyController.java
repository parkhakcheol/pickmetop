package com.cafe24.pickmetop.company.controller;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pickmetop.company.model.CompanyReviewVo;
import com.cafe24.pickmetop.company.service.CompanyService;

@Controller
public class CompanyController {
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	CompanyService companyService;
	
	//������� ����
	@RequestMapping(value = "/companyInfo", method = RequestMethod.GET)
	public String companyMain(Locale locale, Model model) {
		model.addAttribute("companyTotalRateList", companyService.getCompanyTotalRateTop());
		return "/companyinfo/companymain";
	}
	//�����ı� ����� ����Ʈ(������) ����
	@RequestMapping(value = "/interview/companyInterviewUnreceivedList", method = RequestMethod.GET)
	public String companyInterviewUnreceivedList(Model model, @RequestParam(value="page", defaultValue="1") int page) {
		model.addAttribute("page", page);
		model.addAttribute("interviewUnreceivedMap", companyService.getCompanyInterviewUnreceivedList(page));
		return "/companyinfo/interview/companyInterviewList";
	}
	
	//������� ����ڸ���Ʈ ����
	@RequestMapping(value = "/review/companyReviewListAllow", method = RequestMethod.GET)
	public String companyReviewListAllow(Model model, @RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="jobTopIndexCd", defaultValue="") String jobTopIndexCd) {
		Map<String, Object> companyReviewMap = companyService.getCompanyReviewAllowList(page, jobTopIndexCd);
		model.addAttribute("page", page);
		logger.info("jobTopIndexCd : {}",jobTopIndexCd);
		model.addAttribute("jobTopIndexCd", jobTopIndexCd);	
		model.addAttribute("jobTopIndexList",companyService.getJobTopIndexList());
		model.addAttribute("reviewListAllow", companyReviewMap.get("reviewListAllow"));
		logger.info("jobTopIndexCd : {}",companyReviewMap.get("reviewListAllow").toString());
		model.addAttribute("startPage", companyReviewMap.get("startPage"));
		model.addAttribute("endPage", companyReviewMap.get("endPage"));		
		return "/companyinfo/review/companyReviewList";
	}
	//������� ����ó�� ����
	@RequestMapping(value = "/review/companyReviewDelete", method = RequestMethod.GET)
	public String companyReviewDelete(@RequestParam(value="companyReviewCd") int companyReviewCd) {
		companyService.deleteCompanyReview(companyReviewCd);
		return "redirect:/review/companyReviewUnreceivedList";
	}
	
	//������� ����ó�� ����
	@RequestMapping(value = "/review/companyReviewAllow", method = RequestMethod.GET)
	public String companyReviewAllow(@RequestParam(value="companyReviewCd") int companyReviewCd) {
		companyService.updateCompanyReviewAllow(companyReviewCd);
		return "redirect:/review/companyReviewUnreceivedList";
	}
	
	//������� �󼼺���(������)
	@RequestMapping(value = "/review/companyReviewDetail", method = RequestMethod.GET)
	public String companyReviewDetail(Model model, @RequestParam(value="companyReviewCd") int companyReviewCd) {
		model.addAttribute("reviewDetail", companyService.getCompanyReviewDetail(companyReviewCd));
		return "/companyinfo/review/companyReviewDetail";
	}
	
	//������� ����θ���Ʈ(������)
	@RequestMapping(value = "/review/companyReviewUnreceivedList", method = RequestMethod.GET)
	public String companyReviewUnreceivedList(Model model, @RequestParam(value="page", defaultValue="1") int page) {
		model.addAttribute("page", page);
		model.addAttribute("reviewUnreceivedMap", companyService.getCompanyReviewUnreceivedList(page));
		return "/companyinfo/review/companyReviewUnreceivedList";
	}
	
	//������� ���ó�� ����
	@RequestMapping(value = "/review/companyReviewInsert", method = RequestMethod.POST)
	public String companyReviewInsert(CompanyReviewVo companyReviewVo, @RequestParam(value="companyName") String companyName){
		logger.info("command param companyReview:{}", companyReviewVo.toString());
		companyService.addCompanyReview(companyReviewVo, companyName);
		return "/companyinfo/companymain";
	}
	
	//������� ���ȭ�� ����
	@RequestMapping(value = "/review/companyReviewInsertForm", method = RequestMethod.GET)
	public String companyReviewInsertForm(Model model) {
		model.addAttribute("companyInfoList", companyService.getCompanyInfoList());
		model.addAttribute("jobTopIndexList", companyService.getJobTopIndexList());
		return "/companyinfo/review/companyReviewInsert";
	}
}
