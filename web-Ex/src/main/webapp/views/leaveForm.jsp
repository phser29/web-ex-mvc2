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
	<form action="servlet" method="post">
	<input type="hidden" name="command" value="leaveForm">
		<input type="text" name="username" placeholder="username">
		<input type="text" name="password" placeholder="username">
		<input type="submit" value="삭제">
	</form>
</body>
<jsp:include page="/footer"/>
</html>