<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
<%@ include file="../particle/head.jspf" %>
<div class="center">
	<h1>게시물 등록</h1>
	<form action="/article/add.do" method="POST">
		<div>
			<span>제목</span> 
			<input type="text" name="title"/>
		</div>
		<div>
			<span>내용</span>
			<textarea name="body"></textarea>
		</div>
		<input type="submit" value="등록" />
	</form>
</div>
<%@ include file="../particle/foot.jspf" %>
</body>
</html>