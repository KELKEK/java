<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직업목록</h1>
<table border="1px solid black">
	<thead>
	<tr>
	<th>직업ID</th>
	<th>직업명</th>
	<th>최소급여</th>
	<th>최대급여</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${joblist}" var="job">
	<%--c:의 c는 위에서 쓰인 prefix="c"이다. JSTL문법을 사용하겠다는 의미
	items : 속성을 얻음(joblist속성을 얻음)--%>
	<tr>
	<%-- <td><a href="/webshop24/emp/joblist.do?empid=${job.job_id}">${job.job_id}</a></td>--%>
	<td>${job.job_id}</td>
	<td>${job.job_title}</td>
	<td>${job.min_salary}</td>
	<td>${job.max_salary}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>


<%--
<select name="job_id">
<c:foreach var="job" items="${j_datas}">
	<option value="${job.job_id}">${job.job_id}</option>
</c:foreach>
</select>

--%>