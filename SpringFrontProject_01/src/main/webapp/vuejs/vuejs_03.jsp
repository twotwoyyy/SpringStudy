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
		<div class="row">
			<h3 class="text-center">{{title}}</h3>
			<!--<table class="table">
				<tr>
					<td width="20%">사번</td>
					<th width="80%" v-text="sawon.sabun"></th>
				</tr>
				 쓰는 방식이 두 가지 형태, v-text와 {{}} 
				<tr>
					<td width="20%">이름</td>
					<th width="80%">{{sawon.name}}</th>
				</tr>
				<tr>
					<td width="20%">부서명</td>
					<th width="80%">{{sawon.dept}}</th>
				</tr>
				<tr>
					<td width="20%">직위</td>
					<th width="80%">{{sawon.job}}</th>
				</tr>
				<tr>
					<td width="20%">근무지</td>
					<th width="80%">{{sawon.loc}}</th>
				</tr>
				<tr>
					<td width="20%">연봉</td>
					<th width="80%">{{sawon.pay}}</th>
				</tr>
			</table>
			이거는 아래처럼 쓸 경우에 
			let app=Vue.createApp({
			data(){
				return {
					title:'사원 목록',
					sawon:{"sabun":1,"name":"홍길동","dept":"개발부","job":"대리","loc":"서울","pay":3600}
				}
			}
		}).mount('.container')
			-->
			<table class="table">
				<thead>
				<tr>
					<th class="text-center">사번</th>
					<th class="text-center">이름</th>
					<th class="text-center">부서명</th>
					<th class="text-center">직위</th>
					<th class="text-center">근무지</th>
					<th class="text-center">연봉</th>
				</tr>
				</thead>
				<tbody>
					<tr v-for="vo in sawon" v-on:click="detail_data(vo)">
						<td class="text-center">{{vo.sabun}}</td>
						<td class="text-center">{{vo.name}}</td>
						<td class="text-center">{{vo.dept}}</td>
						<td class="text-center">{{vo.job}}</td>
						<td class="text-center">{{vo.loc}}</td>
						<td class="text-center">{{vo.pay}}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<%-- jquery의 : show() / hide()를 true,false로 --%>
		<div class="row" v-show="isShow">
			<ul>
				<li>사번:{{detail.sabun}}</li>
				<li>이름:{{detail.name}}</li>
				<li>부서명:{{detail.dept}}</li>
				<li>직위:{{detail.job}}</li>
				<li>근무지:{{detail.loc}}</li>
				<li>연봉:{{detail.pay}}</li>
			</ul>
		</div>
	</div>
	
	<script>
		let app = Vue.createApp({
		data() {
			return {
				title: '사원 목록',
				sawon: [
					{"sabun": 1, "name": "홍길동", "dept": "개발부", "job": "대리", "loc": "서울", "pay": 3600},
					{"sabun": 2, "name": "김철수", "dept": "개발부", "job": "사원", "loc": "서울", "pay": 3000},
					{"sabun": 3, "name": "이영희", "dept": "인사부", "job": "대리", "loc": "부산", "pay": 3200},
					{"sabun": 4, "name": "박민수", "dept": "개발부", "job": "팀장", "loc": "서울", "pay": 4000},
					{"sabun": 5, "name": "최지우", "dept": "영업부", "job": "사원", "loc": "대전", "pay": 2800}
					],
			isShow:false,
			detail:{}
			}
		},
		methods:{
			detail_data(s){
				// 메소드 안에 설정된 변수는 지역변수 
				// data()에 설정된 변수는 멤버변수 => 변수를 사용시에는 this. 로 값을 가져와야 한다 
				this.detail=s;
				this.isShow=true;
				// this가 없는 경우에는 일반 지역 변수다 
			}
		}
	}).mount('.container') // HTML의 영역을 제어
	/*
		제어문
			v-for : 반복문
			v-if / v-show : 조건문
			============== true일 때 실행
			v-on : 이벤트 
			     click="함수명"
			     change="함수명"
			     keydown / keyup
			     mousedown / mouseup 
			===========================
			v-model : 양방향 => 입력 값을 받아서 출력 
			
	*/
	</script>
</body>
</html>