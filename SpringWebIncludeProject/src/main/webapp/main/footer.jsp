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
	<%--AOP를 이용한 공통 기능 처리 --%>
	<div class="col-sm-4">
		<h3>인기 레시피 Top5</h3>
		<ul style="list-style-type: none">
			<c:forEach var="vo" items="${recipeList }" varStatus="s">
				<li>${s.index+1 }.${vo.title }</li>
			</c:forEach>
		</ul>
	</div>
	<div class="col-sm-4">
		<h3>인기 맛집 Top5</h3>
		<ul style="list-style-type: none">
			<c:forEach var="vo" items="${foodList }" varStatus="s">
				<li>${s.index+1 }.${vo.name }</li>
			</c:forEach>
		</ul>
	</div>
	<div class="col-sm-4">
		<h3>인기 게시물 Top5</h3>
	</div>
</body>
</html>