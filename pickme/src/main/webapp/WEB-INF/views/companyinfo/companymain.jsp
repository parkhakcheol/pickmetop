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
						<li class="list1"><!-- �����ڰ� ���־� ����� ������ŭ �׳� ���� -->
							<span class="img" style="z-index:2; opacity:1;"><img src="/img/company/companymain.png" alt="�Ѱ����� ������ ����" /></span><!-- ���־� �̹���1 -->
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- ���־� �̹��� end -->
	<div class="sections2">
		<div class="container">
			<h1>��� �� ���� TOP10</h1>
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead class="text-center">
						<tr>
							<th>����</th>
							<th>����̸�</th>
							<th>���Ȩ������</th>
							<th>��� �� ����</th>
						<tr>
					</thead>
					<tbody>
						<c:forEach var="companyTotalRateList" items="${companyTotalRateList}" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>${companyTotalRateList.companyName }</td>
								<td>${companyTotalRateList.companySite }</td>
								<td>${companyTotalRateList.companyTotalRate }</td>
							</tr>				
						</c:forEach>
					</tbody>
				</table>	
			</div>
		</div>
	</div>
</body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modFooter.jsp"/>
</html>