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
	<%
		BoardDao dao = BoardDao.getInstance();
		ArrayList<Board> list = dao.list();
	%>
	<table align = center width=700 border=1 cellpadding=2 >
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
			<%for(int i=0; i<list.size(); i++) {
				Board vo = list.get(i);
			%>
			<tr>
				<td><%=vo.getId() %></td>
				<td><%=vo.getAuther() %></td>
				<td><a href="http://localhost:8080/servlet?command=getAction&auther=${log.id }"><%=vo.getTitle() %></a></td>
				<td><%=vo.getContent() %></td>
				<td><%=vo.getReg_date() %></td>
				<td><%=vo.getMog_date() %></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="6"><button type="button"><a href="/board/insert.jsp">글작성</a></button></td>
			</tr>
		</tbody>
	</table>
</body>
</html>