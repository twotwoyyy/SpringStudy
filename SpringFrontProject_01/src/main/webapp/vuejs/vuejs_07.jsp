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
.row {
	margin: 0px auto;
	text-align: center;
	width: 960px;
}

</style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://unpkg.com/vue@3"></script>
</head>
<%--foreach 
	v-for="변수 in 배열" => for-each만 존재 => 어디부터 어디까지는 문법상 존재 x 
	~어디서부터 어디까지가 없다. begin,end 없음 
	
--%>	
<body>
	<div class="container">
		<div class="row">
			Start:<input type="text" size="5" class="input-sm" v-model="startPage">
			&nbsp;
			End:<input type="text" size="5" class="input-sm" v-model="endPage">
		</div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<li><a href="#">&laquo</a></li>
					<li v-for="i in range(startPage,endPage)"><a href="#">{{i}}</a></li>
					<li><a href="#">&raquo</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return {
					startPage:0,
					endPage:0
				}
			},
			methods:{
				// 페이지 나눠 반복문 수행 시
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0;i<len+1;i++){
						arr[i]=start
						start++
					}
					return arr
				}
			}
		}).mount('.container')
	</script>
</body>
</html>