<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	const url = '${url}'
	const msg = '${msg}'
	const cpath = '${cpath}'
	
	if(url == '') {
		alert('비밀번호 재설정에 실패했습니다\n계정과 이메일을 다시 확인하시기 바랍니다')
		history.go(-1)
	}
	else {
		alert(msg)
		location.href = cpath + url
	}
</script>

</body>
</html>