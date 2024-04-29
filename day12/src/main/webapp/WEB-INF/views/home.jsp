<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
<script src="${cpath }/resources/js/script.js"></script>
<style>

</style>
</head>
<body>

<h1>day12</h1>
<hr>

<div id="modal" class="hidden">
	<div class="content">
		<form id="addForm">
			<h3>일정 추가하기</h3>
			<p><input type="text" name="memo" placeholder="메모" required></p>
			<p><input type="date" name="sDate" required></p>
			<p>
				<input type="submit" value="등록">
				<input id="close" type="button" value="돌아가기">
			</p>
		</form>
	</div>
	<div class="overlay"></div>
</div>

<div class="buttons">
	<button id="open">일정 추가</button>
</div>

<div id="root">
	<div class="menu">
		<div class="item selected">짱구</div>
		<div class="item">예랑</div>
		<div class="item">현웅</div>
		<div class="item">원지</div>
		<div class="item">승호</div>
		<div class="item">제은</div>
	</div>
	<div class="content">
		<div class="item selected">1</div>	
		<div class="item">2</div>
		<div class="item">3</div>	
		<div class="item">4</div>	
		<div class="item">5</div>	
		<div class="item">6</div>	
	</div>
</div>

<script>
	// 데이터 불러오기
	// 이벤트 대상
	const menuItems = document.querySelectorAll('.menu > .item')
	const contentItems = document.querySelectorAll('.content > .item')
	
	menuItems.forEach(menuItemsHandler)
</script>

<script>
	// 데이터 추가하기
	const modal = document.getElementById('modal')
	const open = document.getElementById('open')
	const close = document.getElementById('close')
	const overlay = document.querySelector('#modal > div.overlay')
	const addForm = document.getElementById('addForm')
	
	open.onclick = event => modal.classList.remove('hidden')
	close.onclick = event => modal.classList.add('hidden')
	overlay.onclick = event => modal.classList.add('hidden')
	
	addForm.onsubmit = submitHandler
	
	
	window.onload = e => {
		const event = new Event('click')
		document.querySelector('.menu > .item').dispatchEvent(event)
	}
</script>

</body>
</html>

