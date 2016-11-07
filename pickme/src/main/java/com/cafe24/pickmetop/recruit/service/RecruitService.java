package com.cafe24.pickmetop.recruit.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.DefaultNamingPolicy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.cafe24.pickmetop.admin.model.JobMidIndexVo;
import com.cafe24.pickmetop.admin.model.JobTopIndexVo;
import com.cafe24.pickmetop.recruit.model.Recruit;
import com.cafe24.pickmetop.recruit.model.RecruitCompany;
import com.cafe24.pickmetop.recruit.model.RecruitCompanyJobVo;
import com.cafe24.pickmetop.recruit.repository.RecruitDao;

@Service
public class RecruitService {
	final static Logger logger = LoggerFactory.getLogger(RecruitService.class);
	@Autowired
	RecruitDao recruitDao;
	String companyCd = "";
	//final String imgDir = "D:\\git_pickme\\topteam_pickme\\pickme\\src\\main\\webapp\\recruitImgs";
	final String imgDir = "C:\\Users\\202-09\\Desktop\\PickMe_Workspace\\TeamGit\\topteam_pickme\\pickme\\src\\main\\webapp\\upload\\recruitimg";
	//�ӽ� ����� �Է�
	public void insertTemporaryCompany(Recruit recruit){
		recruitDao.insertTemporaryCompany(recruit);
	}
	
	//�ӽñ���� ���� 
	public int selectDefaultCd(){
		return recruitDao.selectDefaultCd();
	}
	//���� ��з� ��ü
	public List<JobTopIndexVo> getJobTopIndexCd(){
		return recruitDao.getJopTopIndexCd();
	}
	//���� �ߺз� ��ü����Ʈ 
	public List<JobMidIndexVo> getJobMidIndexCd(){
		return recruitDao.getJobMidIndexCd();
	}
	//��ü �������Ʈ
	public List<String> selectCompany(){
		return recruitDao.selectCompany();
	}
	//�Է¹��� ��������� ����ڵ� �˻�
	public String getCompanyCd(String companyName){
		return recruitDao.getCompanyCd(companyName);
	}
	
	//companyRecruit�Է�
	public void insertRecruitCompany(Recruit recruit,HttpSession session){
		//test id��
		String id = (String) session.getAttribute("id");
		RecruitCompany recruitCompany = new RecruitCompany();
		
		//��ü���� ��setting
		//RecruitCompanyCd�� ���ڿ� + �����ϴ¼��� setting
		int count = recruitDao.getCountOfRecruit() +1;
		companyCd = "recruitCompany"+count;
		
		recruitCompany.setRecruitCompanyCd(companyCd);
		recruitCompany.setCompanyCd(recruit.getCompanyCd());
		recruitCompany.setRecruitName(recruit.getCompanyName());
		recruitCompany.setRecruitBegindate(recruit.getRecruitBegindate());
		recruitCompany.setRecruitEnddate(recruit.getRecruitEnddate());
		recruitCompany.setRecruitRegister(id);
		recruitCompany.setRecruitModify(id);
			
		logger.info("recruitCompany : {}",recruitCompany.toString());
			
		recruitDao.insertRecruitCompany(recruitCompany);
	}

	
	//companyRecruitJob�Է�
	public void insertRecruitCompanyJob(Recruit recruit){

		for(int i=0; i<recruit.getRecruitJobEducation().size(); i++){
			
			//recruitJobCd = ���ڿ� + �����ϴ� ��
			String recruitJobCd = "";
			int count = recruitDao.getCountOfRecruitJob()+1;
			recruitJobCd= "recruitCompanyJob" + count;
			
			logger.info("recruit {}",recruit.toString());
			logger.info("for �� {}",recruit.getRecruitJobEducation().size());
			RecruitCompanyJobVo recruitCompanyJobVo = new RecruitCompanyJobVo();
			recruitCompanyJobVo.setRecruitJobCd(recruitJobCd);
			recruitCompanyJobVo.setCompanyCd(recruit.getCompanyCd());
			recruitCompanyJobVo.setRecruitCompanyCd(companyCd);
			recruitCompanyJobVo.setJobMidindexCd(recruit.getJobMidIndexCd().get(i));
			recruitCompanyJobVo.setRecruitJobWorkstatus(recruit.getRecruitJobWorkstatus().get(i));
			recruitCompanyJobVo.setRecruitJobJobdetail(recruit.getRecruitJobJobdetail().get(i));
			recruitCompanyJobVo.setRecruitJobEducation(recruit.getRecruitJobEducation().get(i));
			
			//file�̸� 
			MultipartFile recruitImgs = recruit.getRecruitJobFile();
			String saveFileName = recruit.getRecruitJobFile().getOriginalFilename().substring(0,recruit.getRecruitJobFile().getOriginalFilename().length()-4);

			
			String ext = recruitImgs.getOriginalFilename().substring(recruitImgs.getOriginalFilename().lastIndexOf(".") + 1);
			ext = ext.toLowerCase();
			saveFileName=saveFileName+ "_" + System.currentTimeMillis()+"."+ext;
			//controller���� ��ȿ���˻��ϱ� 
			String type = recruitImgs.getContentType();
			logger.info("������ �����̸� : {}", saveFileName);
			
			recruitCompanyJobVo.setRecruitJobFile(saveFileName );
			
			// file����
			String fullFileName = imgDir + "\\" + saveFileName ;
			logger.info("fullFileName : {}", fullFileName);
			File saveFile = new File(fullFileName);
			try {
				// img�� saveFile�� �̵�
				recruitImgs.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			logger.info("recruitCompanyJobVo : {}",recruitCompanyJobVo.toString());	
			recruitDao.insertRecruitJob(recruitCompanyJobVo);
		}
	}
}

