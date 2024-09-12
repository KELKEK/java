<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.servletContext.contextPath}/static/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$("#btn1").on("click", f1);
	
});

function f1(){

	
	var job_id = $("#job_id").val(); 
	var dept_id = $("#dept_id").val();
	var salary = $("#salary").val();
	var hiredate = $("#hiredate").val();
	//1)이것은 jquery 2)var aa = ${emplist} <- 이녀석은 JSP(EL문법), 3)var myname="jj"; var bb= `나의 이름은 ${myname}`; <- javascript의 백틱문법
	//JavaScript의 백틱문법 : JSP문법과 혼동이 나므로 JSP에서 백틱은 \$를 사용한다.
	//4)JSTL문법(Tag Library) <c:forEach....
	
	
	//요청하는 주소를 바꿈, 내 주소는 가만히 있는데 그대로 찍히는걸 보고싶을 때는 ajax쓰기
	//location.href="";
	$.ajax({
		url:"retrieve.do", //get방식으로 data를 집어넣는 대신에 쓴 방법
		type:"post",
		data:{"jobid":job_id, "deptid":dept_id, "salary":salary, "hiredate":hiredate},
		success:function(responseData){
			$("#here").html(responseData);
			
		},
		error:function(xhr, status, error){
 			alert(error);
 		//Ajax가 실패, 보안실패, 주소오류 <- 입력실패랑은 다름
 		}
	});
}

function call(empid){
	$.ajax({
		url:"empDetail",
		type:"get",
		data:{"empid" : empid},
		success:function(responseData){
			$("#here2").html(responseData);
		}
	})	
}



</script>
</head>
<body>

${pageContext.request.servletContext.contextPath}
<%--절대경로 불러오고 싶을 때('/werhop24'가 나옴) --%>
<h1>조건조회</h1>
직책선택 : 
<select id="job_id">
<c:forEach var="job" items="${job_datas}">
	<option value="${job.job_id}" ${job.job_id=='IT_PROG'?"selected":""}>${job.job_id}/${job.job_title}</option>
</c:forEach>
</select>

부서선택:
<select id="dept_id">
<c:forEach var="dept" items="${dept_datas}">
	<option value="${dept.department_id}" ${dept.department_id==60?"selected":""}>${dept.department_id}/${dept.department_name}</option>
</c:forEach>
</select>

급여(이상):<input type="number" id="salary" value="10000">
입사일(이후):<input type="date" id="hiredate" value="2005-01-01">
<button id="btn1">조건조회</button>
<hr>
<div id="here">여기</div>
<div id="here2">여기</div>
</body>
</html>