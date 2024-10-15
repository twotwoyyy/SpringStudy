<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="buyApp">
		<table class="table">
			<tr>
				<td class="text-center" colspan="6">
					<h4>구매 내역</h4>
				</td>
			</tr>
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center"></th>
				<th class="text-center">수량</th>
				<th class="text-center">가격</th>
				<th class="text-center">등록일</th>
				<th class="text-center">비고</th>
			</tr>
			<tr v-for="vo in buy_list">
				<td class="text-center">{{vo.cno}}</td>
				<td class="text-center">
					<img :src="vo.gvo.goods_poster" style="width: 50px; height: 50px">
				</td>
				<td class="text-center">{{vo.account}}</td>
				<td class="text-center">{{vo.gvo.goods_price}}</td>
				<td class="text-center">{{vo.dbday}}</td>
				<td class="text-center">
					<button class="btn-sm btn-info" @click="goodsCancel(vo.cno)">취소</button>
					<button class="btn-sm btn-warning" @click="goodsDetail(vo.gno)">상세보기</button>
				</td>
			</tr>
		</table>
		<div v-show="isShow">
			<h4>상품 상세보기</h4>
			<table class="table">
				<tr>
					<td width="30%" class="text-center" rowspan="5">
						<img :src="detail_data.goods_poster" style="width: 100%">
					</td>
					<td colspan="2">
						<h4>{{detail_data.goods_name}}</h4>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						{{detail_data.goods_sub}}
					</td>
				</tr>
				<tr>
					<td style="color: red">{{detail_data.goods_discount}}%</td>
					<td>{{detail_data.goods_price}}</td>
				</tr>
				<tr>
					<td>첫 번째 구매</td>
					<td style="color:green">{{detail_data.goods_first_price}}</td>
				</tr>
				<tr>
					<td style="color: gray">배송</td>
					<td>{{detail_data.goods_delivery}}</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		buyApp=Vue.createApp({
			data(){
				return {
					buy_list:[],
					detail_data:{},
					isShow:false
				}
			},
			mounted(){
				axios.get('../mypage/mypage_buy_vue.do')
				.then(res=>{
					this.buy_list=res.data
	
				}).catch(error=>{
					console.log(error.response)
				})
			},
			methods:{
				goodsCancel(cno){
					axios.get('../goods/buy_cancel_vue.do',{
						params:{cno:cno}
					}).then(res=>{
						this.buy_list=res.data
						
					}).catch(error=>{
						console.log(error.response)
					})
				},
				goodsDetail(gno){
					this.isShow=true
					axios.get('../mypage/goods_detail_vue.do',{
						params:{gno:gno}
					}).then(res=>{
						console.log(res.data)
						this.detail_data=res.data
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#buyApp')
	</script>
</body>
</html>