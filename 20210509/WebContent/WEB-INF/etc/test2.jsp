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
<!-- 
<c:set var="n" value="4"/>
<c:set var="m" value="19"/>
<c:set var="limit" value="11"/>

<c:forEach var="dan" begin="${n}" end="${m}">
	<c:if test="${ dan % 2 != 0 }">
		<c:forEach var="i" begin="1" end="${limit}">
			<c:if test="${ i % 2 == 0 }">
				${ dan } * ${ i } = ${ dan * i }<br/>
			</c:if>
		</c:forEach>	
	</c:if>
	<br/>
</c:forEach>
 -->
<c:set var="height" value="5" />
<c:forEach var="line" begin="1" end="${ height }">
	<c:forEach var="star" begin="1" end="${ line }">
		*
	</c:forEach>
	<br />
</c:forEach>


</body>
</html>
