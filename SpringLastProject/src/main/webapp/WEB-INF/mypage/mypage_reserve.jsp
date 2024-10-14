<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="mypageApp">
		<table class="table">
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center"></th>
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
				<td class="text-center">{{vo.fvo.name}}</td>
				<td class="text-center">{{vo.rday}}</td>
				<td class="text-center">{{vo.rtime}}</td>
				<td class="text-center">{{vo.rinwon}}</td>
				<td class="text-center">{{vo.dbday}}</td>
				<td class="text-center">
					<button class="btn-xs btn-success" v-if="vo.isReserve===1" @click="foodInfo(vo.fno,vo.rno)">예약완료</button>
					<button class="btn-xs btn-default" v-else>예약대기</button>
				</td>
			</tr>
		</table>
		<table class="table" v-if="isShow">
			<tr>
				<td><h4>맛집 정보</h4></td>
			</tr>
			<tr>
				<td width="30%" class="text-center" rowspan="7">
					<img :src="'http://menupan.com'+reserve_info.fvo.poster" style="width: 100%">
				</td>
				<td colspan="2">
					<h4>{{reserve_info.fvo.name}}&nbsp;<span style="color: orange">{{reserve_info.fvo.score}}</span></h4>
				</td>
			</tr>
			<tr>
				<th class="text-center" width="20%">주소</th>
				<td width="50%">{{reserve_info.fvo.address}}</td>
			</tr>
			<tr>
				<th class="text-center" width="20%">전화</th>
				<td width="50%">{{reserve_info.fvo.phone}}</td>
			</tr>
			<tr>
				<th class="text-center" width="20%">음식종류</th>
				<td width="50%">{{reserve_info.fvo.type}}</td>
			</tr>
			<tr>
				<th class="text-center" width="20%">영업시간</th>
				<td width="50%">{{reserve_info.fvo.time}}</td>
			</tr>

			<tr>
				<th class="text-center" width="20%">주차</th>
				<td width="50%">{{reserve_info.fvo.parking}}</td>
			</tr>
			<tr>
				<th class="text-center" width="20%">테마</th>
				<td width="50%">{{reserve_info.fvo.theme}}</td>
			</tr>
		</table>
		<table class="table" v-if="isShow">
			<tr>
				<td colspan="2"><h4>예약 정보</h4></td>
			</tr>
			<tr>
				<th width="20%" class="text-center">예약번호</th>
				<td width="80%">{{reserve_info.rno}}</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">예약일</th>
				<td width="80%">{{reserve_info.rday}}</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">예약시간</th>
				<td width="80%">{{reserve_info.rtime}}</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">예약인원</th>
				<td width="80%">{{reserve_info.rinwon}}</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">신청일</th>
				<td width="80%">{{reserve_info.dbday}}</td>
			</tr>
		</table>
	</div>
	<script>
	  let mypageApp=Vue.createApp({
		  data(){
			  return {
				 reserve_list:[],
				 rno:0,
				 reserve_info:{},
				 isShow:false
			  }
		  },
		  mounted(){
			  // 서버로 전송할 데이터가 없는 경우 params => ?
			  axios.get('../mypage/mypage_reserve_vue.do')
			  .then(response=>{
				  console.log(response.data)
				  this.reserve_list=response.data
			  }).catch(error=>{
				  console.log(error.response)
			  })
		  },
		  methods:{
			  foodInfo(fno,rno){
				this.isShow=true
				axios.get('../mypage/reserve_info_vue.do',{
					params:{
						fno:fno,
						rno:rno
					}
				}).then(response=>{
					console.log(response.data)
					this.reserve_info=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			  }
		  }
	  }).mount("#mypageApp")
	</script>
</body>
</html>