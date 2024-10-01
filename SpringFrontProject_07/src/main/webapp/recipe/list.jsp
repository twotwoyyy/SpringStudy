<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="page.js"></script>
<script src="image.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
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
</head>
<body>
	<div class="container">
		<h1 class="text-center">레시피 목록</h1>
		<div class="row">
			<image-card></image-card>
		</div>
		<div style="height: 5px"></div>
		<div class="row">
			<page-card></page-card>
		</div>
	</div>
	<script>
		let listApp=Vue.createApp({
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
					return arr;
				},
				dataRecv(){
					axios.get('../recipe/list_vue.do',{
						params:{
							page:this.curpage
						}
					}).then(res=>{
						console.log(res.data)
						this.list=res.data.list
						this.curpage=res.data.curpage
						this.totalpage=res.data.totalpage
						this.startPage=res.data.startPage
						this.endPage=res.data.endPage
						
					}).catch(error=>{
						console.log(error.response)
					})
				}
			},
			components:{
				'image-card':image_card,
				'page-card':page_card
			}
		}).mount('.container')
		
	</script>
</body>
</html>