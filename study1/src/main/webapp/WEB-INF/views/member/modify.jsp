<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" value="${dto.userid }" required readonly></p>
	<p><input type="text" name="username" placeholder="Name" value="${dto.username }" required></p>
	<p><input type="password" name="userpw" placeholder="Password" required autofocus></p>
	<p><input type="email" name="email" placeholder="이메일" value="${dto.email }" required></p>
	<p>
		<label><input type="radio" name="gender" value="남성" required>남성</label>
		<label><input type="radio" name="gender" value="여성" required>여성</label>
	</p>
	<p><input type="submit" value="수정"></p>
</form>

</body>
</html>