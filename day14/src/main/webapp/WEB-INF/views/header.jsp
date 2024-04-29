<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mail</title>
<style>
	a { color: inherit; text-decoration: none; }
	a:hover { text-decoration: underline; }
	textarea {
		resize: none;
		width: 300px;
		height: 150px;
	}
	.hidden {
		display: none;
	}
	.box {
		width: 300px;
		padding: 10px;
		border: 1px solid black;
	}
</style>
</head>
<body>

<h1><a href="${cpath }">스프링으로 메일 보내기</a></h1>
<hr>
