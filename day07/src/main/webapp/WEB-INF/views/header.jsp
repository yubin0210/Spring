<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day07</title>
<style>
	#loginInfo {
		text-align: right;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">day07</a></h1>
	<c:if test="${not empty login }">
	<div id="loginInfo">
		${login.userid } (${login.username }) 
		<a href="${cpath }/member/logout"><button>로그아웃</button></a>
	</div>
	</c:if>
	<nav>
		<ul>
			<li><a href="${cpath }/survey/list">설문 목록</a></li>
			<li><a href="${cpath }/survey/add">설문 등록</a></li>
			<li><a href="${cpath }/member/login">로그인</a></li>
		</ul>
	</nav>
</header>












