package com.cafe24.pickmetop.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pickmetop.admin.model.*;
import com.cafe24.pickmetop.admin.repository.AdminDao;

@Service
public class AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	
	@Autowired
	AdminDao adminDao;
	
	//������ ������ �� �̽��� �Խñ� �� ��������
	public CountVo getUnreceivedListCount(){
		return adminDao.selectUnreceivedListCount();
	}
}
