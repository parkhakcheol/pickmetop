package com.cafe24.pickmetop.coverletter.model;

public class CoverletterPassVo {
	private String passCletterCd; //�հ��ڱ�Ұ����ڵ�
	private String recruitJobCd; //���ä���ڵ�
	private String passCletterName; //�հ��ڱ�Ұ��� �̸�
	private String passCletterContent; //�հ��ڱ�Ұ��� ����
	private String passCletterRegdate; //�հ��ڱ�Ұ��� �������
	private String passCletterRegister; //�հ��ڱ�Ұ��� �����
	private String companyName; //�����
	private String jobMidindexName; //�����ߺз���
	private String recruitJobJobdetail; //ä�������
	public String getPassCletterCd() {
		return passCletterCd;
	}
	public void setPassCletterCd(String passCletterCd) {
		this.passCletterCd = passCletterCd;
	}
	public String getRecruitJobCd() {
		return recruitJobCd;
	}
	public void setRecruitJobCd(String recruitJobCd) {
		this.recruitJobCd = recruitJobCd;
	}
	public String getPassCletterName() {
		return passCletterName;
	}
	public void setPassCletterName(String passCletterName) {
		this.passCletterName = passCletterName;
	}
	public String getPassCletterContent() {
		return passCletterContent;
	}
	public void setPassCletterContent(String passCletterContent) {
		this.passCletterContent = passCletterContent;
	}
	public String getPassCletterRegdate() {
		return passCletterRegdate;
	}
	public void setPassCletterRegdate(String passCletterRegdate) {
		this.passCletterRegdate = passCletterRegdate;
	}
	public String getPassCletterRegister() {
		return passCletterRegister;
	}
	public void setPassCletterRegister(String passCletterRegister) {
		this.passCletterRegister = passCletterRegister;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobMidindexName() {
		return jobMidindexName;
	}
	public void setJobMidindexName(String jobMidindexName) {
		this.jobMidindexName = jobMidindexName;
	}
	public String getRecruitJobJobdetail() {
		return recruitJobJobdetail;
	}
	public void setRecruitJobJobdetail(String recruitJobJobdetail) {
		this.recruitJobJobdetail = recruitJobJobdetail;
	}
	@Override
	public String toString() {
		return "CoverletterPassVo [passCletterCd=" + passCletterCd + ", recruitJobCd=" + recruitJobCd
				+ ", passCletterName=" + passCletterName + ", passCletterContent=" + passCletterContent
				+ ", passCletterRegdate=" + passCletterRegdate + ", passCletterRegister=" + passCletterRegister
				+ ", companyName=" + companyName + ", jobMidindexName=" + jobMidindexName + ", recruitJobJobdetail="
				+ recruitJobJobdetail + "]";
	}
	
	
}
