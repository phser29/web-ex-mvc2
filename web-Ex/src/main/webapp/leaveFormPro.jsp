<%@page import="user.User"%>
<%@page import="user.UserResponseDto"%>
<%@page import="user.UserDao"%>
<%@page import="user.UserRequestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
		UserDao dao = UserDao.getInstance();
		String username = request.getParameter("username");
		UserResponseDto dto = dao.findByUsername(username);
		
		UserRequestDto dtoIpt = new UserRequestDto(dto.getUsername());
		
		dao.deleteUser(dtoIpt);
		
		response.sendRedirect("/leave");
	%>
</body>
</html>