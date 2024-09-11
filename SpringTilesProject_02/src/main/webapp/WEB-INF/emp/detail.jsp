<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row" style="width:350px">
		<table class="table">
			<caption>사원 상세보기</caption>
			<tr>
				<th width="30%" class="text-center">사번</th>
				<td width="70%" class="text-center">${vo.empno }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">이름</th>
				<td width="70%" class="text-center">${vo.ename }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">직위</th>
				<td width="70%" class="text-center">${vo.job }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">입사일</th>
				<td width="70%" class="text-center">${vo.dbday }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">부서명</th>
				<td width="70%" class="text-center">${vo.dvo.dname }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">근무지</th>
				<td width="70%" class="text-center">${vo.dvo.loc }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">급여등급</th>
				<td width="70%" class="text-center">${vo.svo.grade }</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<a href="javascript:history.back()" class="btn btn-sm btn-danger">목록</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>