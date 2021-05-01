<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 변수 선언 및 초기화 -->
<%
	int a = 10;
%>
<c:set var="a" value="10" />


<!-- 출력 -->
<%
	out.println(a);
%>
<%= a %>
<c:out value="${ a }" />

<!-- 조건문 -->
<%
	int num = 2;

	if(num % 2 == 0) {
	%>
		짝수
	<%
	} else {
	%>
		홀수
<%} %>


<c:set var="num" value="2"/>
<!--  단순 if 문 -->
<c:if test="${num % 2 == 0}">
	짝수
</c:if>

<!-- else if 문 -->
<c:choose>
	<c:when test="${num % 2 == 0}">
		짝수
	</c:when>
	<c:otherwise>
		홀수
	</c:otherwise>
</c:choose>

<%
	request.getAttribute("nlist");
	for(int i = 1; i <= 10; i++) {
%>
		<%= i %>
<%		
	}
%>
<!-- 반복문 -->
<c:forEach var="i" begin="1" end="10" step="1">
	${ i }
</c:forEach>

<c:forEach var="num" items="${ nlist }">
	${ num }
</c:forEach>


</body>
</html>