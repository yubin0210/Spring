<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table>
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>작성날짜</th>
	</tr>
<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.idx }</td>
		<td>${dto.title }</td>
		<td>${dto.content }</td>
		<td>${dto.writer }</td>
		<td>${dto.writeDate }</td>
	</tr>
</c:forEach>
</table>
<a href="${cpath }/board/write"><button>새 글 작성</button></a>

</body>
</html>