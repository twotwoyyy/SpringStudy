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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

</head>
<body>
	<div class="container">
		<h3 class="text-center">내용 보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width="20%" class="text-center success">번호</th>
					<td width="30%" class="text-center">{{no}}</td>
					<th width="20%" class="text-center success">작성일</th>
					<td width="30%" class="text-center">{{vo.dbday}}</td>
				</tr>
				<tr>
					<th width="20%" class="text-center success">이름</th>
					<td width="30%" class="text-center">{{vo.name}}</td>
					<th width="20%" class="text-center success">조회수</th>
					<td width="30%" class="text-center">{{vo.hit}}</td>
				</tr>
				<tr>
					<th width="20%" class="text-center success">제목</th>
					<td colspan="3">{{vo.subject}}</td>
				</tr>
				<tr>
					<td colspan="4" class="text-left" valign="top" height="200">
						<pre style="white-space: pre-wrap; background-color: white; border: none">{{vo.content}}</pre>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a :href="'update.do?no='+vo.no" class="btn btn-xs btn-warning">수정</a>
						<!--   <span class="btn btn-xs btn-info" id="delBtn">삭제</span> -->
						<input type="button" ref="delBtn" class="btn btn-xs btn-info" value="삭제" @click="del()">
						<a href="list.do" class="btn btn-xs btn-success">목록</a>
					</td>
				</tr>
				<!-- <tr id="delTr" style="display: none"> -->
					<tr v-show="isShow">
					<td colspan="4" class="text-right">
						비밀번호: <input type="password" v-model="pwd" ref="pwd" class="input-sm" size="15">
						<input type="button" value="삭제" class="btn-sm btn-danger" ref="deleteBtn" v-on:click="boardDelete()">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let detailApp=Vue.createApp({
			data(){
				return {
					vo:{},
					no:${no}, // 컨트롤러에서 넘긴 값 => EL 사용 
					pwd:'',
					isShow:false
					//index:0
				}
			},
			// detail_vue.do?no=(this.no)
			mounted(){
				// jquery 연동 => $(function(){})
				/*$('#delBtn').click(function(){ // 제이쿼리 연동 시에는 mounted 사용 
					if(this.index===0){
						this.index=1
						$('#delBtn').text("취소")
						$('#delTr').show()
					}else{
						this.index=0
						$('#delBtn').text("삭제")
						$('#delTr').hide()
					}
				})*/
				axios.get('http://localhost:8080/web/board/detail_vue.do',{
					params:{
						no:this.no
						
					}
				}).then(response=>{
					console.log(response.data)
					this.vo=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			methods:{
				del(){
					if(this.isShow===false){
						this.isShow=true
						this.$refs.delBtn.value="취소"
					}else{
						this.isShow=false
						this.$refs.delBtn.value="삭제"
						
					}
				},
				boardDelete(){
					if(this.pwd===""){
						this.$refs.pwd.focus()
						return
					}
					// 입력이 된 경우
					axios.get('http://localhost:8080/web/board/delete_vue.do',{
						params:{
							no:this.no,
							pwd:this.pwd
						}
					}).then(response=>{
						if(response.data==='yes'){
							alert("게시글이 삭제되었습니다")
							location.href="list.do"
						}else{
							alert("비밀번호가 틀렸습니다")
							this.$refs.pwd.value=""
							this.$refs.pwd.focus()
						}
					}).catch(error=>{
						console.log(error.response) // 에러에 대한 메시지 출력
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>