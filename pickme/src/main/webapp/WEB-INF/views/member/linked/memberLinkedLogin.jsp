<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
</head>
<body>

<!-- //���̹����̵�ηα��� ��ư ���� ���� -->

<!-- ���̹��Ƶ��ηα��� �ʱ�ȭ Script -->
<script type="text/javascript">
	var naver_id_login = new naver_id_login("����� ClientID ��", "����� Callback URL ��");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("white", 2,40);
	naver_id_login.setDomain(".service.com");
	naver_id_login.setState(state);
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
</script>
<!-- // ���̹����̵�ηα��� �ʱ�ȭ Script -->
</body>
</html>