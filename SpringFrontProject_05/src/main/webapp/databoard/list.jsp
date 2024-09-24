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
	width: 800px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
</head>
<body>
	<div class="container">
		<h3 class="text-center">자료실</h3>
		<div class="row">			
			<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-danger">등록</a>
					</td>
				</tr>
			</table>
			<table class="table">
				<thead>
					<tr>
						<th width="10%" class="text-center">번호</th>
						<th width="45%" class="text-center">제목</th>
						<th width="15%" class="text-center">이름</th>
						<th width="20%" class="text-center">작성일</th>
						<th width="10%" class="text-center">조회수</th>
					</tr>
				</thead>
				<%-- 
				v-for 
				v-if ~ v-else
				v-on:click, v-on:change, v-on:keydown
				    @click      @change     @keydown
				v-model => 사용자 입력과 Vue의 멤버변수 연결 
				v-bind => 생략이 가능 
				          <img:src=""> : Vue의 변수를 속성에 설정 => :속성
				          <태그>{{{}}</태그> (Vue) => <태그>{}</태그>(React)
				               ===== 형식을 변경할 수 있다 [[]]
				          => 파이썬 : {{}}
				id/class => ref 사용(참조 데이터)
				
				Vue => 패턴 MVVM
				           ----------
				           |        |
				Model   ViewModel  View  => 양방향
				  |                 |
				  -------------------
				  
				  Model : 데이터를 저장하는 변수 (VO(Spring),DTO(MyBatis,iBatis),Bean(JSP)) 
				                           data(){} => 출력 변수를 설정 
				  View : 화면 출력 => HTML 
				         => 태그를 제어 (디렉티브) 
				            v-for, v-if, v-else, v-show, v-on:click ...
				  ViewModel : 상태 관리, 연산 처리, 데이터 읽기, 전송 ...
				              === state => 데이터 변경 
				              Vue에서 저장하는 메소드 (생명주기 메소드)
				               => mounted() => 시작과 동시에 멤버변수 초기화
				               => updated() => component를 사용할 때 
				                               =========
				                               기능 => 이미지 카드, 애니메이션
				                               => 재사용이 가능 
				              사용자 정의 메서드 
				              methods:{
				              	=> 이벤트 처리시 사용
				              }
				              ====================== 옵션 사항 
				              filter : 천단위 앞에,
				              computed : 계산된 경우 (장바구니) 
				              
				  1. Vue 객체 생성
				     let app=Vue.createApp({
				     	data(){
				     		return {
				     			no:0 => int
				     			fd:'' => String
				     			list:[] => array => List
				     			vo:{} => object => VO => JSON
				     			                         자바스크립트 객체 표현법
				     			isShow:false => boolean 
				     		}
				     	},
				     	ViewModel => 데이터를 처리하는 부분 (사용자 요청에 따라)
				     	서버에서 데이터 읽기 / 서버로 데이터 전송
				     	이미 만들어진 메소드 (자동 호출) / 사용자 정의
				     	=> 서버 연결 : ajax / axios / fetch
				     	   axios.get()  => @GetMapping
				     	   axios.post() => @PostMapping
				     	   
				     	   
				     	   // get방식
				     	   axios.get('연결할 URL 주소',null,{
				     	   	  params:{
				     	   	  	보내는 데이터 설정 
				     	   	  }
				     	   }).then(res=>{
				     	   	   정상 수행시 서버에서 전송한 데이터를 받는 위치 
				     	   })
				     	   
				     	   // post 방식 (form)
				     	   axios.post('연결할 URL 주소',formData,{
				     	   	  header:{
				     	   	  	보내는 데이터 설정 
				     	   	  }
				     	   }).then(res=>{
				     	   	   정상 수행시 서버에서 전송한 데이터를 받는 위치 
				     	   })
				     	   
				     	   axios({
				     	   	  url:'',
				     	   	  type:'post'
				     	   })
				     	   
				     }).mount('제어하는 태그')
				     
				     
				     HTML에 Vue변수를 출력
				     <태그>{{변수명}}</태그>
				     <태그 :속성="변수명"> => data()에 설정된 변수만 사용이 가능하다
				     
				     디렉티브
				     v-for="변수 in 배열" => v-for="(변수,인덱스) in 배열"
				     v-if="i===curpage" (==,===(권장)) !=, !==
				     Vue 변수와 태그 매칭 => v-model="Vue변수"
				    
				     태그를 제어할 때
				     <input type="text" id="name">
				       $('#name')
				     <input type="text" ref="name">
				       this.$refs.name
				       
				     이벤트
				       v-on:click="호출된 함수" => @click=""
				       v-on:change="" => @change=""
				       v-on:keydown="" => @keydown=""
				       @keydown.enter="", @keydown.space=""
				       @submit.prevent="" => submit 기능 정지 
				--%>
				<tbody>
					<tr v-for="(vo,index) in list">
						<td width="10%" class="text-center">{{count-index}}</td>
						<%-- v-bind:href => v-bind 생략이 가능
							HTML 태그의 속성에 값을 채운다 => :속성명
							img => :src, :title
							a   => :href
							embed => :src
						 --%>
						<td width="45%"><a :href="'detail.do?no='+vo.no">{{vo.subject}}</a></td>
						<td width="15%" class="text-center">{{vo.name}}</td>
						<td width="20%" class="text-center">{{vo.dbday}}</td>
						<td width="10%" class="text-center">{{vo.hit}}</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" class="text-center">
							<input type="button" value="이전" class="btn-sm btn-success">
								{{curpage}} page / {{totalpage}} pages
							<input type="button" value="다음" class="btn-sm btn-success">
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<script>
		let dataApp=Vue.createApp({
			data(){
				return {
					list:[],
					curpage:1,
					totalpage:0,
					count:0,
					today:""
				}
			},
			// 생명주기 함수 => onload => 브라우저 출력 전에 서버로부터 데이터를 받아올 때 
			mounted(){
				this.dataRecv()
			},
			// 멤버변수의 값이 변경된 경우 => Component 제작
			// Callback => Vue에 의해 자동 호출되는 함수 
			updated(){

			},
			// 사용자 정의 메소드 => 이벤트 => 멤버 메소드
			methods:{
				// 서버에서 데이터를 읽어온다 => 이전/다음/시작 => 반복제거의 방법 : 메소드화
				dataRecv(){
					axios.get('http://localhost:8080/web/databoard/list_vue.do',{
						params:{
							page:this.curpage // 멤버 변수: this 
						}
					}).then(response=>{
						console.log(response.data)
						this.list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.count=response.data.count
						// response={data:{curpage:1,totalpage:0,count:0,list:[]}}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
			// components / filter / compted
		}).mount('.container')
	</script>
</body>
</html>