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
		<c:if test="${size==0 }">
			<h3 class="text-center">방문한 레시피가 없습니다</h3>
		</c:if>
		<c:if test="${size>0 }">
			<c:forEach var="vo" items="${cList }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="../recipe/detail.do?no=${vo.no }"> 
						<img src="${vo.poster }" title="${vo.title }" style="width: 230px; height: 180px">
							<div class="caption a">
								<p>${vo.chef }</p>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
	<div style="height: 10px"></div>
	<div class="row">
		<div class="text-right">
			<a href="../recipe/cookie_delete.do" class="btn btn-sm btn-danger">전체 삭제</a>
			<a href="../main/main.do" class="btn btn-sm btn-primary">이전 목록</a>			
		</div>
	</div>
</body>
</html>