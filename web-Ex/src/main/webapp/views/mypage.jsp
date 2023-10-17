<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="/header"/>
<body>
<%
	if(session.getAttribute("log") == null) {
		response.sendRedirect("/login");
	}
%>	
<h1>${log.username }님 환영합니다.</h1>
<a href="/login">로그인으로</a>
<a href="/leave">회원탈퇴</a>
<a href='http://localhost:8080/'>로그아웃</a>
<a href="/update">회원정보 수정</a>
</body>
<jsp:include page="/footer"/>
</html>