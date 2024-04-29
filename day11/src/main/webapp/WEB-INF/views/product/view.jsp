<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>상품 정보</h1>
<hr>

<h1>${dto.name }</h1>
<div>
	<img src="${cpath }/upload/${dto.image}">
	<p>${dto.price }</p>
</div>
<a href="${cpath }/product/update+/${dto.idx}"><button>+</button></a>
<p>${dto.quantity }</p>
<a href="${cpath }/product/update-/${dto.idx}"><button>-</button></a>

</body>
</html>