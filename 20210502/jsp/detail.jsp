<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 게시물 상세 페이지</h1>
	<div>
		제목 : ${article.title} 
	</div>
	<div>
		내용 : ${article.body}
	</div>
	<a href="#">수정</a>
	<a href="#">삭제</a>
</body>
</html>