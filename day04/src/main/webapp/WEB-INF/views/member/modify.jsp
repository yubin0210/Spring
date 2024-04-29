<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	<h3>정보수정</h3>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" value="${dto.userid }" required readonly></p>
		<p><input type="password" name="userpw" placeholder="Password" required></p>
		<p><input type="text" name="username" placeholder="Name" value="${dto.username }" required></p>
		<p><input type="email" name="email" placeholder="email" value="${dto.email }" required></p>
		<p>
			<label><input type="radio" name="gender" value="남성" ${dto.gender == '남성' ? 'checked' : '' } required>남성</label>
			<label><input type="radio" name="gender" value="여성" ${dto.gender == '여성' ? 'checked' : '' } required>여성</label>
		</p>
		<p><input type="submit" value="수정완료"></p>
	</form>
</section>

</body>
</html>