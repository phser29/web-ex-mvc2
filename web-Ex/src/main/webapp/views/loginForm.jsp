<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form method="post" action="loginForm">
		<span>id : </span><input type="text" name="username" id="id"><br>
		<span>pw : </span><input type="password" name="password" id="password"><br>
		<input type="submit">
	</form>
	<a href="/join">회원가입</a>
</body>
</html>