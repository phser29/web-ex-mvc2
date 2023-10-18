<%@page import="model.user.UserDao"%>
<%@page import="model.user.UserResponseDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/resources/style/table.css">
</head>
<jsp:include page="/header"/>
<body>
<section>
	
	<%
		UserDao dao = UserDao.getInstance();
		ArrayList<UserResponseDto> list = dao.findAll();
	%>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>username</th>
				<th>email</th>
				<th>name</th>
				<th>gender</th>
				<th>country</th>
			</tr>
		</thead>
		<tbody>
		<%for(int i=0; i<list.size(); i++) {
			UserResponseDto user = list.get(i);
		%>
			<tr>
				<td><%=i+1 %></td>
				<td><%=user.getUsername() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getName() %></td>
				<td><%=user.getGender() %></td>
				<td><%=user.getCountry() %></td>
			</tr>
		<%} %>
		</tbody>
	</table>
</section>
</body>
<jsp:include page="/footer"/>
</html>