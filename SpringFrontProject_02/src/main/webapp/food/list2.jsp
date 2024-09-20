<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--VueJS로 코딩 --%>
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
p {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.link:hover{
	cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3" v-for="vo in food_list">
				<div class="thumbnail">
					<a href="#"> 
					<img :src="'http://www.menupan.com'+vo.poster" style="width: 230px; height: 150px">
						<div class="caption">
							<p>{{vo.name}}</p>
						</div>
					</a>
				</div>
			</div>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<li v-if="startPage>1"><a class="link" @click="prev()">&lt;</a></li>
					<li v-for="i in range(startPage,endPage)" :class="i==curpage?'active':''"><a class="link" @click="pageChange(i)">{{i}}</a></li>
					<li v-if="endPage<totalpage"><a class="link" @click="next()">&gt;</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
	/*
		1. 라이브러리 로딩 필요
		   src=https://unpkg.com/vue@3
		   src=https://unpkg.com/axios/dist/axios.min.js
		2. 태그 안에서 속성으로 제어 
		   v- : 디렉티브
		   반복문 : v-for ==> 형식) v-for="받는변수 in 배열" => ex) vo in food_list
		                         v-for="(vo,index) in 배열" => 인덱스 번호는 0부터 시작
		   조건문 : v-if ==> 형식) v-if="조건문"
		          v-if ~ v-else
		          v-if ~ v-else-if ~ v-else
		   기타 
		       v-show="조건문" => true(show), false(hide)
		       데이터값을 받아서 출력 : <태그>{{}}</태그>
		       속성으로 받아서 출력 : 속성값
		3. Vue 객체 생성
		   Vue.createApp({
			   data(){
				   return{
					   서버에서 받는 데이터를 저장 : 멤버 변수 설정 
				   }
			   },
			   mounted(){
				   브라우저 화면에 출력할 데이터를 서버에서 받는 경우 사용 
			   },
			   methods:{
				   // 이벤트 처리 = 사용자 정의 함수
			   },
			   components:{
				   
			   },
			   filter:{
				   
			   },
			   component:{
				   
			   },
			   filter:{
				   금액 , 찍기 등..
			   },
			   computed:{
				   
			   },
			   watch:{
				   
			   }
		   }).mount('제어하는 HTML영역을 지정')
		            ===================== css형식 (class=> . id=> #)
		vue-bootstrap
	*/
		let foodApp=Vue.createApp({
			// Model => 데이터를 저장 => 변경 
			data(){
				return {
					food_list:[],
					curpage:1,
					totalpage:0,
					startPage:0,
					endPage:0
				}
			},
			// ViewModel => 데이터를 수정 => View로 변경된 데이터 전송 
			// 사용자 정의 함수 / 라이브러리 함수 : 생명주기와 관련
			mounted(){
				// onload => 브라우저에 화면이 보이기 전 
				// 서버 연결
				this.dataRecv()
			},
			methods:{
				// 사용자 정의 함수
				pageChange(page){
					this.curpage=page
					this.dataRecv()
				},
				prev(){
					this.curpage=this.startPage-1
					this.dataRecv()
				},
				next(){
					this.curpage=this.endPage+1
					this.dataRecv()
				},
				// dataRecv() 공통된 부분이라 함수로 처리 
				dataRecv(){
					axios.get("http://localhost:8080/web/food/list_vue.do",{
						params:{
							page:this.curpage
						}
					}).then(response=>{// ajax의 success부분
						console.log(response.data)
						this.food_list=response.data.list,
						this.curpage=response.data.curpage,
						this.totalpage=response.data.totalpage,
						this.startPage=response.data.startPage,
						this.endPage=response.data.endPage
					}) 
				},
				// 페이징네이션 => 범위가 없기 때문에 만들어야 한다
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0;i<=len;i++){
						arr[i]=start
						start++
					}
					return arr
				}
			}
		}).mount(".container")
	</script>
</body>
</html>