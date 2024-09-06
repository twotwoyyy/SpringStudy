<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.a {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="row">
		<form method="post" action="../recipe/find.do">
			<input type=text name=fd size=20 class="input-sm" value="${fd}">
			<button class="btn-sm btn-primary">검색</button>
		</form>
	</div>
	<div class="row">
		<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../recipe/detail_before.do?no=${vo.no }"> <img
						src="${vo.poster }" title="${vo.title}"
						style="width: 230px; height: 150px">
						<div class="caption">
							<p>${vo.chef }</p>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div style="height: 10px"></div>
	<div class="row">
		<div class="text-center">
			<a
				href="../recipe/find.do?fd=${fd }&page=${curpage>1?curpage-1:curpage}"
				class="btn btn-sm btn-warning">이전</a> ${curpage } page / ${totalpage }
			pages <a
				href="../recipe/find.do?fd=${fd }&page=${curpage<totalpage?curpage+1:curpage}"
				class="btn btn-sm btn-warning">다음</a>
		</div>
	</div>
</body>
</html>