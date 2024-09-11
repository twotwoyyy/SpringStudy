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
	<div class="row">
		<table class="table">
			<tr>
				<th class="text-center">사번</th>
				<th class="text-center">이름</th>
				<th class="text-center">직위</th>
				<th class="text-center">입사일</th>
				<th class="text-center">급여</th>
				<th class="text-center">부서명</th>
				<th class="text-center">근무지</th>
				<th class="text-center">호봉</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td class="text-center">${vo.empno }</td>
					<td class="text-center"><a href="../emp/detail.do?empno=${vo.empno }">${vo.ename }</a></td>
					<td class="text-center">${vo.job }</td>
					<td class="text-center">${vo.dbday }</td>
					<td class="text-center">${vo.sal }</td>
					<td class="text-center">${vo.dvo.dname }</td>
					<td class="text-center">${vo.dvo.loc }</td>
					<td class="text-center">${vo.svo.grade }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>