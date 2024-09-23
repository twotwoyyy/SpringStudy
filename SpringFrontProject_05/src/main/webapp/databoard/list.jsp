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
				--%>
				<tbody>
					<tr>
						<td width="10%" class="text-center"></td>
						<td width="45%"></td>
						<td width="15%" class="text-center"></td>
						<td width="20%" class="text-center"></td>
						<td width="10%" class="text-center"></td>
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
					
				}
			},
			// 생명주기 함수 => onload => 브라우저 출력 전에 서버로부터 데이터를 받아올 때 
			mounted(){
				
			},
			// 멤버변수의 값이 변경된 경우 => Component 제작
			updated(){

			},
			methods:{
				
			}
			// components / filter / compted
		}).mount('.container')
	</script>
</body>
</html>