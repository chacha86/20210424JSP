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
<%
	ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
%>
<%
	for(Article article : articles) {
%>
	<div>
		제목 : <%= article.getTitle() %>
		내용 : <%= article.getBody() %>
	</div>
<%
	}
%>

<c:forEach items="${articles}" var="article" >
	<div>
		제목 : ${article.title}
		내용 : ${article.body}
	</div>
</c:forEach>


</body>
</html>