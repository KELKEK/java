<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/webproject/JS/jquery-3.7.1.min.js"></script>
<!-- 이제부터 jQuery를 쓸 수 있다. -->
<title>Insert title here</title>
<style>
#container{
	width : 1200px;
	border : 1px solid gray;
	margin : 0 auto;
}
table, th, td{
	border-collapse : collapse;
}
th, td{
	padding : 10px;
	text-align : center;
}
td[data-lname]{
	font-size : 20px;
	color : blue;
}
td[data-lname ^= 'B'], td[data-lname $= 's']{
	color : red;
}
td[data-job *= 'IT']{
	background-color : yellow;
}
td[data-hdate |='2005']{
	color : hotpink;
}
thead{
	background-color : gray;
	color : black;
}
/*  한 칸을 띄우면 자손을 의미 (tbody밑에 있는 tr) , nth-child(2n) : 짝수번째 자식 */
tbody tr:nth-child(2n){
	background-color : lightgray;
}
tbody tr:nth-child(2n+1){

}
h1{
	height : 100px;
	line-height : 100px;
	text-align : center;
	border : 1px solid gray;
	background-color : black;
	color : orange;
}

a.decoNone{
	text-decoration : none;
/* 	background-color : black; */
/* 	color : white; */
	padding : 10px;
	border-radius : 30px;
}
/*data 중에 첫번째 td의 border색깔 바꾸기*/
tbody tr:nth-child(1){
	border : 2px solid hotpink;
	background-color : orange;
}
tbody tr:nth-of-type(2){
	border : 2px solid hotpink;
	background-color : yellow;
}
td:nth-child(3n){
	border : 3px dotted green;
	background : cyan;
}
tbody tr:last-child{/*tbody의 자식인 tr중에 last child의 색깔을 바꿔줌*/
	background-color : orange;
}
.caption::after, .caption::before{
	content:"@@@@@@";
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
 <script>
 	$(function(){
 		$("#btn1").on("click", function(){
 			$("tr td:nth-child(4)").css("color", "black");
 			$("tr td:nth-child(4)").filter(function(index, item){
 				return $(item).text().indexOf($("#email").val()) >= 0;
 			}).css("color", "red");
 		});
 	});
 	$(function(){
 		$("#btn2").on("click", function(){
 			$("tr td:nth-child(8)").css("color", "black");
 			$("tr td:nth-child(8)").filter(function(index, item){
 				return Number($(item).text()) >= Number($("#salary").val());
 			}).css("color", "red");
 		});
 	});
 </script>
</head>
<body>
<div id="container">
<h1>전체 직원 정보</h1>
<a class = "decoNone, btn btn-danger" href="empInsert.jsp">신규직원 등록</a>
<input type="text" id="email" value="R">
<button id="btn1">이메일찾기</button>
<input type="number" id="salary" value="10000">
<button id="btn2">급여찾기</button>
<table border="1">
	<caption class="caption">직원목록</caption>
	<thead>
		<tr>
		<th>직원번호</th>
		<th>First_name</th>
		<th>Last_name</th>
		<th>Email</th>
		<th>Commission_pct</th>
		<th>Department_id</th>
		<th>Phone_number</th>
		<th>Salary</th>
		<th>Hire_date</th>
		<th>Manager_id</th>
		<th>Job_id</th>
		</tr>
	<tbody>
	<%
	EmpService eservice = new EmpService();
	List<EmpDTO> emplist = eservice.selectAll();
	%>
	<%for(EmpDTO emp:emplist){ %>
	<tr>
	<td>
	<a href="empDetail.jsp?empid=<%= emp.getEmployee_id()%>">
		<%= emp.getEmployee_id()%>
	</a>
	</td>
	<td>
	<a href="empDetail.jsp?empid=<%= emp.getEmployee_id()%>">
	<%= emp.getFirst_name()%>
	</a>
	</td>
	<td data-lname="<%= emp.getLast_name()%>"><%= emp.getLast_name()%></td>
	<td><%= emp.getEmail()%></td>
	<td><%= emp.getCommission_pct()%></td>
	<td><%= emp.getDepartment_id()%></td>
	<td><%= emp.getPhone_number()%></td>
	<td><%= emp.getSalary()%></td>
	<td data-hdate="<%= emp.getHire_date()%>"><%= emp.getHire_date()%></td>
	<td><%= emp.getManager_id()%></td>
	<td data-job="<%= emp.getJob_id()%>"><%= emp.getJob_id()%></td>
	</tr>
	<%} %>
	</tbody>
</table>
</div>
</body>
</html>