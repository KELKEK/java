<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        


<table>
<thead>
	<table border="1px solid black" id="tb2">
	<thead>
	<tr>
	<th>직원번호</th>
	<th>이름</th>
	<th>성</th>
	<th>이메일</th>
	<th>급여</th>
	<th>입사일</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="emp" items="${emplist}">
		<tr>
			<td>${emp.employee_id}</td>
			<td>${emp.first_name}</td>
			<td>${emp.last_name}</td>
			<td>${emp.email}</td>
			<td>${emp.salary}</td>
			<td>${emp.hire_date}</td>
	</c:forEach>
	</tbody>

</table>
</thead>
</table>