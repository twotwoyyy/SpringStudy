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
</style>
</head>
<body>
	<div class="row">
		<h3>총 <span style="color:green; font-size: 40px">
			<fmt:formatNumber value="${count}" pattern="#,###,###,###"/>
		</span>개의 맛있는 레시피가 있습니다.</h3>
		<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../recipe/detail_before.do?no=${vo.no }"> 
					<img src="${vo.poster }" title="${vo.title }" style="width: 230px; height: 180px">
						<div class="caption a">
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
			<ul class="pagination">
				<c:if test="${startPage>1 }">
					<li><a href="../main/main.do?page=${startPage-1}">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li ${i==curpage?"class=active":"" }><a href="../main/main.do?page=${i }">${i }</a></li>
				</c:forEach>
				
				<c:if test="${endPage<totalpage }">
					<li><a href="../main/main.do?page=${endPage+1}">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<h3>방문한 레시피</h3>
	<a href="../recipe/cookie_all.do" class="btn btn-xs btn-primary">더보기</a>
	<hr>
	<div class="row">
		<c:if test="${size==0 }">
			<h3 class="text-center">방문한 레시피가 없습니다</h3>
		</c:if>
		<c:if test="${size>0 }">
			<c:forEach var="vo" items="${cList }" varStatus="s">
				<c:if test="${s.index<9 }">
					<a href="../recipe/detail.do?no=${vo.no }">
						<img src="${vo.poster }" style="width: 100px; height: 100px" title="${vo.title }"> 
					</a>
				</c:if>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>