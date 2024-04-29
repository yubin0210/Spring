<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
	table.surveyList {
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
	.sb {
		display: flex;
		justify-content: space-between;
	}
</style>

<h3>설문 목록</h3>

<table class="surveyList">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>참여인원</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.idx }</td>
		<td>
			<div class="sb">
				<div>${dto.title }</div>
				<div>
					<a href="${cpath }/survey/vote/${dto.idx}"><button>설문참여</button></a>
					<a href="${cpath }/survey/result/${dto.idx}"><button>결과보기</button></a>
				</div>
			</div>
		</td>
		<td>${dto.writer }</td>
		<td>${dto.responseCount }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>