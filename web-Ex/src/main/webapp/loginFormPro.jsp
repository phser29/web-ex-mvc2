<%@page import="user.UserResponseDto"%>
<%@page import="user.UserRequestDto"%>
<%@page import="user.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- 
JSP의 내장객체 

1) out
2) request
3) response
4) page
5) pageContext
6) config
7) session
8) application
9) exception

--%>

<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	UserDao dao = UserDao.getInstance();
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(dao.findByUsername(username) != null && dao.findByPassword(password) != null) {
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		response.sendRedirect("/mypage");
	} else {
		response.sendRedirect("/login");
	}
	%>
</body>
</html>