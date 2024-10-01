<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 800px;
}
</style>

</head>
<body>
	<div class="container">
		<h3 class="text-center">상세보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center" rowspan="7" width="30%">
						<img :src="'http://www.menupan.com'+vo.poster" style="width: 240px; height: 350px">
					</td>
					<td colspan="2">
						<h3>{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h3>
					</td>
				</tr>
				<tr>
					<td style="color: gray" width="20%">종류</td>
					<td width="50%">{{vo.type}}</td>
				</tr>
				<tr>
					<td style="color: gray" width="20%">주소</td>
					<td width="50%">{{vo.address}}</td>
				</tr>
				<tr>
					<td style="color: gray" width="20%">전화</td>
					<td width="50%">{{vo.phone}}</td>
				</tr>
				<tr>
					<td style="color: gray" width="20%">영업시간</td>
					<td width="50%">{{vo.time}}</td>
				</tr>
				<tr>
					<td style="color: gray" width="20%">주차</td>
					<td width="50%">{{vo.parking}}</td>
				</tr>
				<tr>
					<td style="color: gray" width="20%">테마</td>
					<td width="50%">{{vo.theme}}</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>{{vo.content}}</td>
				</tr>
			</table>
		</div>
		<hr>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<table class="table" v-for="rvo in reply_list">
							<tr>
								<td width="80%" class="text-left">
									◑{{rvo.name}}({{rvo.dbday}})
								</td>
								<td width="20%" class="text-right">
									<span v-if="rvo.id===sessionId">
										<!-- <input type="button" class="btn btn-xs btn-success ups" value="수정" :data-rno="rvo.rno">&nbsp; -->
										<input type=button class="btn btn-xs btn-success ups" value="수정" 
						                @click="updateForm(rvo.rno)" :id="'up'+rvo.no">&nbsp;
										<input type="button" class="btn btn-xs btn-danger" value="삭제" @click="replyDelete(rvo.rno)">
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<pre style="white-space: pre-wrap; background-color: white; border: none;">{{rvo.msg}}</pre>
								</td>
							</tr>
							<tr class="updates" style="display: none" :id="'u'+rvo.rno">
								<td colspan="2">
									<textarea rows="3" cols="80" style="float: left" :id="'msg'+rvo.rno">{{rvo.msg}}</textarea> <!-- 값을 채울 땐 vo-model 있으면 안됨 -->
									<input type="button" value="댓글 수정" style="float: left; width: 80px; height: 70px; background-color: gray; color: white;"
									@click="replyUpdate(rvo.rno)">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div class="row">
			<table class="table" v-if="sessionId!=''">
				<tr>
					<td>
						<textarea rows="3" cols="95" style="float: left" ref="msg" v-model="msg"></textarea>
						<input type="button" value="댓글 쓰기" style="float: left; width: 80px; height: 70px; background-color: green; color: white;"
						@click="replyInsert()">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let detailApp=Vue.createApp({
			data(){
				return {
					vo:{},
					fno:${fno},
					sessionId:'${sessionId}',// 문자열이라 꼭 싱글따옴표를 붙여야 한다 
					reply_list:[],
					msg:'',
					isUps:false
				}
			},
			mounted(){

				// jquery 설정 => $(function(){})
				/*
					$(document).on('click', '.ups', (event) => {
			        let rno = $(event.target).data('rno');
			        let $updateRow = $('#u' + rno);
			
			        if ($updateRow.is(':visible')) {
			            $updateRow.hide();
			            $(event.target).val('수정');
			        } else {
			            $updateRow.show();
			            $(event.target).val('취소');
			        }
			    });
				이거는 처리 됨
				*/
				axios.get('../food/detail_vue.do',{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					console.log(response.data)
					this.vo=response.data
				}).catch(error=>{
					console.log(error.response)
				})
				// axios => 댓글
				
				axios.get('../food/reply_list_vue.do',{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					console.log(response.data)
					this.reply_list=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			// 댓글 처리 => INSERT / SELECT / UPDATE / DELETE 
			methods:{
				replyUpdate(rno){
					let msg=$('#msg'+rno).val()
					if(msg===""){
						$('#msg'+rno).focus()
						return 
					}
					
					axios.post('../food/reply_update_vue.do',null,{
						params:{
							rno:rno,
							fno:this.fno,
							msg:msg
						}
					}).then(response=>{
						alert("댓글이 수정됐습니다")
						console.log(response.data)
						this.reply_list=response.data
						this.msg=''
						$('#u'+rno).hide()
						$('#up'+rno).val("수정")
					}).catch(error=>{
						console.log(error.response)
					})
				},
				updateForm(rno){
					$('.updates').hide()
					$('.ups').val('수정')
					if(this.isUps===false){
						this.isUps=true
						$('#u'+rno).show()
						$('#up'+rno).val("취소")
					}else{
						this.isUps=false
						$('#u'+rno).hide()
						$('#up'+rno).val("수정")
					}
				},
				replyInsert(){
					if(this.msg===""){
						this.$refs.msg.focus()
						return
					}
					axios.post('../food/reply_insert_vue.do',null,{
						params:{
							fno:this.fno,
							msg:this.msg
						}
					}).then(response=>{
						console.log(response.data)
						this.reply_list=response.data
						this.msg=''
						this.$refs.msg.focus()
					}).catch(error=>{
						console.log(error.response)
					})
				},
				replyDelete(rno){
					axios.get('../food/reply_delete_vue.do',{
						params:{
							rno:rno,
							fno:this.fno
						}
					}).then(response=>{
						alert("댓글이 삭제됐습니다")
						console.log(response.data)
						this.reply_list=response.data
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>