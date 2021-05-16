<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
textarea {
	height:100px;
	width:900px;
}
.con {
	height:500px;
	overflow:scroll;
}
</style>
<title>Insert title here</title>
</head>
<%@ include file="../particle/head.jspf" %>
	<div class="center">
		<div class="con">	
			<h1> 게시물 상세 페이지</h1>
			<div>
				제목 : ${article.title} 
			</div>
			<div>
				내용 : ${article.body}
			</div>
			<c:if test="${ article.memberId == loginedMember.id }">
				<a href="/article/showUpdateForm.do?id=${article.id}">수정</a>
				<a href="/article/delete.do?id=${ article.id }">삭제</a>
			</c:if>
			<hr>
			<div>
				<c:forEach var="reply" items="${ replies }">
					<div>
						<c:choose>
							<c:when test="${rflag != null && rid == reply.id}">
								<div>
									<form action="/article/addReply.do">
										<div>${ loginedMember.nickname }</div>
										<div>	
											<textarea name="rbody">${ reply.body }</textarea>
										</div>
										<input type="hidden" name="articleId" value="${article.id}">
										<input type="hidden" name="memberId" value="${loginedMember.id}">
										<input type="submit" value="등록" />
									</form>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<div>${reply.nickname}</div>
									<div>${reply.body}</div>
									<div>${reply.regDate}</div>
								</div>	
							</c:otherwise>
						</c:choose>
						<a href="/article/detailForm.do?id=${ article.id }&rid=${ reply.id }&rflag=y">수정</a>
						<a href="#">삭제</a>
					</div>
					<hr>
				</c:forEach>
			</div>
		</div>
	</div>
	<form action="/article/addReply.do">
		<div>${ loginedMember.nickname }</div>
		<div>	
			<textarea name="rbody"></textarea>
		</div>
		<input type="hidden" name="articleId" value="${article.id}">
		<input type="hidden" name="memberId" value="${loginedMember.id}">
		<input type="submit" value="등록" />
	</form>
<%@ include file="../particle/foot.jspf" %>
</body>
</html>