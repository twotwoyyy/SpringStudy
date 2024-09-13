<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 280px;
}
.row {
	margin: 0px auto;
	width: 350px;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">Login</h3>
		<div class="row">
			<form method="post" action="../member/login_ok.do">
				<table class="table">
					<tr>
						<th width="30%" class="text-right">ID</th>
						<td width="70%">
							<input type="text" name="id" size="20" class="input-sm">
						</td>
					</tr>
					<tr>
						<th width="30%" class="text-right">비밀번호</th>
						<td width="70%">
							<input type="password" name="pwd" size="20" class="input-sm">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button class="btn-sm btn-primary">로그인</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>