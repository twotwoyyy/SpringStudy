<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 350px;
}
</style>
</head>
<body>
<div class="container">
    <h1 class="text-center">로그인</h1>
    <div class="row">
      <table class="table">
        <tr>
          <th width=30%>ID</th>
          <td width=70%>
            <input type=text ref="id" v-model="id" size=15 class="input-sm">
          </td>
        </tr>
        <tr>
          <th width=30%>PW</th>
          <td width=70%>
             <input type="password" ref="pwd" v-model="pwd" size=15 class="input-sm">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=button class="bt-sm btn-primary" value="로그인"
             @click="login()"
            >
          </td>
        </tr>
      </table>
    </div>
	<script>
      let logApp=Vue.createApp({
         data(){
            return{
               id:'',
               pwd:'',
               msg:''
			}
		},
         methods:{
          login(){
             if(this.id===""){
                this.$refs.id.focus() // 태그를 제어
                return
             }
             if(this.pwd===""){
                this.$refs.pwd.focus()
                return
             }
             
             // 서버에 로그인 요청 = 결과값을 받는다 
             // 요청 / 응답 => Ajax => axios => get / then 
             //                      | vue / react (axios/fatch)
             // login_vue.do?id=aaa&pwd=1234
             axios.post('../food/login_vue.do',null,{
            	 params:{
						id:this.id,
						pwd:this.pwd
					}
				}).then(response=>{
					console.log(response.data)
					if(response.data==="NOID"){
						alert("아이디가 존재하지 않습니다")
						this.id=''
						this.pwd=''
						this.$refs.id.focus()
					}else if(response.data==="NOPWD"){
						alert("비밀번호가 틀립니다!!")
						this.pwd=''
						this.$refs.pwd.focus()
					}else if(response.data==="OK"){
						alert("로그인되었습니다")
						location.href="../food/list.do"
					}
				}).catch(error=>{
					console.log(error.response)
				})
			}  
		}
	}).mount('.container')
    </script>
	</div>
</body>
</html>