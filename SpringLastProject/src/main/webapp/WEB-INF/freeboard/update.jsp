<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
				
					<div class="bradcumb-title text-center">
						<h2>수정하기</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="breadcumb-nav">
		<div class="container">
			<div class="row">
				<div class="col-12"></div>
			</div>
		</div>
	</div>
	<section class="single_blog_area section_padding_80" id="updateApp">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-lg-8">
					<div class="row no-gutters">
						<table class="table">
							<tr>
								<th class="text-center" width="15%">제목</th>
								<td width="85%">
									<input type="text" size="45" class="input-sm" ref="subject" v-model="subject">
								</td>
							</tr>
							<tr>
								<td class="text-center" width="15%">내용</td>
								<td width="85%">
									<textarea rows="10" cols="48" ref="content" v-model="content"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">
									<button class="btn-sm btn-success" @click="boardUpdate()">수정하기</button>
									<button class="btn-sm btn-danger" onclick="location.href='../freeboard/list.do'">취소</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		let updateApp=Vue.createApp({
			data(){
				return {
					no:${no},
					subject:'',
					content:''
				}
			},
			mounted(){
				axios.get('../freeboard/update_vue.do',{
					params:{
						no:this.no
					}
				}).then(res=>{
					console.log(res.data)
					this.subject=res.data.subject
					this.content=res.data.content
					// 변수 값이 갱신 => v-model로 값을 전송 => HTML값을 변경해서 출력 
					/*
						res=>{
							config:{}, => res.config
							data:{subject:'',content:''}, => res.data (실제 서버에서 전송한 값)
							header:{} => res.header
						}
						
						res.data={subject:'',content:''} => 객체
						data.subject => 로 가져올 수 있다 (멤버 변수이기에)
					*/
				}).catch(error=>{
					console.log(error.response)
				})
			},
			methods:{
				// 버튼 => 사용자 요청 처리 
				boardUpdate(){
					if(this.subject===""){
						this.$refs.subject.focus()
						return
					}
					if(this.content===""){
						this.$refs.content.focus()
						return
					}
					/*
						$.ajax({
							type:'post',
							url:'',
							data:{},
							success:function(response){
								
							}
						})
						// Rest => GET(SELECT)/POST(INSERT)/PUT(UPDATE)/DELETE(DELETE)
						           
						// RestFul
						axios({
							type:
							url:
						})
					*/
					// 서버로 전송
					axios.post('../freeboard/update_ok_vue.do',null,{
						params:{
							no:this.no,
							subject:this.subject,
							content:this.content
						}
					}).then(res=>{
						// then((res)=>{}) 대신 화살표 함수
						console.log(res.data)
						if(res.data==="yes"){
							alert("글이 수정되었습니다.")
							location.href="../freeboard/detail.do?no="+this.no
						}else{
							alert(res.data)
						}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#updateApp')
	</script>
</body>
</html>