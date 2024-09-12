<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//JSP = 자바 + HTML(이쪽이 목적) <- 화면(View)을 만들 때 쓰임
//Servlet = 자바(이쪽이 목적) + HTML
//자바땅
String str = "JSP연습";



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=str %></h1>
</body>
</html>