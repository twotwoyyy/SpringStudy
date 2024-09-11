<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="row" id="boardApp">
		<h3 class="text-center">Front 게시판</h3>
		<table class="table">
			<tr>
				<td>
					<a href="../board/insert.do" class="btn btn-sm btn-primary">새 글</a>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" size="20" class="input-sm" v-model="message">
				</td>
			</tr>
			<tr>
				<td>
					<span>{{message}}</span> <%--검색어 자동 입력!! --%>
				</td>
			</tr>
		</table>
		<%--
			1. 검색 => 다이얼로그
			2. 댓글
			3. 채팅
			4. 추천
			5. 로그인 / 아이디 찾기 / 비밀번호
			6. 예약 
			7. 결제
			8. 지도
			=========== Ajax => Vue
			                    React
			                    ===== + NextJS
		 --%>
		<table class="table">
			<tr>
				<th width="10%" class="text-center">번호</th>
				<th width="45%" class="text-center">이름</th>
				<th width="15%" class="text-center">제목</th>
				<th width="20%" class="text-center">작성일</th>
				<th width="10%" class="text-center">조회수</th>
			</tr>
			<tr v-for="vo in board_list">
				<td width="10%" class="text-center" v-text="vo.no"></td>
				<td width="45%" v-text="vo.subject"></td>
				<td width="15%" class="text-center" v-text="vo.name"></td>
				<td width="20%" class="text-center" v-text="vo.dbday"></td>
				<td width="10%" class="text-center" v-text="vo.hit"></td>
			</tr>
			<tr>
				<td colspan="5" class="text-center">
					<input type="button" class="btn-sm btn-warning" value="이전">
						{{curpage}} page / {{totalpage}} pages
					<input type="button" class="btn-sm btn-warning" value="다음">
				</td>
			</tr>
		</table>
	</div>
	<script>
		let boardApp=Vue.createApp({
			// 멤버 변수 => HTML에서 사용이 가능
			data(){
				return {
					board_all:{},
					board_list:[],
					curpage:1,
					totalpage:0,
					message:''
				}
			},
			/*
				1. created() : vue 객체 생성 
				*** 2. mounted() : 초기화 담당, 자동호출, 콜백
				*** 3. update() : 멤버변수의 데이터가 변경
				4. destoryed() : 화면 이동 => 메모리 해제
				
				=> 양방향 통신
			*/
			mounted(){
				// $(function(){}) window.onload
				// 스프링 연결 => 실행 요청
				axios.get('../board/list_vue.do',{
					params:{
						page:this.curpage
					}
				}).then(response => { // return값을 받는다
					console.log(response.data)
					this.board_all=response.data
					this.board_list=response.data.list
					this.curpage=response.data.curpage
					this.totalpage=response.data.totalpage
				})
			}
		}).mount('#boardApp');
	</script>
</body>
</html>