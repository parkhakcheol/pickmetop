<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/css/companyinfo.css">
<title>Insert title here</title>
</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modHeader.jsp" />
<body>
	<div id="content_cominfo">
		<!-- main body start -->
		<div id="company_view" class="pop_company_view">
			<!-- company_info_header -->
			<div class="company_info_header">
				<div class="top_cont">
					<h2 class="corp_logo">
						<img id="�浿�����" alt="�浿�����"
							src="http://webpds.saramin.co.kr/pds/united_company/logo/2046_.gif"
							width="138" height="68"> <strong class="ci_name">�浿�����</strong>
					</h2>
					<div class="ci_url">
						<a href="http://www.kdpharma.co.kr" target="_blank">http://www.kdpharma.co.kr</a>
					</div>
					<div class="ci_desc">
						<p class="txt">1975�� 9�� 9�Ͽ� ������ ���ࡤ���ǡ����̿� ������ ���,���а�����(�����������)
							����,����/�ε��� �Ӵ� ����� �ϴ� �ڽ��ڱ���̸�, �ں����� 135�� 7,500���� ������� 1,518��
							9,333���� ������� 525���Դϴ�.</p>
					</div>
				</div>
				<!-- ������� 5�� -->
				<div class="corp_summary">
					<ul class="type_col5">
						<li class="col1">
							<div class="item1">
								<i>����</i>
								<p>���ࡤ���ǡ����̿�</p>
							</div>
						</li>
						<li class="col2">
							<div class="item2">
								<i>�����</i>
								<p>
									1,518��<br> 9,333����
								</p>
							</div>
						</li>
						<li class="col3">
							<div class="item3">
								<i>�������</i>
								<p>�ڽ���</p>
							</div>
						</li>
						<li class="col4">
							<div class="item4">
								<i>������</i>
								<p>
									1975��<br>(���� 41��)
								</p>
							</div>
						</li>
						<li class="col5">
							<div class="item5">
								<i>�����</i>
								<p>525��</p>
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
											<td>�浿�����</td>
											<th scope="row">��ǥ�ڸ�</th>
											<td>���⼺</td>
										</tr>
										<tr>
											<th scope="row">����</th>
											<td colspan="3">���ࡤ���ǡ����̿�</td>
										</tr>
										<tr>
											<th scope="row">�������</th>
											<td colspan="3">���,���а�����(�����������) ����,����/�ε��� �Ӵ�</td>
										</tr>
										<tr>
											<th scope="row">�������</th>
											<td colspan="3" class="position1">�ڽ���, �߰߱��, �ܱ��� ���ڱ��,
												�ֽ�ȸ��, �ܺΰ������, ������ ���, ���λ��ü <a href="#none" class="ico_wrap">
													<i class="ico_kosdaq"><img
														src="//www.saraminimage.co.kr/ui/company_info/ico_kosdaq.png"
														alt="�ڽ���"></i>
													<div class="ly_wrap">
														<div class="ly_cont">
															<div class="tit_wrap">
																<p class="tit">
																	<strong>������ ��ޱ���</strong>
																</p>
																<span class="btn_close"><i>�ݱ�</i></span>
															</div>
															<div class="cont_wrap">
																<p class="txt">
																	���忩�δ� <strong class="point">����� �ܺ���</strong>�� �����ϴ� ô����
																	�˴ϴ�.
																</p>
																<ul class="list_cont">
																	<li><i class="ico_kospi"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_kosp.png"
																			alt="�ڽ���"></i><span class="txt">�������ǽ��� �������</span></li>
																	<li><i class="ico_kosdaq"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_kosdaq.png"
																			alt="�ڽ���"></i><span class="txt">�ڽ��ڽ��� �������</span></li>
																	<li><i class="ico_konex"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_konex.png"
																			alt="�ڳؽ�"></i><span class="txt">�ڳؽ����� �������</span></li>
																</ul>
															</div>
														</div>
													</div>
											</a>
											</td>
										</tr>
										<tr>
											<th scope="row">������</th>
											<td class="position2">1975�� 9�� 9�� (���� 41��) <a
												href="#none" class="ico_wrap"> <i class="ico_a3"><img
														src="//www.saraminimage.co.kr/ui/company_info/ico_a3.png"
														alt="AAA"></i>
													<div class="ly_wrap">
														<div class="ly_cont">
															<div class="tit_wrap">
																<p class="tit">
																	<strong>��� ����(����)��ޱ���</strong>
																</p>
																<span class="btn_close"><i>�ݱ�</i></span>
															</div>
															<div class="cont_wrap">
																<p class="txt">
																	����� ������ <strong class="point">����� ������</strong>�� �����ϴ�
																	ô���� �˴ϴ�.
																</p>
																<ul class="list_cont">
																	<li><i class="ico_a4"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a4.png"
																			alt="A+"></i><span class="txt">������ �� 50�� �̻�
																			������</span></li>
																	<li><i class="ico_a3"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a3.png"
																			alt="AAA"></i><span class="txt">������ �� 30�� �̻�
																			�߰߱��</span></li>
																	<li><i class="ico_a2"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a2.png"
																			alt="AA"></i><span class="txt">������ �� 20�� �̻�
																			������</span></li>
																	<li><i class="ico_a1"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a1.png"
																			alt="A"></i><span class="txt">������ �� 10�� �̻�
																			�����</span></li>
																</ul>
															</div>
														</div>
													</div>
											</a>
											</td>
											<th scope="row">ä����Ȳ</th>
											<td><a
												href="javascript:scrollTo({'target':'#company_info_section5','speed':'100'});"
												class="link_job_view">ä�� ������ <strong class="point">1��</strong></a></td>
										</tr>
										<tr>
											<th scope="row">�����</th>
											<td class="position3">525�� <span class="standard_year">(2015��
													����)</span> <a href="#none" class="ico_wrap"> <i class="ico_a2"><img
														src="//www.saraminimage.co.kr/ui/company_info/ico_a2.png"
														alt="AA"></i>
													<div class="ly_wrap">
														<div class="ly_cont">
															<div class="tit_wrap">
																<p class="tit">
																	<strong>����� ��ޱ���</strong>
																</p>
																<span class="btn_close"><i>�ݱ�</i></span>
															</div>
															<div class="cont_wrap">
																<p class="txt">
																	����� ������� <strong class="point">����� �Ը�</strong>�� �����ϴ�
																	ô���� �˴ϴ�.
																</p>
																<ul class="list_cont">
																	<li><i class="ico_a4"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a4.png"
																			alt="A+"></i><span class="txt">����� 1���� �̻�</span></li>
																	<li><i class="ico_a3"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a3.png"
																			alt="AAA"></i><span class="txt">����� 1000�� �̻�</span></li>
																	<li><i class="ico_a2"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a2.png"
																			alt="AA"></i><span class="txt">����� 300��~999��
																			�̻�</span></li>
																	<li><i class="ico_a1"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a1.png"
																			alt="A"></i><span class="txt">����� 100��~299��
																			�̻�</span></li>
																</ul>
															</div>
														</div>
													</div>
											</a> <i class="ico_employ"><img
													src="//www.saraminimage.co.kr/ui/company_info/ico_employ.png"
													alt="�������"></i>
											</td>
											<th scope="row">�����</th>
											<td class="position4">1,518�� 9,333���� <span
												class="standard_year">(2015�� ����)</span> <a href="#none"
												class="ico_wrap"> <i class="ico_a2"><img
														src="//www.saraminimage.co.kr/ui/company_info/ico_a2.png"
														alt="AA"></i>
													<div class="ly_wrap">
														<div class="ly_cont">
															<div class="tit_wrap">
																<p class="tit">
																	<strong>����� ��ޱ���</strong>
																</p>
																<span class="btn_close"><i>�ݱ�</i></span>
															</div>
															<div class="cont_wrap">
																<p class="txt">
																	����� ������� <strong class="point">����� ������</strong>�� �����ϴ�
																	ô���� �˴ϴ�.
																</p>
																<ul class="list_cont">
																	<li><i class="ico_a4"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a4.png"
																			alt="A+"></i><span class="txt">����� 1�� �̻�</span></li>
																	<li><i class="ico_a3"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a3.png"
																			alt="AAA"></i><span class="txt">����� 5000�� �̻�</span></li>
																	<li><i class="ico_a2"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a2.png"
																			alt="AA"></i><span class="txt">����� 1000�� �̻�</span></li>
																	<li><i class="ico_a1"><img
																			src="//www.saraminimage.co.kr/ui/company_info/ico_a1.png"
																			alt="A"></i><span class="txt">����� 100�� �̻�</span></li>
																</ul>
															</div>
														</div>
													</div>
											</a>
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
											<td>02-576-6121</td>
											<th scope="row">FAX</th>
											<td>02-577-5195</td>
										</tr>
										<tr>
											<th scope="row">Ȩ������</th>
											<td colspan="3"><a href="http://www.kdpharma.co.kr"
												class="link_site" target="_blank">http://www.kdpharma.co.kr</a></td>
										</tr>
										<tr>
											<th scope="row">����ּ�</th>
											<td colspan="3">���� ���Ǳ� ���嵿 1659-5 �浿�������</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ��������� end -->
		<!-- main body end -->
	</div>
</body>
<jsp:include
	page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modFooter.jsp" />
</html>