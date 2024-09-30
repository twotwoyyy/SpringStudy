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
.container-fluid{
	margin-top: 50px;
}
.col-sm-8,.col-sm-4{
	margin: 0px auto;
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
	<div class="container-fluid">
		<div class="col-sm-8">
			<div class="col-md-3" v-for="vo in list">
				<div class="thumbnail">
					<a class="nav-link" @click="detailData(vo.fno)"> 
					<img :src="vo.poster" style="width: 230px;height: 200px">
						<div class="caption">
							<p>{{vo.name}}</p>
						</div>
					</a>
				</div>
			</div>
			<div style="height: 10px"></div>
			<div class="text-center">
				<ul class="pagination">
					<li v-if="startPage>1"><a class="nav-link" @click="prev()">&lt;</a></li>
					<li v-for="i in range(startPage,endPage)" :class="i==curpage?'active':''">
						<a class="nav-link" @click="pageChange(i)">{{i}}</a>
					</li>
					<li v-if="endPage<totalpage"><a class="nav-link" @click="next()">&gt;</a></li>
				</ul>
			</div>
		</div>
		<div class="col-sm-4" v-show="isShow">
			<food-detail v-bind:detail="detail"></food-detail>
		</div>
	</div>
	<script>
		const food_detail={
				props:['detail'],
				template:`<table class="table">
					<tr>
						<td width="30%" class="text-center" rowspan="7">
							<img :src="'http://www.menupan.com'+detail.poster" style="width: 100%">
						</td>
						<td colspan="2">
							<h3>{{detail.name}}&nbsp;<span style="color:orange">{{detail.score}}</span></h3>
						</td>
					</tr>
					<tr>
						<th width="20%">종류</th>
						<td width="50%">{{detail.type}}</td>
					</tr>
					<tr>
						<th width="20%">주소</th>
						<td width="50%">{{detail.address}}</td>
					</tr>
					<tr>
						<th width="20%">전화</th>
						<td width="50%">{{detail.phone}}</td>
					</tr>
					<tr>
						<th width="20%">주차</th>
						<td width="50%">{{detail.parking}}</td>
					</tr>
					<tr>
						<th width="20%">영업시간</th>
						<td width="50%">{{detail.time}}</td>
					</tr>
					<tr>
						<th width="20%">테마</th>
						<td width="50%">{{detail.theme}}</td>
					</tr>
				</table>
				<table class="table">
					<tr>
						<td>{{detail.content}}</td>
					</tr>
				</table>`
		}
		let app=Vue.createApp({
			data(){
				return {
					list:[],
					curpage:1,
					startPage:0,
					endPage:0,
					totalpage:0,
					detail:{},
					isShow:false
				}
			},
			mounted(){
				this.dataRecv()
			},
			updated(){
				
			},
			methods:{
				detailData(fno){
					this.isShow=true
					axios.get('../food/detail_vue.do',{
						params:{
							fno:fno
						}
					}).then(response=>{
						console.log(response.data)
						this.detail=response.data
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
				dataRecv(){
					axios.get('../food/list_vue.do',{
						params: {
							page: this.curpage 
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
				'food-detail':food_detail
			}
		}).mount('.container-fluid')
	</script>
</body>
</html>