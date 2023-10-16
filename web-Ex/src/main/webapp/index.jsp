<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
</head>
<jsp:include page="/header"/>
<link rel="stylesheet" href="/resources/style/form.css">
<body>
	<section>
		<p>Hello world</p>
		
		<%
			UserDao dao = UserDao.getInstance();
			dao.findById(1234);
		%>
	</section>
</body>
<jsp:include page="/footer"/>
</html>