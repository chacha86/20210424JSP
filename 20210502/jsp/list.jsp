<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sbs.example.Article" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>게시물 목록</h1>
<c:forEach items="${articles}" var="article" >
	<div>
		제목 : ${article.title}
		내용 : ${article.body}
	</div>
	<hr>
</c:forEach>
<a href="TestServlet?action=addForm">글쓰기</a>
</body>
</html>