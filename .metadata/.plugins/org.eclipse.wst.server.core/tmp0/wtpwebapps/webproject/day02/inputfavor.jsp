<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>기입이 완료되었습니다!</h1>
<p>ID : <%=request.getParameter("customer_id")%></p>
<p>1.가격 : <%=request.getParameter("price") %></p>
<p>2.카페인양 : <%=request.getParameter("caffeine") %></p>
<p>3.당분 : <%=request.getParameter("sugar") %></p>
<p>3.원두품질 : <%=request.getParameter("quality") %></p>
<p>3.당분 : <%=request.getParameter("caffeine") %></p>

<%
int price = Integer.parseInt(request.getParameter("price"));
int caffeine = Integer.parseInt(request.getParameter("caffeine"));
out.print("선호도 총합(임시로 지정) : ");
out.print(price+caffeine);
%>
</body>
</html>