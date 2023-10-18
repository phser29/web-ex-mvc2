<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 추가</title>
</head>
<body>
<c:if test="${empty log}">
	<c:redirect url="/login"/>
</c:if>
  <form method="post" action="/servlet">
 	<input type="hidden" name="command" value="insertAction">
    <table align = center width=700 border=1 cellpadding=2 >
		<tr>
       		<td>작성자<br>코드</td>	
       		<td><input type="text" name="auther" value="${log.id}" readonly="readonly"></td>
		</tr>
	    <tr>
	       	<td>제목</td>
	       	<td><input type="text" name="title" size=60></td>
	    </tr>
	    <tr>
	       	<td>내용</td>
	       	<td><textarea name="content" cols=85 rows=15 style="resize: none;"></textarea></td>
       	</tr>
       	<tr>
			<td colspan="6">
				<input type="submit" value="작성">
       			<button type="button"><a href="/board/list.jsp">목록으로</a></button>
       			<button type="button"><a href="/">메인</a></button>
			</td>
		</tr>
    </table>
    	
  </form>	
</body>
</html>