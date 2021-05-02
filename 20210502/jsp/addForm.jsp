<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
<h1>게시물 등록</h1>

<form action="TestServlet" method="POST">
	<div>
		제목 : <input type="text" name="title" />
	</div>
	<div>
		내용 : <textarea name="body"></textarea>
	</div>
	<input type="submit" value="등록" />
	<input type="hidden" name="action" value="doAdd"/>
</form>

</body>
</html>