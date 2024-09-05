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
		<h2 class="text-center">상세 보기</h2>
		<table class="table">
			<tr>
				<td width="30%" class="text-center" rowspan="6"><img
					src="https://www.menupan.com/${vo.poster }" style="width: 100%"></td>
				<td colspan="2">
					<h3>${vo.name }&nbsp;<span style="color: orange">${vo.score }</span>
					</h3>
				</td>
			</tr>
			<tr>
				<td class="text-right" style="color: gray" width="5%">업종</td>
				<td width="65%">${vo.type }</td>
			</tr>
			<tr>
				<td class="text-right" style="color: gray" width="5%">전화</td>
				<td width="65%">${vo.phone }</td>
			</tr>
			<tr>
				<td class="text-right" style="color: gray" width="5%">주소</td>
				<td width="65%">${vo.address}</td>
			</tr>
			<tr>
				<td class="text-right" style="color: gray" width="5%">테마</td>
				<td width="65%">${vo.theme }</td>
			</tr>
			<tr>
				<td class="text-right" style="color: gray" width="5%">주차</td>
				<td width="65%">${vo.parking }</td>
			</tr>
		</table>
		<table class="table">
			<tr>
				<td>${vo.content }</td>
			</tr>
		</table>
			<table class="table">
			<tr>
				<td class="text-right">
					<input type="button" class="btn-sm btn-warning" value="좋아요">
					<input type="button" class="btn-sm btn-success" value="찜하기">
					<a href="../food/list.do" class="btn btn-sm btn-info">목록</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>