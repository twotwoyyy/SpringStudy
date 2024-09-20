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
	width: 960px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center">
						<img :src="detail_data.poster" style="width: 800px;height: 300px">
					</td>
				</tr>
				<tr>
					<td class="text-center"><h3>{{detail_data.title}}</h3></td>
				</tr>
				<tr>
					<td class="text-center">{{detail_data.content}}</td>
				</tr>
			</table>
			<h3>[조리 순서]</h3>
			<table class="table">
				<tr>
					<td>
						<table class="table" v-for="(m,index) in make_list">
							<tr>
								<td class="text-left" width="80%">{{m}}</td>
								<td class="text-right" width="20%">
									<img :src="image_list[index]" style="width: 130px; height: 80px">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let detailApp=Vue.createApp({
			data(){
				return {
					no:${no},//EL이용
					detail_data:{},
					image_list:[],
					make_list:[]
				}
			},
			mounted(){
				axios.get('http://localhost:8080/web/recipe/detail_vue.do',{
					params:{
						no:this.no
					}
				}).then(res=>{
					console.log(res.data)
					this.detail_data=res.data.vo
					this.image_list=res.data.iList
					this.make_list=res.data.mList
				})
			}
		}).mount('.container')
	</script>
</body>
</html>