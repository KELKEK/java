<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.servletContext.contextPath}/static/js/jquery-3.7.1.min.js"></script>
<script>
function call(deptid){
	$.ajax({
		url:"empByDept.do",
		type:"post",
		data:{"deptid":deptid},
		success:function(responseHTML){
			$("#container2").html(responseHTML);
		}
	})
}

</script>
<style>
#container1{
	width: 50%;
	float:left;
}
#container2{
	width: 50%;
	float:left;
}
</style>
</head>
<body>
<h1>binding연습2</h1>
<p>1. ServletContext:${applicationScope.appData}</p>
<p>2. HttpSession:${sessionScope.sessionData}</p>
<p>3. HttpServletRequest:${requsetScope.requestData}</p>

<h1>부서목록</h1>
<div id="container1">
<table border="1px solid black" id="tb1">
	<thead>
	<tr>
	<th>부서ID</th>
	<th>부서명</th>
	<th>매니저ID</th>
	<th>위치ID</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${deptlist}" var="dept">
	<tr>
	<td><a href="javascript:call(${dept.department_id})">${dept.department_id}</a></td>
	<td>${dept.department_name}</td>
	<td>${dept.manager_id}</td>
	<td>${dept.location_id}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<div id="container2">

</div>

</body>
</html>