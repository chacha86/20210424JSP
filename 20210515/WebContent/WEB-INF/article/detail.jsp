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
		<a href="/article/showUpdateForm.do?id=${article.id}">수정</a>
		<!-- 
		<form action="TestServlet" method="POST">
			<input type="hidden" name="title" value="${article.title}" />
			<input type="hidden" name="body" value="${article.body}" />
			<input type="submit" value="수정" />
		</form>
		 -->
		<a href="/article/delete.do?id=${ article.id }">삭제</a>
		<hr>
		<div>
			<c:forEach var="reply" items="${ replies }">
				<div>
					<span>내용</span>
					<span>${reply.body}</span>
				</div>
				<hr>
			</c:forEach>
		</div>
	</div>
<%@ include file="../particle/foot.jspf" %>
</body>
</html>