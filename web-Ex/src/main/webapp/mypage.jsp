<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="/header"/>
<body>
<h1>${log }님 환영합니다.</h1>
<a href="/login">로그인으로</a>
<a href="/logoutForm">로그아웃</a>
</body>
<jsp:include page="/footer"/>
</html>