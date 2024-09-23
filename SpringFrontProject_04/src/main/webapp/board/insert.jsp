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
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 600px;
}

</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
</head>
<body>
	<div class="container">
		<h3 class="text-center">글쓰기</h3>
		<div class="row">
			<table class="table">
				<tr>	
					<th width="20%" class="text-right">이름</th>
					<td width="80%">
						<input type="text" size="15" v-model="name" ref="name" class="input-sm">
					</td>
				</tr>
				<tr>	
					<th width="20%" class="text-right">제목</th>
					<td width="80%">
						<input type="text" size="50" v-model="subject" ref="subject" class="input-sm">
					</td>
				</tr>
				<tr>	
					<th width="20%" class="text-right">내용</th>
					<td width="80%">
						<textarea rows="10" cols="52" v-model="content" ref="content" class="input-sm"></textarea>
					</td>
				</tr>
				<tr>	
					<th width="20%" class="text-right">비밀번호</th>
					<td width="80%">
						<input type="password" size=10 v-model="pwd" ref="pwd">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="button" class="btn btn-sm btn-primary" value="글쓰기" @click="boardInsert()"> 
						<input type="button" class="btn btn-sm btn-danger" value="취소" onclick="javascript:history.back()"> 
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let insertApp=Vue.createApp({
			data(){
				return {
					name:'',
					subject:'',
					content:'',
					pwd:''
				}
			},
			methods:{
				boardInsert(){
					if(this.name===""){
						this.$refs.name.focus()
						return
					}
					if(this.subject===""){
						this.$refs.subject.focus()
						return
					}
					if(this.content===""){
						this.$refs.content.focus()
						return
					}
					if(this.pwd===""){
						this.$refs.pwd.focus()
						return
					}
					// 두 번째 인자에 null을 넣어야 한다 (헤더 부분), 실제 데이터는 두 번째, 
					axios.post('http://localhost:8080/web/board/insert_vue.do',null,{
						params:{
							name:this.name,
							subject:this.subject,
							content:this.content,
							pwd:this.pwd
						}
					}).then(response=>{
						if(response.data==="yes"){
							alert("게시글이 등록되었습니다")
							location.href="list.do"
						}else{
							alert("에러 발생")
						}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>