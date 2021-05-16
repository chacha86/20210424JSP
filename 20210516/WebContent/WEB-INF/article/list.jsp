<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sbs.example.article.Article" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.col {
	display:inline-block;
	width: 100px;
}

.title {
	width: 400px;
}

.list {
	text-align:center;
	height: 600px;
	overflow:hidden;
}

.footer {
	text-align:center;
}
</style>
</head>
<body>
	<%@ include file="../particle/head.jspf" %>
	<div class="list">
		<h1>게시물 목록</h1>
		<div class="col">
			번호
		</div>
		<div class="col title">
			제목
		</div>
		<div class="col">
			작성자
		</div>
		<div class="col">
			작성일
		</div>
		<div class="col">
			조회수
		</div>
		<hr>
		<c:forEach items="${articles}" var="article" >
			<div>
				<div class="col">
					${article.id}
				</div>
				<div class="col title">
					<a href="/article/detailForm.do?id=${article.id}">${article.title}</a>
				</div>
				<div class="col">
					${article.memberId}
				</div>
				<div class="col">
					${article.regDate}
				</div>
				<div class="col">
					${article.hit}
				</div>
			</div>
			<hr>
		</c:forEach>
	</div>
	<a href="/article/addForm.do">글쓰기</a>
<%@ include file="../particle/foot.jspf" %>
</html>