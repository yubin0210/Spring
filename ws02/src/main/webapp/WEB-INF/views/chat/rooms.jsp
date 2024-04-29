<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방 목록</title>
</head>
<body>

<h1><a href="${cpath }">rooms.jsp - ${username }</a></h1>
<hr>

<fieldset>
	<form action="${cpath }/chat/rooms" method="POST">
		<input type="text" name="name" placeholder="방제" autocomplete="off" autofocus required>
		<input type="submit" value="채팅방 개설">
	</form>
</fieldset>

<ul>
	<c:forEach var="room" items="${list }">
		<li><a href="${cpath }/chat/room?roomId=${room.roomId}">${room.name }</a></li>
	</c:forEach>
</ul>

</body>
</html>