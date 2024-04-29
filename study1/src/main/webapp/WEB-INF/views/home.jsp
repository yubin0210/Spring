<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<p><a href="${cpath }/member/join">회원가입</a></p>
<p><a href="${cpath }/member/login">로그인</a></p>
<c:if test="${not empty login }">	
	<p><a href="${cpath }/member/logout">로그아웃</a></p>
	<p><a href="${cpath }/member/list">회원목록</a></p>
	<p><a href="${cpath }/board/list">게시판</a></p>
</c:if>



</body>
</html>