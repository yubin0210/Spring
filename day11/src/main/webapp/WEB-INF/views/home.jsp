<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>day11</h1>
<hr>
<h3>오늘은 <fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일" /> 입니다</h3>

<p><a href="product/insert">상품 등록</a></p>
<p><a href="product/list">상품 목록</a></p>
 
</body>
</html>