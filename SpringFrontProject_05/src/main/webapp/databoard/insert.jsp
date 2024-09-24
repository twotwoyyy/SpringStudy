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
<%-- <%= application.getRealPath("/") %> --%>		
		<div class="row">
			<%-- 함수 처리하기 전까지 보내지 못하도록 지연 prevent --%>
			<%-- 기능 수행(이벤트 방지) defaultPrevent()
				 formData
			--%>
			<form @submit.prevent="submitForm()">
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
						<th width="20%" class="text-right">첨부파일</th>
						<td width="80%">
							<input type="file" ref="upfiles" class="input-sm"
							 v-model="upfiles"
							 multiple="multiple"
							 accept="upload/*"/>
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
							<input type="submit" class="btn btn-sm btn-primary" value="글쓰기">
							<!-- 업로드가 있을 경우 submit으로 처리 --> 
							<input type="button" class="btn btn-sm btn-danger" value="취소" onclick="javascript:history.back()"> 
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script>
		let inertApp=Vue.createApp({
			// Model => 데이터 관리 => 변수 설정 
			data(){
				return {
					name:'',
					subject:'',
					content:'',
					pwd:'',
					upfiles:''
				}
			},
			// VM => Model(data)를 변경해서 View(HTML)로 전송 
			// CallBack => 자동 호출 => 생명주기 함수 
			// 시작과 동시에 호출 (init(변수의 초기화 담당))
			mounted(){
				
			},
			// 데이터값이 변경되면 자동 호출
			updated(){
				
			},
			// 사용자정의 함수 : 멤버 함수
			methods:{
				submitForm(){
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
					
					let formData=new FormData()
					formData.append("name",this.name)
					formData.append("subject",this.subject)
					formData.append("content",this.content)
					formData.append("pwd",this.pwd)
					
					let len=this.$refs.upfiles.files.length
					//alert("파일 개수:"+len)
					if(len>0){ // 업로드 파일이 있는 경우
						for(let i=0;i<len;i++){
							formData.append("files["+i+"]",this.$refs.upfiles.files[i]) // 리스트로 값을 받을 때 
						}
					}
					axios.post('insert_vue.do',formData,{
						headers:{
							'Content-Type':'multipart/form-data'
						}
					}).then(response=>{
						if(response.data==='yes'){
							alert("게시글이 등록되었습니다")
							location.href='list.do'
						}else{
							alert(response.data)
						}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
			// components: computed: filter: watch: 
		}).mount('.container')
	</script>
</body>
</html>