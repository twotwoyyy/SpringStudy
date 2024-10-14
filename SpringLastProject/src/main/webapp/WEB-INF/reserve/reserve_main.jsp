<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
<style type="text/css">
.food_click:hover {
	cursor: pointer;
	background-color: gray;
}
</style>
</head>
<body>
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
						<h2>맛집 예약</h2>
					</div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
	
                </div>
            </div>
		</div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Single Blog Area Start ****** -->
	<section class="single_blog_area section_padding_80" id=reserveApp>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-lg-12">
					<div class="row no-gutters">
						<table class="table">
							<tr>
								<td width="20%" height="500">
									<table class="table">
										<tr>
											<td>
												<h4>맛집 정보</h4>
											</td>
										</tr> 
										<tr>
											<td colspan="2">
												<button class="btn-xs btn-danger" @click="typeChange('한식')">한식</button>
												<button class="btn-xs btn-success" @click="typeChange('양식')">양식</button>
												<button class="btn-xs btn-info" @click="typeChange('중식')">중식</button>
												<button class="btn-xs btn-primary" @click="typeChange('일식')">일식</button>
												<button class="btn-xs btn-warning" @click="typeChange('분식')">분식</button>
											</td>
										</tr>
									</table>
									<div style="overflow-y: auto; height: 500px">
										<table class="table">
											<tr>
												<th class="text-center"></th>
												<th class="text-center">업체명</th>
											</tr>
											<tr v-for="vo in food_list" class="food_click" @click="foodSelect(vo.fno,vo.poster,vo.name)">
												<td class="text-center">
													<img :src="'http://menupan.com'+vo.poster" style="width: 40px; height: 40px">
												</td>
												<td>{{vo.name}}</td>
											</tr>
											<tr>
												<td colspan="2" class="text-center">
													<button class="btn-xs btn-success" @click="prev()">이전</button>
														{{curpage}} page / {{totalpage}} pages
													<button class="btn-xs btn-info" @click="next()">다음</button>
												</td>
											</tr>
										</table>
									</div>
								</td>
								<td width="45%" height="500">
									<table class="table">
										<tr>
											<td>
												<h4>예약일 정보</h4>
											</td>
										</tr>
										<tr v-show="isDate">
											<td>
												<div id="calendar"></div>
											</td>
										</tr>
									</table>
								</td>
								<td width="35%" height="500" rowspan="2">
									<table class="table">
										<tr>
											<td colspan="2">
												<h4>예약 정보</h4>
											</td>
										</tr>
										<tr>
											<td colspan="2" class="text-center">
												<img :src="''+image" style="width: 200px; height: 150px">
											</td>
										</tr>
										<tr>
											<th width="30%" class="text-center">업체명</th>
											<td width="70%">{{name}}</td>
										</tr>
										<tr>
											<th width="30%" class="text-center">예약일</th>
											<td width="70%">{{rday}}</td>
										</tr>
										<tr>
											<th width="30%" class="text-center">시간</th>
											<td width="70%">{{time}}</td>
										</tr>
										<tr>
											<th width="30%" class="text-center">인원</th>
											<td width="70%">{{inwon}}</td>
										</tr>
										<tr v-show="isReserveBtn">
											<td colspan="2" class="text-center">
												<button class="btn-lg btn-danger" @click="reserve()">예약</button>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td width="30%" height="150">
									<table class="table">
										<tr>
											<td>
												<h4>시간 정보</h4>
											</td>
										</tr>
										<tr v-show="isTime">
											<td class="text-center">
												<span class="btn btn-xs btn-success" v-for="t in time_list" style="margin: 1px"
													@click="timeSelect(t)">
													{{t}}
												</span>
											</td>
										</tr>
									</table>
								</td>
								<td width="30%" height="150">
								
									<table class="table">
										<tr>
											<td>
												<h4>인원 정보</h4>
											</td>
										</tr>
										<tr v-show="isInwon">
											<td class="text-center">
												<span class="btn btn-xs btn-primary" v-for="i in inwon_list" style="margin: 1px"
													@click="inwonSelect(i)">
													{{i}}
												</span>
											</td>
										</tr>
									</table>
								</td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		let reserveApp=Vue.createApp({
			data(){
				return {
					type:'한식',
					curpage:1,
					totalpage:0,
					food_list:[],
					image:'../img/noimg.jpg',
					fno:0,
					name:'',
					isDate:false,
					rday:'',
					time:'',
					inwon:'',
					time_list:[],
					inwon_list:[],
					isTime:false,
					isInwon:false,
					isReserveBtn:false
				}
			},
			mounted(){
				let date=new Date()
				let year=date.getFullYear()
				let month=("0"+(1+date.getMonth())).slice(-2)
				let day=("0"+date.getDate()).slice(-2)
				let _this=this
				document.addEventListener("DOMContentLoaded",function(){
					let calendarEl=document.getElementById('calendar')
					let calendar=new FullCalendar.Calendar(calendarEl,{
						initialView:'dayGridMonth',
						height:450,
						/*headerToolbar:{
							left:'prev,next',
							center:'title'
						},*/
						validRange:{
							start:year+"-"+month+'-'+day
						},
						themeSystem:'bootstrap',
						editable:true,
						dropable:true,
						dateClick:((info)=>{
							//alert('click date:'+info.dateStr)
							// this.rday=info.dateStr => FullCalender
							_this.isTime=true
							_this.rday=info.dateStr // => Vue
						})
					})
					calendar.render()
				})
				this.dataRecv()
			},
			// data(), methods => vue 클래스의 멤버 변수, 멤버 메소드 => 사용 시에는 반드시 this.
			methods:{
				reserve(){
					axios.post('../reserve/reserve_ok_vue.do',null,{
						params:{fno:this.fno, rday:this.rday, rtime:this.time,rinwon:this.inwon}
					}).then(response=>{
						console.log(response.data)
						if(response.data==='yes'){
							location.href="../mypage/mypage_reserve.do"
						}else{
							alert(response.data)
						}
						
					}).catch(error=>{
						console.log(error.response)
					})
				},
				inwonSelect(i){
					this.inwon=i
					this.isReserveBtn=true
				},
				timeSelect(t){
					this.time=t
					this.isInwon=true
				},
				foodSelect(fno,poster,name){
					this.fno=fno
					this.image='http://menupan.com'+poster
					this.name=name
					this.isDate=true
				},
				prev(){
					this.curpage=this.curpage>1?this.curpage-1:this.curpage
					this.dataRecv()
				},
				next(){
					this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
					this.dataRecv()
				},
				typeChange(type){
					this.type=type
					this.curpage=1
					this.dataRecv()
				},
				dataRecv(){
					// @GetMapping, axios.post() => @PostMapping => 405
					// 404(파일명 오류), 405(GET/POST), 400(매개변수 오류), 500(소스 에러)
					axios.get('../reserve/reserve_main_vue.do',{
						params:{
							type:this.type,
							page:this.curpage
						}
					}).then(response=>{
						console.log(response.data)
						// 서버에서 전송한 데이터를 받는다 
						this.food_list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.type=response.data.type
						// response.data={name:'',sex:'',address:''}
						//                객체 
						this.time_list=response.data.tList
						this.inwon_list=response.data.iList
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#reserveApp')
	</script>
</body>
</html>