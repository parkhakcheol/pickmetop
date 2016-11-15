<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>PickMe Main</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/css/modern-business.css" rel="stylesheet">
<link rel="stylesheet" href="/css/index.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- <script src="/js/jquery.js"></script> -->
    <!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function(){
		 $('.carousel').carousel({
		        interval: 5000 //changes the speed
		 }); 
		 gnb_menu();
	});
	
	function gnb_menu() {
		$(".menu").mouseenter(function() {
			$("#head_lwrap").addClass("on");
		});
		
		$(".menu").mouseleave(function() {
			$("#head_lwrap").removeClass("on");
		});	
	}
</script>
</head> 

<body>
<!-- HEADER START -->
	<div class="headers">
		<div id="head_lwrap">
			<div class="header_cont">
				<div class="gnb" style="background: rgba(0, 0, 0, 0.2);">
				<h1><a class="companyInfoMain" href="/"><img src="/img/main/pickme_logo4.png" width="200px;"></a></h1>
				<h1 class="adminPage"><a class="companyInfoMain" href="/admin"><strong>������ ������</strong></a></h1>
					<ul class="menu">
						<li>
							<a href="/diary">ä�����</a>
							<div class="depth2">
								<ul>
									<li><a href="/diary">ä��޷�</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="/memberCoverletterList">�ڱ�Ұ���</a>
							<div class="depth2">
								<ul>
									<li><a href="/memberCoverletterList">�ڱ�Ұ��� </a></li>
									<li><a href="/resumeList">�̷¼� </a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="/freeboardInsert">�����Խ��� </a>
							<div class="depth2">
								<ul>
									<li><a href="/freeboardInsert">�����Խ���1</a></li>
									<li><a href="/freeboardInsert">�����Խ���2</a></li>
									<li><a href="/freeboardInsert">�����Խ���3 </a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="/companyInfo">�������</a>
							<div class="depth2">
								<ul>
									<li><a href="/companyInfo">������� </a></li>
									<li><a href="/companyInfo">������� </a></li>
									<li><a href="/companyInfo">��������</a></li>
									<li><a href="/companyInfo">�����ı�</a></li>
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
	<header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div id="section1" class="container-fluid">
                	<div class="comment">			
						<p>
							<strong>ä��޷�</strong>
							<br>�ǽð� ä�������� ����<br>������ �� �´� ���� <br>��õ���� �� �־��! 
						</p>
					</div>
				</div>
            </div>
            <div class="item">
            	<div id="section2" class="container-fluid">
            		<div class="comment">		
						 <p>
							<strong>�̷¼�</strong>
							<br>�Ź� ���� �ۼ��ؾߵǴ� ���� �̷¼� <br>���� ������ ��Ȯ�ϰ� �����ϼ���!
						 </p>
					</div>
				</div>
            </div>
            <div class="item">
            	<div id="section3" class="container-fluid">
            		<div class="comment">
				  		<p>
							<strong>�ڱ�Ұ���</strong>
							<br>�ڱ�Ұ��� ���� ã���� ����� ������!!!<br>������ ��Ȯ�ϰ� �˷��帱�Կ�~ 
						</p>
					</div>
				</div>
        	</div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>
	<!-- ���־� �̹��� end -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modFooter.jsp"/>
</body>
</html>
