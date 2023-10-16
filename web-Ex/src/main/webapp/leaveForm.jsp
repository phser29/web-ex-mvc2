<%@page import="user.UserDao"%>
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
		UserDao dao = UserDao.getInstance();
	%>
	<form action="leaveForm" method="post">
		<input type="text" name="username" placeholder="username">
		<input type="submit" value="삭제">
	</form>
	<h3>
	</h3>
</body>
<jsp:include page="/footer"/>
</html>