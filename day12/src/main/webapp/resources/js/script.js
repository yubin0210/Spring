const longToDateString = function(num) {
	const d = new Date(num)
	let yyyy = d.getFullYear()
	let mm = d.getMonth() + 1
	let dd = d.getDate()
	if(mm < 10) 	mm = '0' + mm
	if(dd < 10) 	dd = '0' + dd
	return yyyy + '년 ' + mm + '월 ' + dd + '일' 
}

const ipaddr = [
	'192.168.112.7',
	'192.168.112.31',
	'192.168.112.24',
	'192.168.112.30',
	'192.168.112.23',
	'192.168.112.13',
]

const menuItemsHandler = (element, index) => {
// 		element.onclick = clickHandler1
		element.addEventListener('click', function(event) {	// 이벤트 핸들러
			menuItems.forEach(menuItem => menuItem.classList.remove('selected'))
			contentItems.forEach(contentItem => contentItem.classList.remove('selected'))
			menuItems[index].classList.add('selected')
			contentItems[index].classList.add('selected')
			
			const url = 'http://' + ipaddr[index] + ':8080/day12/schedules'
			fetch(url).then(resp => resp.json())
					  .then(json => {
						  console.log(json)
						  contentItems[index].innerHTML = ''
						  let tag = '<table>'
						  tag += '		<thead>'
						  tag += '			<tr>'
						  tag += '				<th>날짜</th>'
						  tag += '				<th>메모</th>'
						  tag += '			</tr>'
						  tag += '		</thead>'
						  tag += '		<tbody>'
						  json.forEach(dto => {
							  tag += '		<tr>'
							  tag += '			<td>' + longToDateString(dto.sDate) + '</td>'
							  tag += '			<td>' + dto.memo + '</td>'
							  if(index == 0) {
								  tag += '<td><button class="delete" idx="' + dto.idx + '">삭제</button></td>'
							  }
							  tag += '		</tr>'
						  })
						  tag += '		</tbody>'
						  tag += '	</table>'
						  contentItems[index].innerHTML = tag
						  
						  if(index == 0) {
							  contentItems[index].querySelectorAll('.delete').forEach(e => e.onclick = event => {
								  const idx = event.target.getAttribute('idx')
								  
								  fetch(url + '/' + idx, {
									  method: 'delete'
								  }).then(resp => resp.text())
								    .then(text => {
								    	if(text == 1) {
								    		const de = new Event('click')
								    		document.querySelector('.menu > .item').dispatchEvent(de)
								    	}
								    })
							  })
						  }
					  })
		})	// 이벤트 리스너
	}
	
	
const submitHandler = event => {
		event.preventDefault()
		const ob = {
			sDate: event.target.querySelector('input[name="sDate"]').value,
			memo: event.target.querySelector('input[name="memo"]').value,
		}
		const url = 'http://' + ipaddr[0] + ':8080/day12/schedules'
		const opt = {
			method: 'POST',
			body: JSON.stringify(ob),
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			}
		}
		fetch(url, opt)
			.then(resp => resp.text())
			.then(text => {
				if(text == 1) {
					// 이벤트 강제 발생시키기
					const event = new Event('click')
					document.querySelector('.menu > .item').dispatchEvent(event)
					close.dispatchEvent(event)
				}
				else {
					alert('정상적으로 등록되지 않았습니다')
// 					document.querySelector('input').focus()
					document.querySelector('input').select()
				}
			})
	}