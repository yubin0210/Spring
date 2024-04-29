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
	a {
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: underline;
	}
	p.relative {
		position: relative;
		height: 200px;
	}
	input[type="file"] {
		opacity: 0;
		position: absolute;
		top: 0;
		left: 0;
		width: 200px;
		height: 200px;
		z-index: 2;
	}
	label[for="upload"] {
		position: absolute;
		top: 0;
		left: 0;
		display: flex;
		justify-content: center;
		align-items: center;
		width: 200px;
		height: 200px;
		border: 1px solid black;
		border-radius: 50%;
		overflow: hidden;
		font-size: 14px;
		text-align: center;
		background-position: center;
		background-size: auto 100%;
		background-repeat: no-repeat;
	}
</style>
</head>
<body>

<h1><a href="${cpath }">ajax 활용 파일 업로드 & 미리보기</a></h1>
<hr>
