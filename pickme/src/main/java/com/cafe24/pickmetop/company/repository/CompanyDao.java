package com.cafe24.pickmetop.company.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pickmetop.admin.model.JobTopIndexVo;
import com.cafe24.pickmetop.commons.PageHelper;
import com.cafe24.pickmetop.company.model.*;

@Repository
public class CompanyDao {
	final String NS = "com.cafe24.pickmetop.company.repository.CompanyMapper";
	@Autowired
	@Resource(name = "sqlSessionCompany")
	private SqlSessionTemplate sqlSessionFactoryCompany;
/*
 * ----------------------------------------------------------------------------------------
 * 
 * 									   ������������� ����
 * 
 * ----------------------------------------------------------------------------------------
 * */
	public List<CompanyInfoVo> selectCompanyByTotalRate(){
		return sqlSessionFactoryCompany.selectList(NS + ".selectCompanyByTotalRate");
	}

/*
 * ----------------------------------------------------------------------------------------
 * 
 * 									   ������� ����
 * 
 * ----------------------------------------------------------------------------------------
 * */	
	//������� ���(����)
	public List<CompanyReviewVo> selectCompanyReviewListByReviewAllow(Map<String, Object> reviewSearchMap){
		return sqlSessionFactoryCompany.selectList(NS +".selectCompanyReviewListByReviewAllow", reviewSearchMap);
	}
	//���������(�����) �޼���
	public int insertCompanyReview(CompanyReviewVo companyReviewVo){
		return sqlSessionFactoryCompany.insert(NS + ".insertCompanyReview", companyReviewVo);
	}
	//����ڵ�˻�
	public String selectCompanyInfoByCompanyCd(String companyName){
		return sqlSessionFactoryCompany.selectOne(NS + ".selectCompanyInfoByCompanyCd", companyName);
	}
	
	//������� ���̺��� ����̸� ����Ʈ ��ü
	public List<CompanyInfoVo> selectCompanyInfoAllList(){
		return sqlSessionFactoryCompany.selectList(NS + ".selectCompanyInfoAllList");
	}
	//�����ߺз� ���̺��� ����Ʈ ��ü
	public List<JobTopIndexVo> selectJobTopIndexAllList(){
		return sqlSessionFactoryCompany.selectList(NS + ".selectJobTopIndexAllList");
	}
	//���������(�����)
	public List<CompanyReviewVo> selectCompanyReviewListByReviewUnreceived(PageHelper pageHelper){
		return sqlSessionFactoryCompany.selectList(NS + ".selectCompanyReviewListByReviewUnreceived", pageHelper);
	}
	//�������󼼺���
	public CompanyReviewVo selectCompanyListByReviewCd(int companyReviewCd){
		return sqlSessionFactoryCompany.selectOne(NS + ".selectCompanyListByReviewCd", companyReviewCd);
	}
	//���������� ������Ʈ
	public int updateCompanyReviewAllow(Map<String, Object> allow){
		return sqlSessionFactoryCompany.update(NS + ".updateCompanyReviewAllow", allow);
	}
	//���������ν� ��������
	public int updateCompanyInfoTotalRate(Map<String, Object> allow){
		return sqlSessionFactoryCompany.update(NS + ".updateCompanyInfoTotalRate", allow);
	}
	//����������
	public int deleteCompanyReview(int companyReviewCd){
		return sqlSessionFactoryCompany.delete(NS + ".deleteCompanyReview", companyReviewCd);
	}
	//������� ��� ī��Ʈ
	public int selectAllowTotalCount(String tbName, String tbColumn, int allow){
		Map<String, Object> sqlMap = new HashMap<String, Object>();
		sqlMap.put("tbName", tbName);
		sqlMap.put("tbColumn", tbColumn);
		sqlMap.put("allow", allow);
		return sqlSessionFactoryCompany.selectOne(NS + ".selectAllowTotalCount", sqlMap);
	}
	public int selectAllowSearchCount(String jobTopIndexCd){
		return sqlSessionFactoryCompany.selectOne(NS + ".selectAllowSearchCount", jobTopIndexCd);
	}
/*
 * ----------------------------------------------------------------------------------------
 * 
 * 									   �����ı� ����
 * 
 * ----------------------------------------------------------------------------------------
 * */
	//�����ı� ����� ����Ʈ(������)
	public List<CompanyInterviewVo> selectCompanyInterviewListByInterviewUnreceived(PageHelper pageHelper){
		return sqlSessionFactoryCompany.selectList(NS + ".selectCompanyInterviewListByInterviewUnreceived", pageHelper);
	}
}
