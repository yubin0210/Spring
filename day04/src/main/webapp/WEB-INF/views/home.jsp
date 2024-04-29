<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>
	<h3>대문 페이지</h3>
	
	<details>
		<summary>Hash와 Encryption</summary>
		<fieldset>
			<p>
			Hash는 기호 # 으로 나타내며, 데이터를 파편, 조각낸다는 의미이다<br>
			원본 데이터를 알아볼 수 없도록 분해하며, 보통 16진수 형태로 나타낼 수 있다<br>
			원본 데이터를 해시 처리하면 새로운 형태의 데이터가 나오는데<br>
			결과 데이터를 이용하여 다시 원본을 유추할 수 없다는 특징이 있다<br>
			한번 해시처리된 데이터는 원본으로 되돌릴 수 없으나<br>
			원본이 동일하면 해시값도 동일하다는 특성이 있어서, 일치 비교에 사용할 수 있다
			</p>
			
			<p>
			Encryption, 암호화는 원본 데이터에 특정 key를 이용하여 데이터를 알아볼 수 없게 변형한다<br>
			해시와는 달리 변경된 데이터를 다시 원본으로 복구할 수 있으며,<br>
			이때는 암호화 방식에 따른 key가 필요하다<br>
			암호화된 데이터를 복구하는 작업을 복호화(decryption)라고 한다<br>
			암호화 방식에 따라, 암호화/복호화 키가 동일한 경우는 대칭키 라고 한다<br>
			암호화/복호화 키가 서로 다른 경우는 비대칭키라고 한다<br>
			주로 네트워크 상에서 송신측 메시지를 암호화하여 전송하고, 수신측에서 복호화하여 나타낸다 
			</p>
		</fieldset>
	</details>
</section>

</body>
</html>