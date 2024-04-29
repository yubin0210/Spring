<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ws02 - STOMP를 활용한 웹소켓 채팅</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
</head>
<body>

<h1>ws02 - STOMP를 활용한 웹소켓 채팅</h1>
<hr>

<div id="root">
	<form action="${cpath }/chat/rooms">
		<input name="username" required autofocus>
		<input type="submit" value="입장">
	</form>
</div>

</body>
</html>