<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table.list {
	border: 1px solid black;
	border-collapse: collapse;
	width: 800px;
	margin: 20px auto;
	}
	td, th {
		padding: 5px 10px;
	}
	tr {
		border-bottom: 1px solid grey;
	}
	table tr:first-child {
		background-color: #dadada;
	}

</style>
</head>
<body>
<h1>상품 목록</h1>
<hr>

<table id="list">
	<tr>
		<th>No</th>
		<th>상품 이름</th>
		<th>이미지</th>
		<th>가격</th>
		<th>수량</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>
				<a href="${cpath }/product/view/${dto.idx}">${dto.name }</a>
			</td>
			<td>
				<img src="${cpath }/upload/${dto.image}" height="100">
			</td>
			<td>${dto.price }</td>
			<td>${dto.quantity }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>