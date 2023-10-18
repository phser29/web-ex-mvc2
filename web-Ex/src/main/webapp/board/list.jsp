<%@page import="java.util.ArrayList"%>
<%@page import="model.board.BoardDao"%>
<%@page import="model.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
<c:if test="${empty log}">
	<c:redirect url="/login"/>
</c:if>
	<table align=center width=700 border=1 cellpadding=2 >
		<thead>
			<tr>
				<th>id</th>
				<th>author</th>
				<th>title</th>
				<th>content</th>
				<th>reg_date</th>
				<th>mog_date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="var" items="${requestScope.list}">
			<tr>
				<td>${var.id }</td>
				<td>${var.auther }</td>
				<td><a href="http://localhost:8080/servlet?command=getAction&auther=${var.auther }">${var.title  }</a></td>
				<td>${var.content }</td>
				<td>${var.reg_date }</td>
				<td>${var.mog_date }</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6"><button type="button"><a href="/board/insert.jsp">글작성</a></button></td>
			</tr>
		</tbody>
	</table>
</body>
</html>