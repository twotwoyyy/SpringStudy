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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
<!-- autoload=false& 를 넣어야 자동 실행이 안돼서 오류가 나지 않는다  -->
<!--  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=918c2204eb4698435b98b635e797844d&libraries=services"></script>-->
</head>
<body>
	<div class="container">
		<div class="row">
	   		<table class="table">
	            <tr>
	               <td class="text-center" v-for="img in images">
	                  <img :src="'http://www.menupan.com'+img" style="width:120px;height:100px;">
	               </td>
	            </tr>
	         </table>
			 <table class="table">
			 	<tr>
			 		<td width="30%" class="text-center" rowspan="7">
			 			<img :src="'http://www.menupan.com'+vo.poster" style="width: 100%">
			 		</td>
			 		<td colspan="2">
			 			<h3 id="name">{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h3>
			 		</td>
			 	</tr>
			 	<tr>
			 		<td class="text-right" width=15%>주소</td>
			 		<td width="55%">{{vo.address}}</td>
			 	</tr>
			 	<tr>
			 		<td class="text-right" width=15%>전화</td>
			 		<td width="55%">{{vo.phone}}</td>
			 	</tr>
			 	<tr>
			 		<td class="text-right" width=15%>종류</td>
			 		<td width="55%">{{vo.type}}</td>
			 	</tr>
			 	<tr>
			 		<td class="text-right" width=15%>주차</td>
			 		<td width="55%">{{vo.parking}}</td>
			 	</tr>
			 	<tr>
			 		<td class="text-right" width=15%>영업시간</td>
			 		<td width="55%">{{vo.time}}</td>
			 	</tr>
			 	<tr>
			 		<td class="text-right" width=15%>테마</td>
			 		<td width="55%">{{vo.theme}}</td>
			 	</tr>
			 </table>
			 <table class="table">
			 	<tr>
			 		<td>{{vo.content}}</td>
			 	</tr>
			 	<tr>
			 		<td class="text-right">
			 			<input type="button" value="목록" class="btn btn-sm btn-primary" onclick="javascript:history.back()">
			 		</td>
			 	</tr>
			 </table>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<div id="map" style="width:100%;height:350px;"></div>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<h3>인근 맛집</h3>
			<hr>
			<table class="table">
				<tr>
					<td class="text-center" v-for="vo in house_images">
						<a :href="'detail.do?fno='+vo.fno+'&page='+page">
						 <table class="table">
							<img :src="'http://www.menupan.com'+vo.poster" :title="vo.address" style="width: 120px; height: 100px;">
								<tr>
									<td class="text-center">{{vo.name}}</td>
								</tr>
							</table>
						</a>
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
					page:${page},
					fno:${fno}, // model로 보낸 값은 (EL)로 불러와야 한다 => JSTL만 가능
					address:'',
					images:[],
					house_images:[]
				}
			},
			mounted(){
				axios.get('detail_vue.do',{
					params:{
						fno:this.fno,
						page:this.page
					}
				}).then(response=>{
					console.log(response.data)
					this.vo=response.data.vo
					this.page=response.data.page
					this.fno=response.data.fno
					this.address=response.data.address
					this.images=response.data.vo.images.split("^")
					this.house_images=response.data.list
					
					if(window.kakao && window.kakao.map){
						this.initMap()
					}else{
						this.addScript()
					}
				}).catch(error=>{
					console.log(error.response)
				})
			},
			methods:{
				addScript(){
					const script=document.createElement("script")
					// <script src="">를 만들고 있는 것 
					script.onload = () => {
				        console.log("Kakao Maps 스크립트가 로드되었습니다");
				        kakao.maps.load(this.initMap);
				    };
				    script.src = "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=918c2204eb4698435b98b635e797844d&libraries=services";
				    document.head.appendChild(script);
				},
				initMap(){
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  

				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption); 

				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();

				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(this.address, function(result, status) {

				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {

				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });

				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        var infowindow = new kakao.maps.InfoWindow({
				            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
				        });
				        infowindow.open(map, marker);

				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});    
				}
			}
		}).mount('.container')
	</script>
</body>
</html>