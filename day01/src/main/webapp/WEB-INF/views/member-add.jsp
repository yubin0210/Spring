<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member-add.jsp</title>
</head>
<body>

<h1>member-add.jsp</h1>
<hr>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="text" name="username" placeholder="Name" required></p>
	<p><input type="text" name="gender" placeholder="남성/여성" required></p>
	<p><input type="email" name="email" placeholder="email" required></p>
	<p><input type="submit"></p>
</form>

</body>
</html>

