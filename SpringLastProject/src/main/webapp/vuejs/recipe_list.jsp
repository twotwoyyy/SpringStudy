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
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
p{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.nav-link:hover{
	cursor: pointer;
}
</style>
<script src="page.js"></script>
<script src="image.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<poster-card v-bind:list="list"></poster-card>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<div class="text-center">
				<page-card></page-card>
			</div>
		</div>
	</div>
	<script src="vue_list.js"></script>
	
	<%--
			let recipeApp=Vue.createApp({
			data(){
				return {
					list:[],
					curpage:1,
					totalpage:0,
					startPage:0,
					endPage:0
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
				dataRecv(){
					axios.get('../recipe/list_vue.do',{
						params:{
							page:this.curpage
						}
					}).then(response=>{
						console.log(response.data)
						this.list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.startPage=response.data.startPage
						this.endPage=response.data.endPage
					}).catch(error=>{
						console.log(error.response)
					})
				},
				prev(){
					this.curpage=this.startPage-1
					this.dataRecv()
				},
				next(){
					this.curpage=this.endPage+1
					this.dataRecv()
				},
				pageChange(page){
					this.curpage=page
					this.dataRecv()
				},
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0;i<=len;i++){
						arr[i]=start
						start++
					}
					return arr
				}
			},
			components:{
				'poster-card':image_card,
				'page-card':page_card
			}
		}).mount('.container')
	--%>
</body>
</html>