<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="adminApp">
		<table class="table">
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center"></th>
				<th class="text-center">아이디</th>
				<th class="text-center">업체명</th>
				<th class="text-center">예약일</th>
				<th class="text-center">예약시간</th>
				<th class="text-center">인원</th>
				<th class="text-center">등록일</th>
				<th class="text-center">비고</th>
			</tr>
			<tr v-for="vo in reserve_list">
				<td class="text-center">{{vo.rno}}</td>
				<td class="text-center">
					<img :src="'http://menupan.com'+vo.fvo.poster" style="width: 30px;height: 30px">
				</td>
				<td class="text-center">{{vo.id}}</td>
				<td class="text-center">{{vo.fvo.name}}</td>
				<td class="text-center">{{vo.rday}}</td>
				<td class="text-center">{{vo.rtime}}</td>
				<td class="text-center">{{vo.rinwon}}</td>
				<td class="text-center">{{vo.dbday}}</td>
				<td class="text-center">
					<button class="btn-xs btn-success" v-if="vo.isReserve===1">승인완료</button>
					<button class="btn-xs btn-info" v-else @click="ok(vo.rno)">승인대기</button>
				</td>
			</tr>
		</table>
	</div>
	<script>
		let adminApp=Vue.createApp({
			data(){
				return {
					reserve_list:[],
					rno:0
				}
			},
			mounted(){
				axios.get('../admin/admin_reserve_vue.do')
				.then(response => {
				    this.reserve_list = response.data
				}).catch(error => {
				    console.log(error.response)
				})
			},
			methods:{
				ok(rno){
					this.rno=rno
					axios.get('../admin/admin_reserve_ok_vue.do',{
						params:{rno:this.rno}
					}).then(response=>{
						console.log(response.data)
						this.reserve_list=response.data
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#adminApp')
	</script>
</body>
</html>