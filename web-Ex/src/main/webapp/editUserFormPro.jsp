<%@page import="user.User"%>
<%@page import="user.UserResponseDto"%>
<%@page import="user.UserRequestDto"%>
<%@page import="user.UserDao"%>
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
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String gender = request.getParameter("gender");
	String country = request.getParameter("country");
	String phone = request.getParameter("phone");
	
	UserResponseDto dto = dao.findByUsername(username);
	UserRequestDto dtoIpt = new UserRequestDto(dto.getUsername());
	
	dao.setUser(dtoIpt, username, password, name, email, phone, country, birth, gender);
	
	response.sendRedirect("/editUser");
%>
</body>
</html>