<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	const msg = '${msg}'
	const url = '${url}'
	const cpath = '${cpath}'
	alert(msg)
	if(url == '') {
		history.go(-1)
	}
	else {
		location.href = cpath + url
	}
</script>
</body>
</html>