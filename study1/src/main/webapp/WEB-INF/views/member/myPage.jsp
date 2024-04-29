<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
	table {
		border: 1px solid black;
	}
	tr, td {
		padding: 20px;
	}
</style>

<h1>마이페이지</h1>
<table>
	<tr>
		<th>No</th>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>성별</th>
	</tr>
	<tr>
		<td>${dto.idx}</td>
		<td>${dto.username }</td>
		<td>${dto.userid }</td>
		<td>********</td>
		<td>${dto.email }</td>
		<td>${dto.gender }</td>
	</tr>
</table>

</body>
</html>