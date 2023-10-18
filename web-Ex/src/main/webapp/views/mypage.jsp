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
<h1>${log.username }님 환영합니다.</h1>
<a href="/login">로그인으로</a>
<a href='http://localhost:8080/servlet?command=logoutForm'>로그아웃</a>
<a href="/update">회원정보 수정</a>
</body>
<jsp:include page="/footer"/>
</html>