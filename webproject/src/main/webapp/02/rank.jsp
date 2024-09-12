<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Popup Example</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.popup-button {
	margin: 20px;
	padding: 10px 20px;
	font-size: 16px;
	cursor: pointer;
}

.popup-overlay {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	display: none;
	justify-content: center;
	align-items: center;
	z-index: 999;
}

.popup-content {
	background: white;
	padding: 20px;
	border-radius: 10px;
	width: 80%;
	max-width: 1000px;
	height: 80%;
	overflow-y: auto;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

.popup-content .close-button {
	float: right;
	font-size: 24px;
	font-weight: bold;
	cursor: pointer;
}

.popup-table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	table-layout: fixed; /* 테이블 레이아웃 고정 */
}

.popup-table th, .popup-table td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
	white-space: nowrap; /* 자동 줄바꿈 방지 */
	overflow: hidden;
	text-overflow: ellipsis;
	font-size: 14px; /* 글자 크기 조정 */
}

.popup-table th {
	background-color: #f2f2f2;
}

.popup-table .header {
	font-size: 14px; /* 글자 크기 조정 */
	font-weight: bold;
	padding: 10px;
	white-space: normal; /* 자동 줄바꿈 허용 */
	word-wrap: break-word; /* 단어 줄바꿈 허용 */
}

.accordion {
	background-color: #f2f2f2;
	color: #444;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	font-size: 18px;
	transition: 0.4s;
}

.active, .accordion:hover {
	background-color: #ddd;
}

.panel {
	padding: 0 18px;
	display: none;
	background-color: white;
	overflow: hidden;
}

.family_circle {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	background: #513AE4;
	margin: 0px auto;
	font-family: 'Permanent Marker';
	font-style: normal;
	font-weight: 400;
	font-size: 20px; /* 글씨 크기 키움 */
	line-height: 60px; /* 원의 높이와 맞춤 */
	display: flex;
	align-items: center;
	justify-content: center; /* 가운데 정렬 추가 */
	text-align: center;
	color: #FFFFFF;
}

.bronze_circle {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	background: linear-gradient(180deg, #CD7F32 0%, #674019 65%, #9A5F26 100%);
	margin: 0px auto;
	font-family: 'Permanent Marker';
	font-style: normal;
	font-weight: 400;
	font-size: 20px; /* 글씨 크기 키움 */
	line-height: 60px; /* 원의 높이와 맞춤 */
	display: flex;
	align-items: center;
	justify-content: center; /* 가운데 정렬 추가 */
	text-align: center;
	color: #FFFFFF;
}

.silver_circle {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	background: linear-gradient(180deg, #EBEBEB 0%, #B4AEAE 65%, #BFBBBB 100%);
	margin: 0px auto;
	font-family: 'Permanent Marker';
	font-style: normal;
	font-weight: 400;
	font-size: 20px; /* 글씨 크기 키움 */
	line-height: 60px; /* 원의 높이와 맞춤 */
	display: flex;
	align-items: center;
	justify-content: center; /* 가운데 정렬 추가 */
	text-align: center;
	color: #FFFFFF;
}

.gold_circle {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	background: linear-gradient(180deg, #FFD700 0%, #DBA514 65%, #ECC440 100%);
	margin: 0px auto;
	font-family: 'Permanent Marker';
	font-style: normal;
	font-weight: 400;
	font-size: 20px; /* 글씨 크기 키움 */
	line-height: 60px; /* 원의 높이와 맞춤 */
	display: flex;
	align-items: center;
	justify-content: center; /* 가운데 정렬 추가 */
	text-align: center;
	color: #FFFFFF;
}

.diamond_circle {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	background: linear-gradient(180deg, #B9F2FF 0%, #4AA5FB 65%, #6DCEFC 100%);
	margin: 0px auto;
	font-family: 'Permanent Marker';
	font-style: normal;
	font-weight: 400;
	font-size: 20px; /* 글씨 크기 키움 */
	line-height: 60px; /* 원의 높이와 맞춤 */
	display: flex;
	align-items: center;
	justify-content: center; /* 가운데 정렬 추가 */
	text-align: center;
	color: #FFFFFF;
}

.ruby_circle {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	background: linear-gradient(180deg, #E2294F 0%, #7D1128 20%, #FF2C55 50%, #7D1128 80%, #E2294F 100%);
	margin: 0px auto;
	font-family: 'Permanent Marker';
	font-style: normal;
	font-weight: 400;
	font-size: 20px; /* 글씨 크기 키움 */
	line-height: 60px; /* 원의 높이와 맞춤 */
	display: flex;
	align-items: center;
	justify-content: center; /* 가운데 정렬 추가 */
	text-align: center;
	color: #FFFFFF;
}
</style>
</head>

<body>
	<button class="popup-button" onclick="openPopup()">Show Popup</button>

	<div id="popup-overlay" class="popup-overlay">
		<div class="popup-content">
			<span class="close-button" onclick="closePopup()">&times;</span>
			<h2>SAREN 멤버십 등급 혜택 안내</h2>
			<table class="popup-table">
				<tr>
					<th></th>
					<th><div class="ruby_circle">R</div></th>
					<th><div class="diamond_circle">D</div></th>
					<th><div class="gold_circle">G</div></th>
					<th><div class="silver_circle">S</div></th>
					<th><div class="bronze_circle">B</div></th>
					<th><div class="family_circle">F</div></th>
				</tr>
				<tr>
					<td class="header">등급</td>
					<td>RUBY</td>
					<td>DIAMOND</td>
					<td>GOLD</td>
					<td>SILVER</td>
					<td>BRONZE</td>
					<td>FAMILY</td>
				</tr>
				<tr>
					<td class="header">등급 선정 기준</td>
					<td>3,000만원 이상</td>
					<td>1,000만원 이상</td>
					<td>300만원 이상</td>
					<td>100만원 이상</td>
					<td>50만원 이상</td>
					<td>1회 이상 구매</td>
				</tr>
				<tr>
					<td class="header">멤버십 포인트적립</td>
					<td>포인트<br>기프트포인트 50만
					</td>
					<td>포인트<br>기프트포인트 30만
					</td>
					<td>포인트<br>기프트포인트 10만
					</td>
					<td>포인트<br>기프트포인트 5만
					</td>
					<td>포인트<br>기프트포인트 2만
					</td>
					<td>포인트<br>기프트포인트 1만
					</td>
				</tr>
			</table>
			<button class="accordion">등급 산정 기준</button>
			<div class="panel">
				<p>• 매월 1일 등급이 부여되며, 전월 20일까지 12개월간 실결제 구매액 합산 기준으로 산정됩니다.(예, 24년 7월 등급 : 23년 6월 21일 ~ 24년 6월 20일까지 실결제 구매액)<br>
				   • 등급 산정시 온/오프라인 자사상품 및 SSF샵 입점상품 금액 모두 포함됩니다. 단, 오프라인 아울렛 매장 구매금액은 아울렛 매장에서 통합 멤버십 가입 이후 구매금액만 포함됩니다.<br>
				   • 쿠폰 사용을 통한 할인액 제외, 실결제 금액 기준으로 등급이 산정됩니다.<br>
				   • 산정 기간 내 구매(주문) 취소/반품 시 등급이 하락할 수 있습니다.<br>
				   • 신규 가입 후 첫 구매 또는 1년 이상 미구매 후 구매 시 구매금액에 상관 없이 3일 후 FAMILY 등급이 부여됩니다.(단, 매월 25일 ~ 말일까지 구매 시에는 다음달 1일에 FAMILY 등급이 부여됩니다.)<br>
				   • 온라인 사이트에만 가입된 고객이 삼성패션 멤버십 통합 가입 시 기존 구매이력을 포함하여 등급이 산정됩니다.<br>
				   • 온라인 사이트에만 가입된 고객이 매월 20일 이내 삼성패션 통합가입 시 다음 달 멤버십 등급이 부여됩니다.(21일 이후 통합 가입 시 두 달 후 부터 등급 부여)<br>
				   • 삼성패션 멤버십 회원에게만 등급이 부여되며, 온라인 사이트 전용 회원은 등급이 부여되지 않습니다.<br>
				   • 멤버십 신규 가입 후 미 구매 고객, 최종 구매 1년 경과 고객에게는 별도 등급이 부여되지 않습니다.<br>
				   • 부당한 방법으로 획득한 고객등급은 재조정될 수 있습니다.</p>
			</div>
			<button class="accordion">멤버십 포인트 적립/사용 안내</button>
			<div class="panel">
				<p>• SAREN SHOP의 멤버십 포인트 적립률은 프로모션에 따라 정해진 적립률과 다르게 변경될 수 있습니다.<br>
				   • 아울렛 일부 매장은 포인트 적립에서 제외되며 일부 매장 및 상품(할인 적용 상품 등)은 상기 적립률과 다를 수 있습니다.<br>
				   • 온라인 구매 건은 구매 확정 8일 후 사용 가능한 포인트로 전환됩니다.<br>
				   • 멤버십 포인트는 상품별 100원 단위로 적립됩니다.<br>
				   • 최종 구매일로부터 1년 동안 구매 활동이 없을 시 멤버십 포인트는 자동 소멸됩니다.<br>
				   • 매장에서 삼성패션 브랜드 상품 구매 시 결제 전에 고객정보를 확인해 주시면 멤버십 포인트 적립 및 사용이 가능합니다.<br>
				   • 기존 마일리지는 포인트 조회페이지에서 멤버십 포인트로 전액 전환하여 사용하실 수 있습니다.<br>
				   • 멤버십 포인트 적립 내역 조회:<br>
				     - 고객센터(1599-0007) 전화 → 4번 멤버십 관련 문의<br>
				     - SSF SHOP > 마이페이지 > 나의 쇼핑 혜택 > 멤버십 포인트 확인<br>
				     - 상품 구매 시 멤버십 적립 및 사용에 대한 알림톡 안내 서비스 제공</p>
			</div>
			<button class="accordion">멤버십 혜택 유의사항</button>
			<div class="panel">
				<table class="popup-table">
					<tr>
						<th class="header">혜택</th>
						<th>내용</th>
					</tr>
					<tr>
						<td>생일축하 금액권</td>
						<td>생일월 첫 발급되며, 생일 다음달 마지막날까지 사용 가능합니다. (예, 3월 생일시 3월 첫 발급, 4월 30일까지 사용 가능)</td>
					</tr>
					<tr>
						<td>무료 AS 수선 서비스</td>
						<td>멤버십 등급에 따라 무료 AS 수선 서비스를 제공합니다.</td>
					</tr>
					<!-- 나머지 혜택 내용을 여기에 추가하세요 -->
				</table>
			</div>
		</div>
	</div>

	<script>
		function openPopup() {
			document.getElementById('popup-overlay').style.display = 'flex';
		}

		function closePopup() {
			document.getElementById('popup-overlay').style.display = 'none';
		}

		var acc = document.getElementsByClassName("accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
			acc[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var panel = this.nextElementSibling;
				if (panel.style.display === "block") {
					panel.style.display = "none";
				} else {
					panel.style.display = "block";
				}
			});
		}
	</script>
</body>

</html>