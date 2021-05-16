<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 수정</h1>

<form action="/article/update.do" method="POST">
	<div>
		<span>제목</span> 
		<input type="text" name="title" value="${ article.title }"/>
	</div>
	<div>
		<span>내용</span>
		<textarea name="body">${ article.body }</textarea>
	</div>
	<input type="submit" value="등록" />
	<input type="hidden" name="id" value="${ article.id }"/>
</form>

</body>
</html>