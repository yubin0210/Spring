<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<p>
		<input type="text" name="title" placeholder="제목">
	</p>
	<p><input type="text" name="writer" value="${login.userid }" readonly></p>
	<p><textarea name="content" placeholder="내용"></textarea>
	<input type="file" name="image">
	<input type="submit" value="작성 완료">
</form>
</body>
</html>