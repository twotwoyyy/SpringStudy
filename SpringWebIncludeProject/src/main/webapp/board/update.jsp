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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#updateBtn').on('click',function(){
		let name=$('#name').val()
		let subject=$('#subject').val()
		let content=$('#content').val()
		let pwd=$('#pwd').val()
		let no=$('#no').val()
		let formData={"no":no,"name":name,"subject":subject,"content":content,"pwd":pwd}
		$.ajax({
			type:'post',
			url:'../board/update_ok.do',
			data:formData,
			success:function(result){
				alert(result)
				// 정상 수행시
				if(result==='yes'){
					location.href="../board/detail.do?no="+no;
				}else{
					alert("비밀번호가 틀립니다!!")
					$('#pwd').val("")
					$('#pwd').focus()
				}
			},
			error:function(request,status,error){
				alert(error)
			}
		})
	})
})
</script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">수정하기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center" width=20%>이름</th>
					<td width=80%><input type=text id=name size=20
						class="input-sm" value="${vo.name }" required> <input
						type="hidden" id=no value="${vo.no }"></td>
				</tr>
				<tr>
					<th class="text-center" width=20%>제목</th>
					<td width=80%><input type=text id=subject size=50
						class="input-sm" value="${vo.subject }" required></td>
				</tr>
				<tr>
					<th class="text-center" width=20%>내용</th>
					<td width=80%><textarea rows="10" cols="50" id="content"
							required>${vo.content }</textarea></td>
				</tr>
				<tr>
					<th class="text-center" width=20%>비밀번호</th>
					<td width=80%><input type=password id="pwd" size=10
						class="input-sm" required></td>
				</tr>
				<tr>
					<td colspan="2" class="text-center"><input type="button"
						class="btn-sm btn-info" id="updateBtn" value="수정"> <input
						type=button class="btn-sm btn-warning" value="취소"
						onclick="javascript:history.go(-1)"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>