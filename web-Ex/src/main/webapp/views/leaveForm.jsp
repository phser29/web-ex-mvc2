<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="/header"/>
<body>
<c:if test="${empty log}">
	<c:redirect url="/login"/>
</c:if>
	<form action="servlet" method="post">
	<input type="hidden" name="command" value="leaveForm">
		<input type="text" name="username" placeholder="username">
		<input type="text" name="password" placeholder="username">
		<input type="submit" value="삭제">
	</form>
</body>
<jsp:include page="/footer"/>
</html>