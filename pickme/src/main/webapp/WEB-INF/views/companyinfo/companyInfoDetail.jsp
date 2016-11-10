<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=effda133d3bb5a8e9a0cfd6d830f5b2a&libraries=services"></script>
<script>
	$(document).ready(function() {
		var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
	    mapOption = {
	        center: new daum.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
	        level: 3 // ������ Ȯ�� ����
	    };  

		// ������ �����մϴ�    
		var map = new daum.maps.Map(mapContainer, mapOption); 
	
		// �ּ�-��ǥ ��ȯ ��ü�� �����մϴ�
		var geocoder = new daum.maps.services.Geocoder();
	
		// �ּҷ� ��ǥ�� �˻��մϴ�
		geocoder.addr2coord('${companyInfoDetail.companyAddr }', function(status, result) {
	
		    // ���������� �˻��� �Ϸ������ 
		     if (status === daum.maps.services.Status.OK) {
	
		        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
	
	        	// ��������� ���� ��ġ�� ��Ŀ�� ǥ���մϴ�
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords
		        });
	
		        // ����������� ��ҿ� ���� ������ ǥ���մϴ�
		        var infowindow = new daum.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${companyInfoDetail.companyName }</div>'
		        });
	        	infowindow.open(map, marker);
	
	        	// ������ �߽��� ��������� ���� ��ġ�� �̵���ŵ�ϴ�
	       		map.setCenter(coords);
		    } 
		});    
	});
</script>
<link rel="stylesheet" href="/css/companyinfo.css">
<title>Insert title here</title>
</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modHeader.jsp" />
<body>
	<!-- HEADER START -->
	<div class="headers">
		<div id="companyInfoList">
			<div class="header_cont">
				<div class="gnb" style="background: rgba(255, 255, 255, 0.01);">
					<h1>
						<a class="companyInfoMain" href="/companyInfo"><strong>�������</strong></a>
					</h1>
					<ul>
						<li class="menu1">
							<a href="/review/companyReviewInsertForm">�������</a>
						</li>
						<li class="menu2">
							<a href="/review/companyReviewUnreceivedList">������� �̽��� ���</a>
						</li>
						<li class="menu3">
							<a href="/review/companyReviewListAllow">������� ���� ���</a>
						</li>
						<li class="menu4">
							<a href="/interview/companyInterviewUnreceivedList">�����ı� ����� ���</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- //HEADER END -->
	<div id="companyInfoList_wrapper">
		<!-- ���־� �̹��� start -->
		<div class="sections" id="main_visual">
			<div class="section_cont">
				<div class="visual">
					<ul>
						<li class="list1"><span class="img"
							style="z-index: 2; opacity: 1;"><img
								src="/img/company/companymain.png" /></span>
						<!-- ���־� �̹���1 --></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- ���־� �̹��� end -->
	<div id="content_cominfo">
		<!-- main body start -->
		<div id="company_view" class="pop_company_view">
			<!-- company_info_header -->
			<div class="company_info_header">
				<div class="top_cont">
					<h2 class="corp_logo">
						<strong class="ci_name">${companyInfoDetail.companyName }</strong>
					</h2>
					<div class="ci_url">
						<a href="${companyInfoDetail.companySite }" target="_blank">${companyInfoDetail.companySite }</a>
					</div>
				</div>
				<!-- ������� 5�� -->
				<div class="corp_summary">
					<ul class="type_col5">
						<li class="col1">
							<div class="item1">
								<i>����</i>
								<p>${companyInfoDetail.industryTopIndexName }</p>
							</div>
						</li>
						<li class="col2">
							<div class="item2">
								<i>�����</i>
								<p>
									${companyInfoDetail.companySales }
								</p>
							</div>
						</li>
						<li class="col3">
							<div class="item3">
								<i>�������</i>
								<p>${companyInfoDetail.companyTypeName }</p>
							</div>
						</li>
						<li class="col4">
							<div class="item4">
								<i>������</i>
								<p>
									${companyInfoDetail.companyBirthdate }
								</p>
							</div>
						</li>
						<li class="col5">
							<div class="item5">
								<i>����</i>
								<p>${companyInfoDetail.companyTotalRate *1.0}��</p>
							</div>
						</li>
					</ul>
				</div>
			<!-- //������� 5�� -->
			</div>
			<!-- //company_info_header -->
			<!-- company_info_content -->
			<div class="company_info_content">
				<!-- company_info_section1:�⺻���� -->
				<div id="company_info_section1" class="company_info_section1">
					<h3 class="btit">�⺻����</h3>
					<!-- folding -->
					<div class="folding on">
						<!-- sec1 -->
						<div class="sec1">
							<div class="table_col_type1">
								<table summary="�⺻����">
									<caption>�����, �Ҽӱ׷�, ����, �������, �������, �����, �ں���, ������,
										��ǥ��ȭ, Ȩ������, �ּ�</caption>
									<colgroup>
										<col class="col1">
										<col class="col2">
										<col class="col3">
										<col class="col4">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row">�����</th>
											<td>${companyInfoDetail.companyName }</td>
											<th scope="row">��ǥ�ڸ�</th>
											<td>${companyInfoDetail.companyCeo }</td>
										</tr>
										<tr>
											<th scope="row">����</th>
											<td colspan="3">${companyInfoDetail.industryTopIndexName }</td>
										</tr>
										<tr>
											<th scope="row">�������</th>
											<td colspan="3" class="position1">${companyInfoDetail.companyTypeName }</td>
										</tr>
										<tr>
											<th scope="row">������</th>
											<td class="position2">${companyInfoDetail.companyBirthdate }</td>
											<th scope="row">ä����Ȳ</th>
											<td><a
												href="javascript:scrollTo({'target':'#company_info_section5','speed':'100'});"
												class="link_job_view">ä�� ������ <strong class="point">1��</strong></a></td>
										</tr>
										<tr>
											<th scope="row">�����</th>
											<td class="position3">525�� <span class="standard_year">(2015�����)</span>
											</td>
											<th scope="row">�����</th>
											<td class="position4">
												<fmt:formatNumber value="${companyInfoDetail.companySales }" pattern="\#,��###.##"/>��
												<span class="standard_year">(2015�� ����)</span> 
											</td>
										</tr>
										<tr>
											<th scope="row">�ں���</th>
											<td>135�� 7,500���� <span class="standard_year">(2015��
													����)</span></td>
											<th scope="row">��������</th>
											<td>131�� 1,484���� <span class="standard_year">(2015��
													����)</span>
											</td>
										</tr>
										<tr>
											<th scope="row">��ǥ��ȭ</th>
											<td>${companyInfoDetail.companyPhone }</td>
											<th scope="row">FAX</th>
											<td>${companyInfoDetail.companyPhone }</td>
										</tr>
										<tr>
											<th scope="row">Ȩ������</th>
											<td colspan="3">
												<a href="${companyInfoDetail.companySite }" class="link_site" target="_blank">${companyInfoDetail.companySite }</a>
											</td>
										</tr>
										<tr>
											<th scope="row">����ּ�</th>
											<td colspan="3">${companyInfoDetail.companyAddr }</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			
				<div id="company_info_section3" class="company_info_section3">   
		        <!-- sec4 -->
		        <div class="sec4">
		        	<h4 class="stit">ȸ����ġ</h4>
				        <div class="corp_map">
				            <div class="adr_wrap">
				                <p class="adr_txt">${companyInfoDetail.companyAddr }</p>
				                <span class="tel">��ǥ��ȭ: ${companyInfoDetail.companyPhone }</span><span class="fax">/ FAX : ${companyInfoDetail.companyPhone }</span>
							</div>
				            <div class="api_wrap">
				    			<div id="map" style="width:100%;height:400px;"></div>
				            </div>
				        </div>
				    </div>
	    			<!-- sec4 -->
    			</div>
			</div>
		</div>
		<!-- ��������� end -->
	</div>
	<!-- main body end -->
</body>
<jsp:include
	page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modFooter.jsp" />
</html>