<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../particle/head.jspf" %>
	<div class="center">	
		<h1> 게시물 상세 페이지</h1>
		<div>
			제목 : ${article.title} 
		</div>
		<div>
			내용 : ${article.body}
		</div>
		<a href="TestServlet?action=showUpdateForm&id=${article.id}">수정</a>
		<!-- 
		<form action="TestServlet" method="POST">
			<input type="hidden" name="title" value="${article.title}" />
			<input type="hidden" name="body" value="${article.body}" />
			<input type="submit" value="수정" />
		</form>
		 -->
		<a href="TestServlet?action=doDelete&id=${ article.id }">삭제</a>
	</div>
<%@ include file="../particle/foot.jspf" %>
</body>
</html>