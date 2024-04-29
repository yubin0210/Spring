<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시글 조회</h3>

<table>
	<tr>
		<td>${dto.isNotice == 1 ? '[공지]' : dto.idx } ${dto.title }</td>
	</tr>
	<tr>
		<td>작성자 : ${dto.writer } | ${dto.writeDate }</td>
	</tr>
	<tr>
		<td>
			<pre>${dto.content }</pre>
		</td>
	</tr>
</table>

<div style="display: flex; width: 800px; margin: 20px auto; justify-content: space-between;">
	<div></div>
	<div>
		<a href="${cpath }/board/delete/${dto.idx}"><button>삭제</button></a>
	</div>
</div>

</body>
</html>