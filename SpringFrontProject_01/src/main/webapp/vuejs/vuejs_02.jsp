<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	margin-top: 50px;
}
.row {
	margin: 0px auto;
	width: 300px;
}
</style>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
	<div class="container">
		<div class="row" id="app1">
			<div class="text-center">{{msg}}</div>
		</div>
		<div class="row" id="app2">
			<div class="text-center">{{msg}}</div>
		</div>
	</div>
	<script type="text/javascript"> // 쿠키 등 출력시.. 부분 영역 제어
		let app1=Vue.createApp({
			data(){
				return {
					msg:'Hello Vue3!!'
				}
			}
		}).mount('#app1') // mount 제어하는 영역
		let app2=Vue.createApp({
			data(){
				return {
					msg:'Hello VueJS'
				}
			}
		}).mount('#app2')
	</script>
</body>
</html>