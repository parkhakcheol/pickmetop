<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modHeader.jsp"/>
<body>
	<!-- HEADER START -->
	<div class="headers">
		<div id="head_lwrap">
			<div class="header_cont">
				<div class="gnb" style="background: rgba(255, 255, 255, 0.01);">
				<h1><strong>�������</strong></h1>
					<ul>
						<li class="menu1"><a href="/review/companyReviewInsertForm">������� ���</a></li>
						<li class="menu2"><a href="/review/companyReviewUnreceivedList">������� �̽��� ���</a></li>
						<li class="menu3"><a href="review/companyReviewListAllow">������� ���� ���</a></li>
						<li class="menu4"><a href="/interview/companyInterviewUnreceivedList">�����ı� ����� ���</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- //HEADER END -->
	<div id="main_wrapper">
		<!-- ���־� �̹��� start -->
		<div class="sections" id="main_visual">
			<div class="section_cont">
				<div class="visual">
					<ul>
						<li class="list1">
							<span class="img" style="z-index:2; opacity:1;"><img src="/img/company/companymain.png"/></span><!-- ���־� �̹���1 -->
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- ���־� �̹��� end -->
	<div class="container">
		<div class="sections2">
			<div class="toplist">
				<ul id="list10">
			    	<li class="bar"><h3>��� ���� ����</h3></li>
			     	<li id="list10_bg">
					    <p id="listit1">����</p>
						<p id="listit2">����̸�</p>
						<p id="listit3">��� �� ����</p>
				 	</li>
				 	<c:forEach var="companyTotalRateList" items="${companyTotalRateList}" varStatus="i">
					<li class="list10_list">
					    <p class="list10_0">${i.count}</p>
						<p class="list10_1"><a href="${companyTotalRateList.companySite }">${companyTotalRateList.companyName }</a></p>
						<p class="list10_2">${companyTotalRateList.companyTotalRate * 1.0}</p>
					</li>
					</c:forEach>
				</ul> 
			</div>
			<ul class="quick_service">
				<li><a href="#"><img src="/img/company/companyreview.png" width="200px"><p>�������</p></a></li>
				<li><a href="#"><img alt="Ȯ�μ� ��û - ���� ���� Ȯ�μ� �߱��� ���� �帳�ϴ�." src="/images/main/main_quick2.png"></a></li>
				<li><a href="#"><img alt="�߱���Ȳ - Ȯ�μ� �߱ޱ���� Ȯ���غ�����" src="/images/main/main_quick3.png"></a></li>
				<li><a href="#"><img alt="����Ȯ�� - ���Դ���ڸ� Ȯ���غ�����" src="/images/main/main_quick4.png"></a></li>  
			</ul> 
		</div>
	</div>
</body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modFooter.jsp"/>
</html>