<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
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
		border: 3px solid transparent; 
	}
	form > *:not(.flex) {
		display: flex;
		justify-content: center;
	} 
	form div.flex > div.selected {
		border: 3px solid lime; 
	}
	input[type="radio"] {
		display: none;
	}
</style>

<h3>${dto.title }</h3>

<form method="POST">
	<input type="hidden" name="writer" value="${login.userid }">
	<input type="hidden" name="survey_idx" value="${dto.idx }">
	<div class="flex">
		<div>
			<h4>${dto.option1 }</h4>
			<label>
				<img src="${cpath }/upload/${dto.image1}" height="200">
				<input type="radio" name="choice" value="1">
			</label>
		</div>
		<div>
			<h4>${dto.option2 }</h4>
			<label>
				<img src="${cpath }/upload/${dto.image2}" height="200">
				<input type="radio" name="choice" value="2">
			</label>
		</div>
	</div>
	<p align="center"><input type="submit"></p>
</form>

<script>
	const itemList = document.querySelectorAll('.flex > div')

	itemList.forEach(item => item.onclick = function() {
		itemList.forEach(e => e.classList.remove('selected'))
		item.classList.add('selected')
	})
</script>

</body>
</html>