<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Gugi&family=Jua&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Gugi&family=Jua&family=Nanum+Brush+Script&family=Orbit&display=swap" rel="stylesheet">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="wave.css">
<style>
/*
inline : content만큼만 자리 차지(width 불가), label, input
block : 한 라인 자리차지(width 가능)
inline-block : inline요소가 block의 특징을 가질 수 있음, input
*/
.deco{
	background-color : rgba(0, 0, 128, 0.5);
	font-family: "Jua", sans-serif;
	border-radius : 30px;
	height : 40px;
	color : orange;
	line-height : 40px;
	font-size: 20px;
}
.shadow1{
	text-shadow : 5px 5px 3px orange;

}
h1{
	height : 60px;
    font-family: "Jua", sans-serif;
    font-weight: 400;
    font-style: normal;
	background-image: url("enterprise.jpeg");
	color : white;
	text-align : center;
	line-height: 60px; 
}
legend{
	font-family: "Jua", sans-serif;
	color : navy;
}
label{
	background-image : url('shinhann.png');
	background-size : contain;
	background-repeat : no-repeat;
	background-position : left-center;
	width : 150px;
	display : inline-block;
	font-family: "Jua", sans-serif;
	padding-left : 30px;
	
}
#container{
	width : 800px;
	margin : 0 auto;
}
input{
	width : 300px;
}
/* input[value]{/*input 요소의 value 속성이 존재하는가*/ */
/* 	background-color : cyan; */
/* } */
/* input[type="submit"], input[type="reset"]{ */
/* 	background-color : navy; */
/* } */
input:focus{
	background-color : beige;
}
/* label:hover, input[type="submit"]:hover{ */
/* 	background-color : hotpink; */
/* } */


/*
.aa > label{ /*'>'는 자식을 의미(한칸 띄워도 됨)
	background-color : skyblue
}*/
body{
	background: linear-gradient(lightCyan, skyBlue, deepSkyBlue);
}
h2{
    font-family: "Orbit", sans-serif;
    font-weight: 400;
    font-style: normal;
    font-size : 40px;
    animation-duration : 5s;
    animation-name : slidein;
    animation-iteration-count : infinite;
}
@keyframes slidein {
  from {
    margin-left: 100%;
    width: 300%;
  }

  to {
    margin-left: 0%;
    width: 100%;
  }
}
</style>
<!-- 링크는 css, 스크립트는 자바스크립트 사용 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<section>
  <div class='air air1'></div>
  <div class='air air2'></div>
  <div class='air air3'></div>
  <div class='air air4'></div>
</section>
<div id="container">
<h1 class="shadow1">신규직원등록</h1>
<!--
HTML 주석 : 개발자에게 코드를 설명하기 위함함

  -->
  <%--
  JSP주석 : JSP문서를 보는 사람을 위한 설명
  method = get => 주소창에 서버에 전달되는 파라메타가 노출된다. 자동으로 인코딩된다. 자리수 제한 있음(4096byte)
  method = post => 주소창에 서버에 전달되는 파라메타가 보이지 않는다. 요청문서의 body에 넘어간다.
  기본 디폴트는 get방식이다.
  submit버튼을 누르면 자동으로 action으로 간다. (input들을 action에 전달)
  ㄴ input 태그에 name을 전달하는 것(name이 parameter이름)이므로 name이 있어야 함
  
  name : 문서 내에서 같은 이름이 여러 개 가능
  id : 문서 내에서 유일하다.
   --%>
<form action="empDBInsert.jsp" method = "post">
<fieldset>

<legend><img src="building.png" alt="빌딩" width="20" height="20"> 필수항목</legend>
<label>직원번호</label>
<input type="number" name="employee_id"><br>
<label>last_name</label>
<input type="text" name="last_name"><br>
<label>email</label>
<input type="email" name="email"><br>
<label>hire_date</label>
<input type="date" name="hire_date"><br>
<label>job_id</label>
<input type="text" name="job_id" value = "IT_PROG"><br>
</fieldset>


<fieldset>
<legend><img src="building.png" alt="빌딩" width="20" height="20"> 선택입력</legend>
<label>First_name</label>
<input type="text" name="first_name"><br>
<label>phone_number</label>
<input type="text" name="phone_number" placeholder="[01]{3}-[0-9][3,4]-[0-9]{4}" pattern="[01]{3}-[0-9]{3,4}-[0-9]{4}"><br>
<label>salary</label>
<input type="number" name="salary" value ="0"><br>
<label>Commission_pct</label>
<input type="text" name="commission_pct"><br>
<label>manager_id</label>
<input type="number" name="manager_id"><br>
<label>department_id</label>
<input type="number" name="department_id"><br>
</fieldset>


<input class = "deco, btn btn-success" type="submit" value="입력" >
<input class = "deco btn btn-success" type="reset" value="초기화" >

<h2>신한DS에 방문하신 것을 환영합니다!!!</h2>
</form>
</div>
</body>
</html>