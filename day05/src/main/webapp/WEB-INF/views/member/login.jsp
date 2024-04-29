<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	<h3>로그인</h3>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
		<p><input type="password" name="userpw" placeholder="Password" required></p>
		<p><input type="submit" value="로그인"></p>
		<a href="${cpath }/member/join">회원가입</a>
		<a href="${cpath }/member/resetPass">비밀번호 재설정</a>
	</form>
</section>

</body>
</html>