<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
// function f_insert(){
// 	href="empInsert.do";
// }
</script>
</head>
<body>
<%--include 지시자 : JSP를 합쳐서 컴파일한다. --%>
<%--include 액션태그 : 각각 컴파일해서 합친다. --%>
<h1>${loginEmp.first_name}님 환영합니다.</h1>
<a href="../auth/logout.do">로그아웃</a>
<%-- <jsp:include page="../common/loginheader.jsp"</jsp:include> --%>
<%--공통적인 페이지를 만들고 싶을 때(위의 2줄) --%>

<%@ include file="../common/loginheader.jsp" %>
<h2>현재 접속한 사용자는 ${loginUser.user_id}</h2>
<h2>현재 접속자 수 : ${total_user}</h2>
<h1>세션에서 읽기 : ${memberId}</h1>
<h1>세션에서 읽기 : ${memberPass}</h1>
<p>다음은 주소창에 주소를 바꾸는 방법</p>
<a href="empInsert.do">신규직원등록</a>
<a href="javascript:location.href='empInsert.do'">신규직원등록</a>
<button onclick="location.href='empInsert.do'">신규직원등록</button>
<button onclick="f_insert()">신규직원등록</button>
<form action="empInsert.do">
	
</form>
<%--ㄴ주소창의 주소가 바뀐다. --%>
<h1>myInfo(다른 서블릿의 request 접근 불가):${myinfo}</h1>
<h1>myInfo2(같은 브라우저로 접근하면 session접근 가능):${myinfo2}</h1>
<h1>myInfo3(모든 서블릿에서 접근 가능, 모든 사용자가 공유)):${myinfo3}</h1>
<h1>직원목록</h1>
<table border="1px solid black">
	<thead>
	<tr>
	<th>직원번호</th>
	<th>이름</th>
	<th>성</th>
	<th>이메일</th>
	<th>전화번호</th>
	<th>직책</th>
	<th>급여</th>
	<th>커미션</th>
	<th>매니저</th>
	<th>부서</th>
	<th>입사일</th>
	<th>수정</th>
	<th>삭제</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${emplist}" var="emp">
	<tr>
	<td><a href="/webshop24/emp/empDetail?empid=${emp.employee_id}">${emp.employee_id}</a></td>
	<td>${emp.first_name}--(${fn:length(emp.first_name) })</td>
	<td>${emp.last_name}</td>
	<td>${emp.email}</td>
	<td>${emp.phone_number}</td>
	<td>${emp.job_id}</td>
	<td>
	<fmt:formatNumber value="${ emp.salary}" groupingUsed="true" type="currency" currencySymbol="\\"></fmt:formatNumber>
	</td>
	<td>${emp.commission_pct}</td>
	<td>${emp.manager_id}</td>
	<td>${emp.department_id}</td>
	<td>
	<fmt:formatDate value="${emp.hire_date}" pattern="YYYY/MM/dd hh:mm:ss"/>
	</td>
	<td><button onclick="location.href='empUpdate.do?empid=${emp.employee_id}'">수정</button></td>
	<td><button onclick="location.href='empDelete.do?empid=${emp.employee_id}'">삭제</button></td>
	</tr>
	</c:forEach>
	</tbody>

</table>
</body>
</html>