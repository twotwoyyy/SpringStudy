<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.a{
   white-space: nowrap;
   overflow:hidden;
   text-overflow: ellipsis;
}

</style>
</head>
<body>
	<div class="row">
		<h3 class="text-center">내용 보기</h3>
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
			<tr>
				<td colspan="4" class="text-left" valign="top" height="200">
					<pre style="white-space: pre-wrap; border:none; background-color:white">${vo.content }</pre>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="text-right">
					<a href="../board/reply.do?no=${vo.no }" class="btn btn-xs btn-danger">답변</a>
					<a href="../board/update.do?no=${vo.no }" class="btn btn-xs btn-info">수정</a>
					<a href="../board/delete.do?no=${vo.no }" class="btn btn-xs btn-success">삭제</a>
					<a href="../board/list.do" class="btn btn-xs btn-primary">목록</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>