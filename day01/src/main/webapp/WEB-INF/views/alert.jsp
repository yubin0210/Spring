<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alert.jsp</title>
</head>
<body>

<script>
	const message = '${message}'
	const url = '${url}'
	const cpath = '${cpath}'
	
	if(message == '삭제 성공') {
		alert(message)
		location.href = cpath + url
	}
	else {
		alert(message)
		history.go(-1)
	}
</script>

</body>
</html>