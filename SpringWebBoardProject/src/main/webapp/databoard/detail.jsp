<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   marin-top:50px;
}
.row{
   margin: 0px auto;
   width: 800px;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">내용 보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width="20%" class="text-center">번호</th>
					<td width="30%" class="text-center">${vo.no }</td>
					<th width="20%" class="text-center">작성일</th>
					<td width="30%" class="text-center">${vo.dbday }</td>
				</tr>
				<tr>
					<th width="20%" class="text-center">이름</th>
					<td width="30%" class="text-center">${vo.name }</td>
					<th width="20%" class="text-center">조회수</th>
					<td width="30%" class="text-center">${vo.hit }</td>
				</tr>
				<tr>
					<th width="20%" class="text-center">제목</th>
					<td colspan="3">${vo.subject }</td>
				</tr>
				<c:if test="${vo.filecount!=0 }">
					<tr>
						<th width="20%" class="text-center">첨부파일</th>
						<td colspan="3">
							<ul>
								<c:forEach var="fname" items="${nList }" varStatus="s">
									<li><a href="download.do?fn=${fname }">${fname }</a>(${cList[s.index]}Bytes)</li>
								</c:forEach>
							</ul>
						</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="4" class="text-left" valign="top" height="200">
						<pre style="white-space: pre-wrap; background-color: white; border: none">${vo.content }</pre>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
						<a href="delete.do?no=${vo.no }" class="btn btn-xs btn-success">삭제</a>
						<a href="list.do" class="btn btn-xs btn-primary">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>