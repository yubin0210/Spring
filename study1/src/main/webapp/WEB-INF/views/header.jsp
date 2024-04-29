<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.sb {
		display: flex;
		justify-content: space-between;
	}
</style>
</head>
<body>

<div id="sb">
	<h1><a href="${cpath }">YUBIN</a></h1>
	<p>${login.username }님이 로그인 중입니다</p>
</div>
<hr>

</body>
</html>