<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>room.jsp - ${room.name }</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script>
	// 자바스크립트 함수 정의
	function onReceive(chat) {					// 메시지를 받으면
		const content = JSON.parse(chat.body)	// JSON을 객체로 변환하고
		const from = content.from				// 누구에게서 온 메시지인지
		const text = content.text				// 어떤 내용인지
		let str = ''
		str += '<div class="' + (from == 'service' ? 'service' : from == username ? 'right' : 'left') + '">'
		str += '<div>'
		str += '<b>' + (from != 'service' ? from + ': ' : '') + text + '</b>'
		str += '<br><sub>' + content.time + '</sub>'
		str += '</div></div>'
		messageArea.innerHTML += str						// 태그로 구성하여 화면에 반영
		messageArea.scrollTop = messageArea.scrollHeight	// 스크롤 이동시키기
	}
	
	function onConnect() {
		console.log('STOMP Connection')
		stomp.subscribe('/broker/room/' + roomId, onReceive)	// 구독할 채널, 메시지 받으면 실행할 함수
		stomp.send('/app/enter/' + roomId, {}, JSON.stringify({	// 서버에게 입장 메시지와 시간을 보낸다
			roomId: roomId,
			from: username,
			//time: getCurrentHHmm(),
		}))
		document.querySelector('input[name="msg"]').focus()
	}
	
	function onInput() {	// 클라이언트가 메시지를 입력할 때
		const text = document.querySelector('input[name="msg"]').value	// 내용을 불러와서
		if(text == '') {												// 내용이 없으면 중단
			return
		}
		document.querySelector('input[name="msg"]').value = ''			// 입력창을 비워준다
		
		stomp.send('/app/message/' + roomId, {}, JSON.stringify({		
			roomId: roomId,			// 방번호, 사용자, 내용을 JSON으로 보낸다
			from: username,
			text: text,
			//time: getCurrentHHmm()
		}))
		document.querySelector('input[name="msg"]').focus()	// 다시 입력할 수 있도록 포커스를 잡아준다
	}
	
	// JSP에서 자바스크립트로 넘기는 변수
	const roomName = '${room.name}'
	const roomId = '${room.roomId}'
	const username = '${username}'
	const cpath = '${cpath}'
	
	
</script>
<style>
	#messageArea {
		border: 2px solid black;
		width: 700px;
		height: 250px;
		margin: 20px 0;
		word-wrap: break-word;
		overflow-y: scroll;
		scroll-behavior: smooth;
	}
	#messageArea > div > div {
		margin: 10px;
		padding: 10px 20px;
		border: 0.5px solid black;
		border-radius: 20px;
		width: fit-content;
		box-shadow: 2px 2px 2px grey;
	}
	.service {
		display: flex;
		justify-content: center;
	}
	.service > div {
		background-color: #f5f6f7;
	}
	.left {
		display: flex;
		justify-content: flex-start;
	}
	.right {
		display: flex;
		justify-content: flex-end;
	}
	.right > div {
		background-color: yellow;
	}
	.service sub {
		clear: both;
		display: none;
	}
	sub {
		color: grey;
	}
	.left sub {
		float: left;
	}
	.right sub {
		float: right;
	}
</style>

</head>
<body>

<h1><a href="${cpath }">room.jsp - ${room.name }</a></h1>
<hr>

<div id="messageArea"></div>
<div id="input">
	<input type="text" name="msg" id="msg" placeholder="내용을 입력하세요">
	<input type="button" value="send">
	<a id="disconnect" href="${cpath }/chat/rooms"><button>나가기</button></a>
</div>

<script>
	if(roomId == '') {
		location.href = cpath
	}
	
	const messageArea = document.getElementById('messageArea')
	const sockJS = new SockJS(cpath + '/endpoint')
	const stomp = Stomp.over(sockJS)
	
	const sendBtn = document.querySelector('input[value="send"]')
	const msgInput = document.querySelector('input[name="msg"]')
	const leaveLink = document.getElementById('disconnect')
	
	stomp.connect({}, onConnect)
	
	// leaveLink.onclick = onDisconnect
	sendBtn.onclick = onInput
	msgInput.onkeyup = function(e) {
		if(e.key == 'Enter') onInput()
	}
</script>

</body>
</html>






