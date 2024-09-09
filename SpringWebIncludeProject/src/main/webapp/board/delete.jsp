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
   width: 300px;
}
</style>
<!-- 
	DI / AOP / MVC / ORM 
	                 = Transaction
	Tiles / Validation
 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#delBtn').click(function(){
		let no=$('#no').val()
		let pwd=$('#pwd').val()
		$.ajax({
			type:'post',
			url:'../board/delete_ok.do',
			data:{"no":no,"pwd":pwd},
			success:function(result){
				if(result==='yes'){
					alert("삭제되었습니다")
					location.href="../board/list.do"
				}else{
					alert("비밀번호가 틀립니다")
					$('#pwd').val("")
					$('#pwd').focus()
				}
			},
			error:function(request,status,error){
				console.log(error)
			}
		})
	})
})
</script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">삭제하기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center">
						비밀번호 : <input type="password" id="pwd" size="15" class="input-sm" required>
						<input type="hidden" id="no" value="${no }">
					</td>
				</tr>
				<tr>
					<td class="text-center">
						<input type="button" class="btn-sm btn-danger" value="삭제" id="delBtn">
						 <input type=button class="btn-sm btn-warning"
          					value="취소" onclick="javascript:history.go(-1)">
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>