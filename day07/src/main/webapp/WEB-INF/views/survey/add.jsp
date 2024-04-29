<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<style>
	input[type="text"] {
		all: unset;
		border-bottom: 1px solid #dadada;
		padding: 10px 0;
		margin: 10px auto;
	}
	input[name="title"] {
		font-size: 24px;	
		width: 500px;
	}
	div.flex {
		display: flex;
		justify-content: space-around;
		width: 800px;
		margin: 20px auto;
	}
	form div.flex > div {
		box-shadow: 5px 5px 5px grey;
		background-color: #eee;
		padding: 20px;
	}
	form > *:not(.flex) {
		display: flex;
		justify-content: center;
	} 
	
</style>
<h3>추가</h3>

<form method="POST" enctype="multipart/form-data">
	<div><input type="text" name="title" placeholder="설문 제목" required autofocus></div>
	<div class="flex">
		<div>
			<div><input type="file" name="upload1" required></div>
			<div><input type="text" name="option1" placeholder="문항1" required></div>
		</div>
		<div>
			<div><input type="file" name="upload2" required></div>
			<div><input type="text" name="option2" placeholder="문항2" required></div>
		</div>
	</div>
	<input type="hidden" name="writer" value="${login.userid }" readonly>
	<p><input type="submit"></p>
</form>

</body>
</html>