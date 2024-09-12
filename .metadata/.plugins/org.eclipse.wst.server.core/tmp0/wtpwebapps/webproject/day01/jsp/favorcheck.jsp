<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
@keyframes moveLeft {
	from { transform: translateX(-100%); }
	to { transform: translateX(0); }
}

@keyframes moveRight {
	from { transform: translateX(100%); }
	to { transform: translateX(0); }
}

h1 {
	background-color: yellow;
	text-align: center;
	color: red;
}

body {
	background: linear-gradient(to right, #1e130c, #9a8478); /* 그라데이션 배경 */
	background-size: cover; /* 배경 크기 */
	background-repeat: no-repeat; /* 배경 반복 방지 */
	background-attachment: fixed; /* 스크롤 시 배경 고정 */
	opacity: 0.7; /* 배경 투명도 조절 */
	color: white;
}

form {
	margin: 0 auto; /* 가운데 정렬 */
	width: 80%; /* 폼의 너비 조절 */
}

form > * {
	margin-bottom: 20px; /* 각 항목 아래 여백 추가 */
	display: inline-block; /* 항목을 인라인 요소로 배치 */
	vertical-align: middle; /* 항목을 수직 가운데 정렬 */
}

input[type="range"] {
	-webkit-appearance: slider-vertical;
	width: 10%; /* range input 너비 100%로 조절 */
	position: relative; /* 부모 요소에 대해 상대적으로 배치 */
	margin: 0 10px; /* 좌우 여백 추가 */
}

input[type="range"]::-webkit-slider-thumb {
  -webkit-appearance: none; /* 웹킷 브라우저에서 기본 스타일 제거 */
  appearance: none; /* 다른 브라우저에서 기본 스타일 제거 */
  width: 5%; /* thumb 크기 */
  height: 50px; /* thumb 크기 */
  background: white; /* thumb 색상 */
  border-radius: 8px; /* thumb 모양 */
  position: relative; /* thumb 상대적으로 배치 */
  top: -5px; /* thumb 수직 위치 조절 */
  box-shadow: 0px 0px 10px rgba(255, 255, 0, 0.8); /* 그림자 효과 */
}

/* 짝수 항목 애니메이션 */
form > .slider:nth-child(even) {
	animation: moveLeft 1s ease forwards;
}

/* 홀수 항목 애니메이션 */
form > .slider:nth-child(odd) {
	animation: moveRight 1s ease forwards;
}
</style>
</head>
<body>
<h1>COFFEE 선호도를 입력해주세요</h1>
<form action="inputfavor.jsp" method="post">
	고객 ID 입력 <input autofocus name="customer_id" required><br><hr>
	<h2>종류별 선호도</h2><br><br>
	1. 가격 <input name="price" id="price" class="slider" type="range" value="0" min="0" max="9" step="1">
	
	2. 카페인양 
	<input name="caffeine" id="caffeine" class="slider" type="range" value="0" min="0" max="9" step="1">
	
	3. 당분 
	<input name="sugar" id="sugar" class="slider" type="range" value="0" min="0" max="9" step="1">
	
	4. 원두품질 
	<input name="quality" id="quality" class="slider" type="range" value="0" min="0" max="9" step="1">
	
	5. 거리 
	<input name="distance" id="distance" class="slider" type="range" value="0" min="0" max="9" step="1"><br>
	
	<input type="submit" value="전송">
</form>


</body>
</html>
