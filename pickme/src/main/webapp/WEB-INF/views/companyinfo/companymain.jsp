<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modHeader.jsp" />
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="/css/company/companyinfo.css">
<script>
	$(document).ready(function() {
		gnb_menu();
	});
	function gnb_menu() {
		$(".menu1").mouseenter(function() {
			$("#head_lwrap").addClass("on");
			$(".menu1").addClass("on");
		});
		
		$(".menu1").mouseleave(function() {
			$("#head_lwrap").removeClass("on");
			$(".menu1").removeClass("on");
		});
		
		$(".menu2").mouseenter(function() {
			$("#head_lwrap").addClass("on");
			$(".menu2").addClass("on");
		});
		
		$(".menu2").mouseleave(function() {
			$("#head_lwrap").removeClass("on");
			$(".menu2").removeClass("on");
		});
		
		$(".menu3").mouseenter(function() {
			$("#head_lwrap").addClass("on");
			$(".menu3").addClass("on");
		});
		
		$(".menu3").mouseleave(function() {
			$("#head_lwrap").removeClass("on");
			$(".menu3").removeClass("on");
		});
		
		$(".menu4").mouseenter(function() {
			$("#head_lwrap").addClass("on");
			$(".menu4").addClass("on");
		});
		
		$(".menu4").mouseleave(function() {
			$("#head_lwrap").removeClass("on");
			$(".menu4").removeClass("on");
		});
		
		$(".menu5").mouseenter(function() {
			$("#head_lwrap").addClass("on");
			$(".menu5").addClass("on");
		});
		
		$(".menu5").mouseleave(function() {
			$("#head_lwrap").removeClass("on");
			$(".menu5").removeClass("on");
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<!-- HEADER START -->
	<div class="headers">
		<div id="head_lwrap">
			<div class="header_cont">
				<div class="gnb" style="background: rgba(255, 255, 255, 0.01);">
				<h1><a class="companyInfoMain" href="/companyInfo"><strong>�������</strong></a></h1>
					<ul>
						<li class="menu1">
							<a href="/company/companyInfoList">�������</a>
							<div class="depth2">
								<ul>
									<li><a href="/company/companyInfoList">��� ����Ʈ</a></li>
								</ul>
							</div>
						</li>
						<li class="menu2">
							<a href="/review/companyReviewListAllow">�������</a>
							<div class="depth2">
								<ul>
									<li><a href="/review/companyReviewInsertForm">������� ���</a></li>
									<li><a href="/review/companyReviewListAllow">������� ���</a></li>
								</ul>
							</div>
						</li>
						<li class="menu3">
							<a href="/salary/companySalaryListAllow">�������� </a>
							<div class="depth2">
								<ul>
									<li><a href="/salary/companySalaryInsertForm">�������� ���</a></li>
									<li><a href="/salary/companySalaryListAllow">�������� ���θ��</a></li>
								</ul>
							</div>
						</li>
						<li class="menu4">
							<a href="/interview/companyInsertForm">�����ı�</a>
							<div class="depth2">
								<ul>
									<li><a href="/interview/companyInterviewInsertForm">�����ı� ���</a></li>
									<li><a href="/interview/companyInterviewListAllow">�����ı� ���</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<span class="bg_submenu"></span>
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
			<div class="row">
				<div class="col-xs-8 quick">
					<div class="row">
						<a class="col-xs-6" href="/company/companyInfoList"><img src="/img/company/companyinfologo.png" alt="������� �ΰ� �̹���" width="200px"><p>�������</p></a>
						<a class="col-xs-6" href="#"><img src="/img/company/reviewlogo.png" alt="������� �ΰ� �̹���" width="200px"><p>�������</p></a>
					</div>
					<div class="row">
						<a class="col-xs-6" href="#"><img src="/img/company/salarylogo.png" alt="������� �ΰ� �̹���" width="200px"><p>�������</p></a>
						<a class="col-xs-6" href="#"><img src="/img/company/interviewlogo.png" alt="�����ı� �ΰ� �̹���" width="200px"><p>�����ı�</p></a>
					</div>
				</div> 
				<div class="col-xs-6 toplist">
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
			</div>
		</div>
	</div>
</body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modFooter.jsp"/>
</html>