<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Component</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 800px;
}
p{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="text-center">
				<my-button v-bind:btn="btn" @click="btnClick1()"></my-button>
				<my-button1 v-bind:btn1="btn1" @click="btnClick2()"></my-button1>
				<my-button2 v-bind:btn2="btn2" @click="btnClick3()"></my-button2>
			</div>
		</div>
	</div>
<script>
	// 페이징 / 카드 출력
	const mybtn={
		props:['btn'],
		template:`<button class="btn-sm btn-danger">{{btn}}</button>`,
		methods:{
			btnClick1(){
				this.$parent.btnClick1()
			}
		}
	}
	const mybtn1={
		props:['btn1'],
		template:`<button class="btn-sm btn-success">{{btn1}}</button>`	
	}
	const mybtn2={
		props:['btn2'],
		template:`<button class="btn-sm btn-primary">{{btn2}}</button>`	
	}
	let app=Vue.createApp({
		// 재사용 => component

		data(){
			return {
				btn:'로그인',
				btn1:'취소',
				btn2:'회원가입',
				message:'로그인 버튼 클릭'
			}
		},
		methods:{
			btnClick1(){
				alert(this.message)
			}
		},
		// child => parent
		components:{
			'my-button':mybtn,
			'my-button1':mybtn1,
			'my-button2':mybtn2
		}
	}).mount('.container')
</script>
</body>
</html>