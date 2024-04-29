// HTML 문서를 불러오지 않아도 설정할 수 있는 전역 변수 및 함수 정의
function itemListClickHandler(event) {		// 이벤트 핸들러
	document.querySelectorAll('.menu > .item').forEach(item => {
		item.classList.remove('selected')
	})
	event.target.classList.add('selected')
}

function getDateStringFromLong(num) {
	const days = ['일', '월', '화', '수', '목', '금', '토']
	const date = new Date(num)
	const yyyy = date.getFullYear()
	let mm = date.getMonth() + 1
	let dd = date.getDate()
	let day = date.getDay()
	if(mm < 10) mm = '0' + mm
	if(dd < 10) dd = '0' + dd
	return `${yyyy}년 ${mm}월 ${dd}일 ${days[day]}요일`
}

function getHTMLfromJson(json) {	// json은 배열, 배열 내부에는 idx, sDate, memo 속성이 있음
	let tag = ''
	tag += `<table>`
	tag += `	<thead>`
	tag += `		<tr>`
	tag += `			<th>번호</th>`
	tag += `			<th>날짜</th>`
	tag += `			<th>내용</th>`
	tag += `			<th>삭제</th>`
	tag += `		</tr>`
	tag += `	</thead>`
	tag += `	<tbody>`
	json.forEach(dto => {
		tag += `<tr>`
		tag += `	<td>${dto.idx}</td>`
		tag += `	<td>${getDateStringFromLong(dto.sDate)}</td>`
		tag += `	<td>${dto.memo}</td>`
		tag += `	<td><button class="delete" idx="${dto.idx}">삭제</button></td>`
		tag += `</tr>`
	})
	tag += `	</tbody>`
	tag += `</table>`
	return tag
}

async function menuClickHandler(event) {
	// 0) 반복문의 인덱스 대신, 이벤트 대상이 menu item의 몇번째인지 찾아낸다
	const arr = Array.from(document.querySelectorAll('.menu > .item'))
	const index = arr.indexOf(event.target)
	
	// 1) 어떤 주소로 요청을 보낼 것인가 결정
	const url = urls[index]

	// 2) 주소로 요청하여 json데이터를 받아온다
	const json = await fetch(url).then(resp => resp.json())
	
	// 3) 받아온 json을 HTML 태그 문자열로 변환한다
	const tag = getHTMLfromJson(json)
	// console.log(json)
	// console.log(tag)

	// 4) 태그를 삽입할 HTMLElement를 찾아서 태그를 넣는다
	const content = document.querySelector('#root > .content')
	content.innerHTML = tag
}

async function submitHandler(event) {
	event.preventDefault()
	// 1) 보낼 데이터를 자바스크립트 객체로 준비한다
	const ob = {
		sDate: form.querySelector('input[name="sDate"]').value,
		memo: form.querySelector('input[name="memo"]').value,
	}
	
	// 2) 요청 주소 및 옵션(요청 메서드, 내용, 헤더 등)을 준비한다
	const url = cpath + '/schedules'
	const opt = {
		method: 'POST',
		body: JSON.stringify(ob),
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		}
	}
	
	// 3) 요청을 보내서 응답이 1이면 첫번째 메뉴의 내용을 새로 불러온다
	const result = await fetch(url, opt).then(resp => resp.text())
	if(result == 1) {
		document.querySelector('.menu > .item').dispatchEvent(new Event('click'))
	}
	
	// 4) 모달을 닫는다
	document.getElementById('close').dispatchEvent(new Event('click'))
}























