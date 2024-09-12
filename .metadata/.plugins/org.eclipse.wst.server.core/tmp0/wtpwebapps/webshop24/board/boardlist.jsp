<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"
		value="${pageContext.request.servletContext.contextPath}/board" />
	<c:set var="cpath"
		value="${pageContext.request.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cpath}/static/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$("#btnJSON").on("click", f_jsonCall);
	$("#btnJSON2").on("click", f_jsonCall2);
	
});
function f_jsonCall2(){
	var output= "<ul>";
	$.ajax({
		url:"${cpath}/json2",
		type:"get",

		success:function(responseData){
			console.log(responseData);
			var Obj = JSON.parse(responseData);
			var boardlist = Obj["boardlist"];
			$.each(boardlist, function(index, item){
				output += "<li>" + item.title + "</li>"
			});
			output += "</ul>";
			$("#here").html(output);
		},
		error:function(err){
			alert(err);
		}
	});
}


function f_jsonCall(){
	var boardObj = {bno:100, title:"커피", content:"제일 맛있는집", writer:"익명"};
	//여기까진 자바스크립트 오브젝트임
	
	var boardStr = JSON.stringify(boardObj);
	console.log(boardObj);
	console.log(boardObj.title);
	console.log(boardStr);
	
	$.ajax({
		url:"${cpath}/json",
		type:"get",
		data:{"jsonInfo": boardStr},
		success:function(responseData){
			console.log(responseData)
		},
		error:function(errorInfo){
			alert(errorInfo)
		}
	});
}
</script>
</head>
<body>
	
		
	<button id="btnJSON">JSON보내기(list->)</button>
	<button id="btnJSON2">JSON받기(list<-)</button>
	<div id="here">여기</div>
	<a href="boardInsert.do">게시판등록</a>
	<h1>Board목록</h1>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>pic</th>
			<th>작성일</th>
			<th></th>
		</tr>
		<c:forEach var="board" items="${blist}">
			<tr>
				<td><a href="${path}/boardDetail.do?bno=${board.bno}">${board.bno }</a></td>
				<td>${board.title }</td>
				<td>${board.content }</td>
				<td>${board.writer }</td>
				<td><img alt="${board.title}" width="50" height="50"
					src="${cpath }/upload/${board.pic}"</td>

				<a href="${cpath }/download.do?filename=${board.pic}">${board.pic }내려받기</a>
				<td>${board.create_date}</td>
				<td><button
						onclick="location.href='${path}/boardDelete.do?bno=${board.bno}'">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>