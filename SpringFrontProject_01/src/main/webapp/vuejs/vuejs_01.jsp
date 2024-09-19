<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	vueJS
	= 웹 화면을 출력하기 위한 자바스크립트 라이브러리 = 프레임워크 
	= 컴포넌트 기반 (기능별 처리가 가능) => .vue, cdn방식을 이용
	                                       ====== ajax처럼 JSP안에서 처리 
	  = 단독으로 처리 / JSP나 HTML안에서 출력이 가능 
	                 ======================== CDN (일반 프로그램에서 합쳐서 처리)
	= 라우터 : 화면 변경, 상태 관리 
	                  ======== 데이터를 저장해서 관리 (vuex) => store
	= 배우기 쉽다 
	= 성능이 좋다 / 속도가 빠르다 
	= 라이브러리가 가볍다 
	= 가상돔 (추가된 부분만 변경) 
	= 앵귤라 JS / ReactJS
	            | 가상돔  
	  | 양방향 통신 
	 =================== 이 두개의 장점을 결합한 라이브러리 
	 <input type="text" id="id">
	 <div id="print"></div>
	 let id=$('#id').val()
	 $('#print').text(id) 
	 => 읽고 값을 넣어준다 (단방향)
	 
	 자동으로 읽혀 값을 넣어준다 (양방향) 
	 
	 StringBuffer / String 차이점 
	 
	 mount : 가상돔에 저장
	 
	 VueJS
	  1. 생명주기
	     callback => 자동 호출 
	     beforeCreate() => Vue 객체 생성 전 
	     created() => Vue 객체 생성
	     beforeMount() => 가상돔에 태그를 올리기 전
	     ***mounted() => 가상돔에 태그를 전송 =>$(function()) window.onload=function(){}
	        => componentDidMount() / useEffect() (리액트)
	        => 서버에서 출력에 필요한 데이터를 읽어 온다 
	     beforeUpdate() => 데이터 수정 전 
	     ***updated() => 데이터 수정 완료 => 컴포넌트 제작 = 재사용 == Modal
	     beforeDestory() => 화면 변경 전
	     destroyed => 화면이 변경
	     let app=Vue.createApp({
	     	$.ajax({
	     	}) 영역이 ({})에 들어간다 
	     	data(){} => 멤버 변수 => 화면에 출력할 데이터 모음
	     	mounted(){} => 멤버변수의 초기화 => 서버에서 데이터 읽기 
	     	methods:{
	     		사용자 정의 함수 
	     	}
	     	components: 등록 
	     }).mount(app)
	  2. 디렉티브 : 태그 제어
	     v-for : 태그 안에 속성 
	     <tr v-for=""> => for문
	     ==
	     ==
	     ==
	     </tr>
	     
	     v-if ~ v-else
	     v-if ~ v-elseif ~ v-else
	     
	     v-text / v-html
	     text()   html() 
	     
	     v-on:click ==> @click
	     v-on:change => @change
	     
	     v-model / v-bind 
	              ======== 이미지 출력 
	     ======= 양방향 통신 
	      
	  3. 서버연동
	  4. 출력 형식
	     {{출력 데이터}} => {react}
	     ============ 장고
	     ${}              ${}
	     => EL/JSTL은 사용하지 않는다 
	  5. 양방향
	  6. 화면 변경 
	 
	 		<script>
		let app=Vue.createApp({
			data(){
				return{
					msg:''
				}
			}
		}).mount('.container') => 여기에 제어 영역 넣기 
		</script>
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let msg=$('#msg').val()
		$('#print').text(msg)
	})
})// 단방향 통신, id 필요
</script> -->
<script src="https://unpkg.com/vue@3"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
	margin-top: 50px;
}
.row {
	margin: 0px auto;
	width: 500px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<input type="text" size="30" class="input-sm" v-model="msg">
		</div>
		<div class="row">{{msg}}</div>
	</div>
	<script>
	let app=Vue.createApp({
		// 출력에 필요한 변수 설정 
		/*
			정수(숫자)
			no:0
			문자열
			msg:''
			객체 => 자바의 VO
			board:{}
			목록 => List 
			board_list:[]
			논리형 
			bCheck:false  
		*/
		data(){
			return{
				msg:''
			}
		},
		beforeCreate(){
			console.log("beforeCreate() Call...")
		},
		created(){
			console.log("created() Call...")
		},
		beforeMount(){
			console.log("beforeMount() Call...")
		},
		mounted(){
			console.log("***mounted() Call... => 화면 출력 완료: onload()")
		},
		beforeUpdate(){
			console.log("beforeUpdate() Call...")
		},
		updated(){
			console.log("updated() Call... => data에 설정된 변수값이 변경된 경우")
		},
		beforeDestroy(){
			console.log("beforeDestroy() Call...")
		},
		destroyed(){
			console.log("destroyed() Call...")
		}
	}).mount('.container') 
	// mount => 제어 영역을 지정
	</script>
</body>
</html>