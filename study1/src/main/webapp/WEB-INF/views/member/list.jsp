<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<table>
	<tr>
		<th>No</th>
		<th>ID</th>
		<th>email</th>
		<th>이름</th>
		<th>성별</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.userid }</td>
			<td>${dto.email }</td>
			<td>${dto.username }</td>
			<td>${dto.gender }</td>
			<c:if test="${login.userid == dto.userid }">
				<td><a href="${cpath }/member/delete/${dto.idx }"><button>삭제</button></a></td>
				<td><a href="${cpath }/member/update/${dto.idx }"><button>정보수정</button></a></td>
				<td><a href="${cpath }/member/${dto.idx}"><button>상세보기</button></a></td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</body>
</html>