<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
    String cp = request.getContextPath();
	String generalId =request.getParameter("generalId");
	String generalPw =request.getParameter("generalPw");
	String generalNick =request.getParameter("generalNick");
	
	/*
		// ����
		1. jsp : session ���尴ü ���(������ ��ü �������� �ʾƵ� ��)
		2. ���� : HttpSession session=req.getSession();
	*/
	
	// System.out.println()�� ������ �ܼ�â�� ������ �����
	// �ǹ����� System.out.println()���� ���� �Ŀ� ������ ����ϸ� ���� ���� ������...
	System.out.println(session.getId());
	System.out.println(session.getMaxInactiveInterval());
	
	if(generalId.equals("generalId") && generalPw.equals("generalPw")){
		//���� �����ð� ����(�ʴ���)
		session.setMaxInactiveInterval(1*10);
		//���ǿ� ���̵�� �̸��� ����
		session.setAttribute("generalId", generalId);
		session.setAttribute("generalPw", generalPw);
		response.sendRedirect("idex.jsp");
		return;
	}
	
	out.print("<script> alert('���̵� �Ǵ� �н����� Ʋ��');");
	out.print("history.back();</script>");
%>


