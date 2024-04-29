<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex01 - 단순 파일 업로드</h1>
<hr>

<form method="POST" enctype="multipart/form-data">
	<input type="file" name="upload">
	<input type="submit">
</form>

</body>
</html>