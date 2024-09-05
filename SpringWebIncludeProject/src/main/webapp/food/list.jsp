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
		<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../food/detail_before.do?fno=${vo.fno }"> 
					<img src="https://www.menupan.com/${vo.poster }" title="${vo.name }" style="width: 230px; height: 180px">
						<div class="caption a">
							<p>${vo.name }</p>
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
					<li><a href="../food/list.do?page=${startPage-1}">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li ${i==curpage?"class=active":"" }><a href="../food/list.do?page=${i }">${i }</a></li>
				</c:forEach>
				
				<c:if test="${endPage<totalpage }">
					<li><a href="../food/food.do?page=${endPage+1}">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<h3>방문한 맛집</h3>
	<a href="../food/cookie_all.do" class="btn btn-xs btn-primary">더보기</a>
	<hr>
	<div class="row">
		<c:if test="${size==0 }">
			<h3 class="text-center">방문한 레시피가 없습니다</h3>
		</c:if>
		<c:if test="${size>0 }">
			<c:forEach var="vo" items="${cList }" varStatus="s">
				<c:if test="${s.index<9 }">
					<a href="../food/detail.do?fno=${vo.fno }">
						<img src="https://www.menupan.com/${vo.poster }" style="width: 100px; height: 100px" title="${vo.name }"> 
					</a>
				</c:if>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>