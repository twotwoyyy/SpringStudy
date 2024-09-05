<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.a{
   white-space: nowrap;
   overflow:hidden;
   text-overflow: ellipsis;
}
.row{
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="row">
		<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../recipe/detail.do?no=${vo.no }"> 
					<img src="${vo.poster }" title="${vo.title }" style="width: 230px; height: 180px">
						<div class="caption a">
							<p>${vo.title }</p>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div style="height: 10px"></div>
	<div style="row">
		<div class="text-center">
			<a href="../recipe/chef_detail.do?chef=${chef }&page=${curpage>1?curpage-1:curpage}" class="btn btn-sm btn-warning">이전</a>
				${curpage } page / ${totalpage } pages
			<a href="../recipe/chef_detail.do?chef=${chef }&page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-sm btn-warning">다음</a>
		</div>
	</div>
</body>
</html>