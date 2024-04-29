<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex01 - ajax 단일 파일 업로드</h3>

<form method="POST" enctype="multipart/form-data">
	<p class="relative">
		<label for="upload">파일을 끌어서 놓거나<br>클릭하세요</label>
		<input id="upload" type="file" name="upload">
	</p>
	<p><input type="submit"></p>
</form>

<div id="result"></div>

<script>
	// AJAX 파일 업로드
	const form = document.forms[0]
	form.onsubmit = async function(event) {
		event.preventDefault()
		const url = '${cpath}/ajax/ex01'
		const formData = new FormData(event.target)
		const opt = {
			method: 'POST',
			body: formData
			// headers의 Content-Type을 지정하지 않으면 form태그에서 설정한 내용대로 제출한다
			// 파일은 문자열 형태로 전송할 수 없으므로, JSON 형식을 사용하지 않는다
		}
		const fileName = await fetch(url, opt).then(resp => resp.text())
		const result = document.getElementById('result')
		result.innerHTML = '<p>업로드 완료</p>'
		result.innerHTML += '<img src="${cpath}/upload/' + fileName + '" height="200">'
	}
	
	// 미리보기
	const inputFile = document.querySelector('input[id="upload"]')
	const preview = document.querySelector('label[for="upload"]')
	inputFile.onchange = function(event) {
        if(event.target.files && event.target.files[0]) {
            const reader = new FileReader()
            reader.onload = function(e) {
                preview.style.backgroundImage = 'url(' + e.target.result + ')'
                preview.style.fontSize = 0
            }
            reader.readAsDataURL(event.target.files[0])
        }
        else {
        	preview.style.fontSize = '14px'		
        }
    }
</script>

</body>
</html>