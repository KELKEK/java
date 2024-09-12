<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ pageContext.request.servletContext.contextPath}/board/boardInsert.do" method="post"
	enctype="multipart/form-data">	

	title : <input type="text" name="title" value="${board.title }"><br>
	content : <input type="text" name="content" value="${board.content }"><br>
	pic : <input type="file" name="pic" value="${board.pic }">
	<br>
	<input type="submit" value="입력">
	</form>
</body>
</body>
</html>