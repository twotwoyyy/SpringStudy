<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="bradcumb-title text-center">
						<h2>회원가입</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<section class="single_blog_area section_padding_80" id="joinApp">
		<div class="container">
			<div class="row justify-content-center">
				<form method="post" action="../member/join_ok.do" @submit="submitForm()">
					<table class="table">
						<tr>
							<th class="text-right" width="15%">ID</th>
							<td width="85%" class="inline"> &nbsp;
								<input type="text" size=20 class="input-sm" 
								v-bind:readonly="isReadOnly" name="userId" ref="userId" v-model="userId"> 
								<input type="button" value="중복체크" class="btn-sm btn-danger" @click="idCheck()">
								<p>{{idOk}}</p>
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">비밀번호</th>
							<td width="85%" class="inline">
								<input type="password" size=20 class="input-sm" name="userPwd" ref="userPwd" v-model="userPwd"
								@keyup="pwdValidate()">
								 &nbsp;재입력:<input type="password" size=20 class="input-sm" name="userPwd2" ref="userPwd2" v-model="userPwd2"
								@keyup="pwdValidate2()">
								<p>{{pwdOk}}</p>
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">이름</th>
							<td width="85%">
								<input type="text" size=20 class="input-sm" name="userName" ref="userName" v-model="userName">
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">성별</th>
							<td width="85%" class="inline">
								<input type="radio" name="sex" value="남자" checked v-model="sex">남자 
								<input type="radio" name="sex" value="여자" v-model="sex">여자
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">생년월일</th>
							<td width="85%">
								<input type="date" size=30 class="input-sm" name="birthday" v-model="birthday" ref="birthday">
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">이메일</th>
							<td width="85%">
								<input type="text" size=70 class="input-sm" name="email" v-model="email" ref="email">
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">우편번호</th>
							<td width="85%" class="inline">
								<input type="text" size=15 class="input-sm" name="post" readonly ref="post" v-model="post"> 
								<input type=button value="우편번호검색" class="btn btn-sm btn-primary" @click="postFind()">
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">주소</th>
							<td width="85%">
								<input type="text" size=70 class="input-sm" name="addr1" readonly ref="addr1" v-model="addr1">
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">상세주소</th>
							<td width="85%">
								<input type="text" size=70 class="input-sm" name="addr2" ref="addr2" v-model="addr2">
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">전화번호</th>
							<td width="85%" class="inline">
								<select class="input-sm" name="phone1" v-model="phone1">
										<option>010</option>
								</select> 
								<input type="text" size=20 class="input-sm" name="phone2" ref="phone2" v-model="phone2">
							</td>
						</tr>
						<tr>
							<th class="text-right" width="15%">소개</th>
							<td width="85%">
								<textarea rows="5" cols="70" name="content" ref="content" v-model="content"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="text-center inline">
								<input type="submit" value="회원가입" class="btn-sm btn-info">
								<input type=button value="취소" class="btn-sm btn-warning" onclick="javascript:history.back()">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</section>
	<script>
		let joinApp=Vue.createApp({
			data(){
				return {
					userId:'',
					idOk:'',
					isReadOnly:false,
					post:'',
					addr1:'',
					addr2:'',
					userName:'',
					phone1:'',
					phone2:'',
					birthday:'',
					userPwd:'',
					userPwd2:'',
					content:'',
					email:'',
					sex:'',
					pwdOk:''
				}
			},
			methods:{
				pwdValidate(){
					let pwd=String(this.userPwd)
					let num=pwd.search(/[0-9]/g) // 숫자 
					let eng=pwd.search(/[a-z]/g) // 영문 포함되었는지
					if(pwd===''){
						this.pwdOk=''
						return
					}
					if(pwd.length<8 || pwd.length>20){ // 8~20글자의 비번 제한
						this.pwdOk='비밀번호를 8~20자리 이내로 입력하세요'
						return
					}else if(pwd.search(/\s/)!=-1){ // \s 는 공백, 공백이 있다면
						this.pwdOk='비밀번호는 공백없이 입력해야합니다'
						return
					}else if(num<0 || eng<0){
						this.pwdOk='비밀번호는 영문,숫자를 혼합해서 입력해야합니다'
						return
					}else{
						this.pwdOk=''
						return
					}
				},
				pwdValidate2(){
					if(this.userPwd!=this.userPwd2){
						this.pwdOk="비밀번호가 일치하지 않습니다"
						return
					}else{
						this.pwdOk=''
						return
					}
				},
				submitForm(e){
					if(this.userId && this.userName && this.userPwd && this.sex && this.userPwd2 && this.birthday && this.post
							&& this.addr1 && this.addr2 && this.content && this.email && this.idOk!='' && this.pwdOk!=''){
						alert("정상 수행")
						return true
					}
					if(this.userId===''||this.idOk!=''){
						this.$refs.userId.focus()
					}else if(this.userName===''){
						this.$refs.userName.focus()
					}else if(this.userPwd===''){
						this.$refs.userPwd.focus()
					}else if(this.userPwd2==''){
						this.$refs.serPwd2.focus()
					}else if(this.userPwd!==this.userpwd2){
						this.userPwd=''
						this.userPwd2=''
					}else if(this.phone2===''){
						this.$refs.phone2.focus()
					}else if(this.email===''){
						this.$refs.email.focus()
					}
					e.preventDefault()
				},
				postFind(){
					let _this=this // Vue의 this를 받아오는 방법
					new daum.Postcode({
						oncomplete:function(data){
							_this.post=data.zonecode
							_this.addr1=data.address
						}
					}).open()
				},
				idCheck(){
					if(this.userId===''){
						this.$refs.userId.focus()
						return
					}
					axios.get('../member/idcheck_vue.do',{
						params:{
							userId:this.userId
						}
					}).then(res=>{
						console.log(res.data)
						if(res.data===0){ 
							this.idOk=''
							this.isReadOnly=true
						}else{
							this.idOk='이미 사용 중인 아이디입니다'
							this.userId=''
							this.$refs.userId.focus()
						}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#joinApp')
	</script>
</body>
</html>