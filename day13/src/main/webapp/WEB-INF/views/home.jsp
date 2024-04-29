<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day13</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
<style>

</style>
<script src="${cpath }/resources/js/function.js"></script>
<script>
	const cpath = '${cpath}'
	const urls = [
		'http://192.168.112.7:8080/day13/schedules',
		'http://192.168.112.31:8080/day13/schedules',
		'http://192.168.112.24:8080/day13/schedules',
		'http://192.168.112.30:8080/day13/schedules',
		'http://192.168.112.23:8080/day13/schedules',
		'http://192.168.112.13:8080/day13/schedules',
	]
</script>
</head>
<body>

<h1>day13</h1>
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
		<img src="${cpath }/resources/image/loading.gif">
	</div>
</div>

<script>

	// 문서가 모두 불러지면 특정 요소를 호출하여 이벤트를 연결하는 함수
	function loadHandler() {
		const itemList = document.querySelectorAll('.menu > .item')	// 이벤트 대상
		
		// 상단 메뉴를 클릭했을 때 스타일 옮겨가는 내용
		itemList.forEach(element => element.addEventListener('click', itemListClickHandler))
		
		// 상단 메뉴를 클릭했을 때 fetch로 데이터 불러와서 div#root > div.content에 내용 띄우기
		itemList.forEach(element => element.addEventListener('click', menuClickHandler))
		
		// 열기/닫기 버튼에 모달 작동 연결하기
// 		const modal = document.getElementById('modal')
		const btns = [
			document.getElementById('open'),
			document.getElementById('close'),
			document.querySelector('div.overlay'),
		]
		btns.forEach(b => b.onclick = event => modal.classList.toggle('hidden'))
		
		// form을 제출하면 자신의 서버에 POST로 등록하기
		const form = document.forms[0]
		form.onsubmit = submitHandler
	}
	
	window.addEventListener('DOMContentLoaded', loadHandler)
</script>

</body>
</html>

