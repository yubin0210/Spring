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

<h1>ex03 - DTO를 활용한 업로드 + DB저장</h1>
<hr>

<form method="POST" enctype="multipart/form-data">
	<!-- private MultipartFile upload; -->
	<p><input type="file" name="upload" required></p>
	
	<p><input type="text" name="memo" placeholder="파일 간단한 설명"></p>
	<p><input type="submit" value="업로드"></p>
</form>

<div style="display: flex; flex-flow: wrap; width: 900px; margin: auto;">
	<c:forEach var="dto" items="${list }">
	<div class="item" 
		 style="margin: 10px; 
		  		text-align: center; 
		  		width: 200px; 
		  		background-color: #eee;">
		<p><img src="${cpath }/upload/${dto.storedFileName}" height="150"></p>
		<p>${dto.idx} | ${dto.memo }</p>
		<p>${dto.uploadDate }</p>
		<p>
			<a href="${cpath }/upload/${dto.storedFileName}"
			   target="_blank"
			   download="${dto.originalFileName }"><button>다운로드</button></a>
			<a href="${cpath }/ex03/delete/${dto.idx}"><button>삭제</button></a>
		</p>
	</div>
	</c:forEach>
</div>

<c:if test="${not empty msg }">
	<script>
		alert('${msg}')
	</script>
</c:if>

</body>
</html>










