package com.cafe24.pickmetop.freeboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreeboardController {
	final static Logger Logger = LoggerFactory.getLogger(FreeboardController.class);
	
	//입력처리
	@RequestMapping(value="/freeboardInsert", method = RequestMethod.GET)
	public String freeboardInsert(){
		return "redirect:/freeboardList";
	}

	
	//리스트
	@RequestMapping(value="/freeboardList", method = RequestMethod.GET)
	public String freeboardList(){
		return "/freeboard/freeboardList";
	}
	
}
