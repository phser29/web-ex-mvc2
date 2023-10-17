<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="/resources/style/form.css">
<jsp:include page="/header"/>
<body>
	
	<h1>회원목록</h1>
	<table border=1>
		<tr>
			<th>id</th>
			<th>username</th>
			<th>name</th>
			<th>email</th>
			<th>phone</th>
			<th>country</th>
			<th>birth</th>
			<th>gender</th>
		</tr>
		<c:forEach var="var" items="${requestScope.findAll}">
			<tr>
				<th>${var.id}</th>
				<th>${var.username}</th>
				<th>${var.name}</th>
				<th>${var.email}</th>
				<th>${var.phone}</th>
				<th>${var.country}</th>
				<th>${var.birth}</th>
				<th>${var.gender}</th>
			</tr>
		</c:forEach>
	</table>
	
	<form action="/servlet" id="clickbtn1">
		<input type="hidden" name="command" value="editUserForm">
	</form>
</body>
<jsp:include page="/footer"/>
</html>