<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
request.setAttribute("score", 100);
DeptService service = new DeptService();
List<DeptDTO> deptlist = service.selectAll();
request.setAttribute("deptlist", deptlist);
//이 모든건 서블릿에서 수행해야 한다.
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>

1. 값을 저장하기 : 
<c:set var="score2" value="200" scope="request" />
<c:set var="cpath"
			value="${pageContext.request.servletContext.contextPath}" />
<%-- <c:set var="dlist" value="<%=deptlist %>"/> --%>

2. 값을 읽기 : ${score}.....${score2}
</pre>
	<img src="${cpath}/static/images/cup-1.png" width="100" height="100">
	<img
		src="${pageContext.request.servletContext.contextPath}/static/images/cup-2.png"
		width="100" height="100">
	<a href="${cpath}/auth/login.do">로그인하기</a>
	<ul>
		<c:forEach items="${deptlist}" var="dept" varStatus="deptStatus">
			<li>${deptStatus.index},${deptStatus.count},${deptStatus.first},${deptStatus.last},${dept.department_name}</li>
		</c:forEach>
	</ul>

	<c:forEach begin="1" end="5" step="1" var="su" varStatus="status">
		<p>
			현재값 : ${su}.....${status.index}....${status.count}
			<c:if test="${su % 2 == 0}">
				<span>짝수</span>
			</c:if>
			<c:if test="${su % 2 != 0}">
				<span>홀수</span>
			</c:if>
			<span>${su%2 == 0?"even":"odd"}</span>

			<c:choose>
				<c:when test="${su%2==0}">
					<span>짝!!</span>
				</c:when>
				<c:otherwise>
					<span>홀!!!</span>
				</c:otherwise>
			</c:choose>
		</p>
	</c:forEach>

</body>
</html>