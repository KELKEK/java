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
<h1>binding연습1</h1>
<p>1. ServletContext:${applicationScope.appData}</p>
<p>2. HttpSession:${sessionScope.sessionData}</p>
<p>3. HttpServletRequest:${requsetScope.requestData}</p>

<ul>
  <c:forTokens var="member" items="${initParam['menu_member']}" delims=" ">
    <li>${member}</li>
  </c:forTokens>
  </ul>
  <ul>
  <c:forTokens var="member" items="${initParam['menu_order']}" delims=" ">
    <li>${member}</li>
  </c:forTokens>
  </ul>
</body>
</html>