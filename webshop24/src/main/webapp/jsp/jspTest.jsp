<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error500.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP문법연습</h1>
<%!
int call(){
	System.out.print("JSP에서 자바코드가 가능하다.");
	return 100;
}
%>
<%
String subject = "자바";
out.write("<h1>out내장객체</h1>");
EmpDTO emp = (EmpDTO)session.getAttribute("loginEmp");
%>
<h1><%=subject %></h1>
<h1><%=call() %></h1>
<h1><%=request.getRequestURI() %></h1>
<h1><%=request.getContextPath() %></h1>
<%--<h1><%=emp.getFirst_name() %></h1> --%>
<h1>${loginEmp}</h1>



</body>
</html>