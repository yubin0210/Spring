<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
	const msg = '${msg}'
	const e = '${e}'
	const url = '${url}'	// url이 없으면 빈문자열이 된다
	const cpath = '${pageContext.request.contextPath}'
	
	alert(msg + ' : ' + e)
	if(url == '') {
		history.go(-1)
	}
	else {
		location.href = cpath + url
	}
</script>

</body>
</html>