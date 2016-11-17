package com.cafe24.pickmetop.freeboard.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pickmetop.freeboard.model.FreeboardReplyVo;
import com.cafe24.pickmetop.freeboard.model.FreeboardVo;
import com.cafe24.pickmetop.freeboard.service.FreeboardService;

@Controller
public class FreeboardController {
	final static Logger logger = LoggerFactory.getLogger(FreeboardController.class);
	@Autowired
	FreeboardService freeService;
	
	//�Է�ó��
	@RequestMapping(value="/freeboardInsert", method = RequestMethod.GET)
	public String freeboardInsert(HttpSession session,FreeboardVo freeboardVo){
		//���̵�, ����, �г���, ī���ڵ�
		//test Id ��
	
		freeService.freeboardInsert(freeboardVo,session);
		return "redirect:/freeboardList";
	}

	
	//����Ʈ & �˻� 
	@RequestMapping(value="/freeboardList", method = RequestMethod.GET)
	public String freeboardList(Model model,
			@RequestParam(value="cate", defaultValue="") String freeboardCate,
			@RequestParam(value="boardSearch", defaultValue="") String boardSearch){
		Map Listmap=freeService.selectFreeboardList(freeboardCate,boardSearch);
		model.addAttribute("freeList",Listmap.get("boardList"));
		model.addAttribute("cateForView",Listmap.get("cateForView"));
		model.addAttribute("replyMap",Listmap.get("replyMap"));
		logger.info("freeboardCate : {}",freeboardCate);
		//ī�װ� �� ���� 
		model.addAttribute("freeboardCate",freeboardCate);
		return "/freeboard/freeboardList";
	}
	
	//����Է� replyContent
	@RequestMapping(value="/freeboardReply" ,method = RequestMethod.GET)
	public String freeboardReplyInsert(FreeboardReplyVo freeboardReplyVo,HttpSession session,
			@RequestParam(value="freeboardCd", defaultValue="") String freeboardCd,
			@RequestParam(value="replyContent", defaultValue="") String replyContent){
		logger.info("freeboardCd 111:{}",freeboardCd);
		logger.info("freeboardReplyVo.toString() : {}",freeboardReplyVo.toString());
		freeService.freeboardReplyInsert(freeboardReplyVo,session,freeboardCd,replyContent);
		return "redirect:/freeboardList";
	}
	
}
