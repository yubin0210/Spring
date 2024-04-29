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
</style>

<h3>${dto.title }</h3>

<div class="flex">
		<div>
			<h4>${dto.option1 }</h4>
			<img src="${cpath }/upload/${dto.image1}" height="200">
			<div>득표 수 : ${dto.choice1Count } (${dto.choice1Rate }%)</div>
		</div>
		<div>
			<h4>${dto.option2 }</h4>
			<img src="${cpath }/upload/${dto.image2}" height="200">
			<div>득표 수 : ${dto.choice2Count } (${dto.choice2Rate }%)</div>
		</div>
	</div>

</body>
</html>