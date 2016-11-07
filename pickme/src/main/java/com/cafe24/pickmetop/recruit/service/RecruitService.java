package com.cafe24.pickmetop.recruit.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.cafe24.pickmetop.coverletter.model.CoverletterCompanyJobVo;
import com.cafe24.pickmetop.recruit.model.OneDay;
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

	//�޷�ȭ��
	public Map<String , Object> getOneDayList(int ddayYear,int ddayMonth,String ddayOption){
		logger.info("getOneDayList");
		Map map = new HashMap<String , Object>();
		//dday : ?�� + ?�� + 1��
		Calendar dday= Calendar.getInstance();	//���ó�¥
		dday.set(Calendar.DATE,1);
		if(ddayOption.equals("prev")){
			dday.set(ddayYear, ddayMonth,1);
			dday.add(Calendar.MONTH, -1);//1������ -1�ϸ� 12���� �ɼ��ֵ��� �޼��带 ���
		}else if(ddayOption.equals("next")){
			dday.set(ddayYear, ddayMonth,1);
			dday.add(Calendar.MONTH, 1);//12������ +1�ϸ� 1���� �ɼ��ֵ��� �޼��带 ���
		}
		
		//1���� ���� : �պκ� ���鱸�ϱ�
		int firstWeek = dday.get(Calendar.DAY_OF_WEEK);
		List<OneDay> oneDayList = new ArrayList<OneDay>();
		//��������¥
		int endDay= dday.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//List size(=��¥�� �� <td>�ǰ���)
		int listSize = (firstWeek-1)+endDay;
		if(listSize%7!=0){
			listSize=listSize+(7-(listSize%7));
		}
		//�������� �������� 
		Calendar preMonth = Calendar.getInstance();	
		preMonth.set(Calendar.MONTH, dday.MONTH-1);
		int preLastDay= preMonth.getActualMaximum(Calendar.DATE);
		int beginSpace= preLastDay -(firstWeek-2);
		int endSpace=1;
		for(int i =0; i<listSize;i++){
			OneDay oneDay;
			//���ǰ���
			if(i<(firstWeek-1)){
				oneDay = new OneDay();
				oneDay.setDay(beginSpace);
				beginSpace++;
			}else if(i<endDay+(firstWeek-1)){
				oneDay = new OneDay();
				oneDay.setDay((i+1)-(firstWeek-1));
				oneDay.setYear(dday.get(Calendar.YEAR));
				oneDay.setMonth(dday.get(Calendar.MONTH)+1);
				String scheduleDate = oneDay.getYear()+"-"+oneDay.getMonth()+"-"+oneDay.getDay();
				logger.info("scheduleDate : {}",scheduleDate);
				//������ 
				List<Recruit> beginScheduleList = recruitDao.selectScheduleListByBeginDate(scheduleDate);
				
				//������
				List<Recruit> EndScheduleList = recruitDao.selectscheduleListByEndDate(scheduleDate);
				
				beginScheduleList.addAll(EndScheduleList);
				//�ΰ��� �������� ��ħ 
				oneDay.setScheduleList(beginScheduleList);
				
				//oneDay�� diary���̺� ResultSet�ݺ���Ű�� �񱳸���
			//���ǰ���
			}else {
				oneDay = new OneDay();
				oneDay.setDay(endSpace);
				endSpace++;
			}
			oneDayList.add(oneDay);
		}
		OneDay today = new OneDay();
		Calendar getToDay= Calendar.getInstance();	
		today.setDay(getToDay.get(Calendar.DATE));
		today.setMonth(getToDay.get(Calendar.MONTH)+1);
		today.setYear(getToDay.get(Calendar.YEAR));
		map.put("oneDayList", oneDayList);
		map.put("ddayYear", dday.get(Calendar.YEAR));
		map.put("ddayMonth", dday.get(Calendar.MONTH));
		map.put("today", today);
		
		return map;		
	}
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
	public void insertRecruitCompanyJob(Recruit recruit, CoverletterCompanyJobVo coverletterCompanyJobVo){

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
			
			//�ڱ�Ұ����׸��Է� 
			logger.info("coverletterCompanyJobVo.getCoverletterList().size() : {}",coverletterCompanyJobVo.getCoverletterList().size());
			//for(???){    coverletterList�� ���̸�ŭ �������ϴµ� �������� ���;��ҰŰ��� 
			CoverletterCompanyJobVo cletterArticle = new CoverletterCompanyJobVo();
			int numberOfCoverletter = recruitDao.getCountOfCoverletterJob();
			numberOfCoverletter++;
			String coverletterCd = "coverletterCd"+numberOfCoverletter;
			
			cletterArticle.setRecruitJobCd(recruitJobCd);
			/*cletterArticle.setcCletterArticleCd(coverletterCd);*/
			
			recruitDao.insertCoverletterArticle(cletterArticle);
			
			logger.info("recruitCompanyJobVo : {}",recruitCompanyJobVo.toString());	
			recruitDao.insertRecruitJob(recruitCompanyJobVo);
		}
	}
}

