<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex02 - 단순 파일 업로드</h1>
<hr>

<c:if test="${not empty fileName }">
	<p>fileName : ${fileName }</p>
	<p>fileSize : ${fileSize }</p>
	<p><img src="${cpath }/upload/${fileName}" height="100"></p>
</c:if>

<form method="POST" enctype="multipart/form-data">
	<input type="file" name="upload">
	<input type="submit">
</form>

</body>
</html>

