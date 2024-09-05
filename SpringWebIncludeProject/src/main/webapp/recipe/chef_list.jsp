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
				<td>
					<c:forEach var="vo" items="${list }">
						<table class="table">
							<tr>
								<td width="30%" class="text-center" rowspan="2">
									<a href="../recipe/chef_detail.do?chef=${vo.chef }">
										<img src="${vo.poster }" style="width: 100px; height: 100px" class="img-circle">
									</a>
								</td>
								<td colspan="4">
								<h3 style="color: orange"><a href="../recipe/chef_detail.do?chef=${vo.chef }">${vo.chef }</a></h3>
								</td>
							</tr>
							<tr>
								<td class="text-center"><img src="../recipe/images/m1.png">&nbsp;${vo.mem_cont1 }</td>
								<td class="text-center"><img src="../recipe/images/m2.png">&nbsp;${vo.mem_cont3 }</td>
								<td class="text-center"><img src="../recipe/images/m3.png">&nbsp;${vo.mem_cont7 }</td>
								<td class="text-center"><img src="../recipe/images/m4.png">&nbsp;${vo.mem_cont2 }</td>
							</tr>
						</table>
					</c:forEach>
				</td>
			</tr>
		</table>
		<table class="table">
			<tr>
				<td class="text-center">
					<a href="../recipe/chef_list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-info">이전</a>
						${curpage } page / ${totalpage } pages
					<a href="../recipe/chef_list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-info">다음</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>