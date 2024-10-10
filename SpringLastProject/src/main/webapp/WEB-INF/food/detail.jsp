<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=918c2204eb4698435b98b635e797844d&libraries=services"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
.nav-link{
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
				
					<div class="bradcumb-title text-center">
						<h2>맛집 상세보기</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="breadcumb-nav">
		<div class="container">
			<div class="row">
				<div class="col-12"></div>
			</div>
		</div>
	</div>
	<section class="single_blog_area section_padding_80">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-lg-8">
					<div class="row no-gutters">
						<!-- Single Post -->
						<div class="col-12 col-sm-12">
							<!-- Related Post Area -->
							<div class="related-post-area section_padding_50">
								<div class="related-post-slider owl-carousel">
									<!-- Single Related Post-->
									<c:forTokens items="${vo.images }" delims="^" var="img">
										<div class="single-post">
											<!-- Post Thumb -->
											<div class="post-thumb">
												<img src="http://www.menupan.com${img }" alt="">
											</div>
										</div>
									</c:forTokens>
								</div>
							</div>
							<table class="table">
								<tr>
									<td width="35%" class="text-center" rowspan="6">
										<img src="http://www.menupan.com${vo.poster }" style="width:300px;height: 250px">
									</td>
									<td colspan="2">
										<h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3>
									</td>
								</tr>
								<tr>
									<td width="10%" class="text-center">주소</td>
									<td width="55%">${vo.address }</td>
								</tr>
								<tr>
									<td width="15%" class="text-center">전화</td>
									<td width="55%">${vo.phone }</td>
								</tr>
								<tr>
									<td width="15%" class="text-center">종류</td>
									<td width="55%">${vo.type }</td>
								</tr>
								<tr>
									<td width="15%" class="text-center">주차</td>
									<td width="55%">${vo.parking }</td>
								</tr>
								<tr>
									<td width="15%" class="text-center">영업시간</td>
									<td width="55%">${vo.time }</td>
								</tr>
							</table>
							<table class="table">
								<tr>
									<td><span style="font-weight: bold">[테마]&nbsp;</span>${vo.theme }</td>
								</tr>
								<tr>
									<td>${vo.content }</td>
								</tr>
								<tr>
									<td class="text-right">
										<c:if test="${sessionScope.userId!=null }">
											<a href="#" class="btn btn-xs btn-danger">좋아요</a>
											<a href="#" class="btn btn-xs btn-success">찜하기</a>
											<a href="#" class="btn btn-xs btn-info">예약</a>
										</c:if>
										<a href="../food/list.do" class="btn btn-xs btn-warning">목록</a>
									</td>
								</tr>
								<tr>
									<td>
										<div id="map" style="width: 100%; height: 350px;"></div>
									</td>
								</tr>
							</table>
							<script>
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
							geocoder.addressSearch('${vo.address}', function(result, status) {
	
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
							            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name}</div>'
							        });
							        infowindow.open(map, marker);
	
							        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							        map.setCenter(coords);
							    } 
							});    
							</script>
							<!-- Comment Area Start -->
							<div id="replyApp">
								<div class="comment_area section_padding_50 clearfix">
									<h4 class="mb-30">댓글</h4>
									<ol>
										<!-- Single Comment Area -->
										<li class="single_comment_area" v-for="vo in reply_list">
											<div class="comment-wrapper d-flex" v-if="vo.group_tab===0">
												<!-- Comment Meta -->
												<div class="comment-author">
													<img :src="vo.sex==='남자'?'../img/man.png':'../img/woman.png'" alt="">
												</div>
												<!-- Comment Content -->
												<div class="comment-content">
													<span class="comment-date text-muted">{{vo.dbday}}</span>
													<span :id="'modify'+vo.cno" v-if="vo.dbday!=vo.mday">&nbsp;수정된 날짜: {{vo.mday}}</span>
													<h5>{{vo.name}}</h5>
													<p>{{vo.msg}}</p>
													<button v-if="sessionId===vo.id" class="btn-xs btn-info update" style="margin-left: 2px"
														@click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">Update</button> 
													<button v-if="sessionId===vo.id" class="btn-xs btn-danger" style="margin-left: 2px" 
														@click="replyDelete(vo.cno)">Delete</button> 
													<button v-if="sessionId!==vo.id && sessionId!=''" class="btn-xs btn-success" style="margin-left: 2px">Like</button> 
													<button class="active btn-xs btn-secondary insert" v-if="sessionId!=''" style="margin-left: 2px" 
														@click="replyForm(vo.cno)" :id="'i'+vo.cno">Reply</button>
													<table class="table ins" style="display:none" :id="'in'+vo.cno">
														<tr>
															<td>
																<textarea rows="3" cols="50" style="float: left;" :id="'msg'+vo.cno"></textarea>
																<input type="button" value="댓글" 
																style="float: left; background-color: gray; color: white; width: 80px; height: 70px"
																@click="replyReplyInsert(vo.cno)">
															</td>
														</tr>
													</table>
													<table class="table ups" style="display:none" :id="'up'+vo.cno">
														<tr>
															<td>
																<textarea rows="4" cols="40" style="float: left;" :id="'umsg'+vo.cno">{{vo.msg}}</textarea>
																<input type="button" value="댓글" 
																style="float: left; background-color: gray; color: white; width: 80px; height: 94px"
																@click="replyUpdate(vo.cno)">
															</td>
														</tr>
													</table>
												</div>
											</div>
											
											<ol class="children" v-if="vo.group_tab===1">
												<li class="single_comment_area">
													<div class="comment-wrapper d-flex">
														<!-- Comment Meta -->
														<div class="comment-author">
															<img :src="vo.sex==='남자'?'../img/man.png':'../img/woman.png'" alt="">
														</div>
														<!-- Comment Content -->
														<div class="comment-content">
															<span class="comment-date text-muted">{{vo.dbday}}</span>
															<h5>{{vo.name}}</h5>
															<p>{{vo.msg}}</p>
															<button v-if="sessionId===vo.id" class="btn-xs btn-info" style="margin-left: 2px"
																@click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">Update</button> 
															<button v-if="sessionId===vo.id" class="btn-xs btn-danger" style="margin-left: 2px"
															@click="replyDelete(vo.cno)">Delete</button> 
															<button v-if="sessionId!==vo.id && sessionId!=''" class="btn-xs btn-success" style="margin-left: 2px">Like</button> 
															<table class="table ups" style="display:none" :id="'up'+vo.cno">
																<tr>
																	<td>
																		<textarea rows="4" cols="40" style="float: left;":id="'umsg'+vo.cno">{{vo.msg}}</textarea>
																		<input type="button" value="댓글" 
																		style="float: left; background-color: gray; color: white; width: 80px; height: 94px"
																		@click="replyUpdate(vo.cno)">
																	</td>
																</tr>
															</table>
														</div>
													</div>
												</li>
											</ol>
										</li>
									</ol>
								</div>
								<!-- Leave A Comment -->
								<c:if test="${sessionScope.userId!=null }">
									<div class="leave-comment-area section_padding_50 clearfix">
										<div class="comment-form">
											<table class="table">
												<tr>
													<td>
														<textarea rows="4" cols="70" style="float: left;" ref="msg" v-model="msg"></textarea>
														<input type="button" value="댓글" 
														style="float: left; background-color: gray; color: white; width: 80px; height: 94px"
														@click="replyInsert()">
													</td>
												</tr>
											</table>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		let replyApp=Vue.createApp({
			data(){
				return {
					rno:${fno},
					reply_list:[],
					curpage:1,
					totalpage:0,
					endPage:0,
					startPage:0,
					type:1,
					sessionId:'${sessionId}',
					msg:'',
					isReply:false,
					upReply:false
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
				replyUpdate(cno) {
					let msg = $('#umsg'+cno).val()
	                if(msg.trim() === "") {
						$('umsg'+cno).focus()
	                    return
	                }
	              axios.post('../comment/update_vue.do',null,{
		                 params: {
		                    cno : cno,
		                    rno : this.rno,
		                    type: this.type,
							msg : msg
						}
					}).then(response => {
						console.log(response.data)
						this.reply_list= response.data.list
						this.curpage = response.data.curpage
						this.totalpage = response.data.totalpage
						this.startPage = response.data.startPage
						this.endPage = response.data.endPage
				        const updatedComment = response.data.list.find(comment => comment.cno === cno);
				        if (updatedComment) {
				            // 수정된 날짜를 보여주는 방식
				            $('#modify' + cno).text(`수정된 날짜: ${updatedComment.mday}`);
				        }
						$('#umsg'+cno).val("")
						$('#up'+cno).hide()
						$('#u'+cno).text("Update")

		                  
					}).catch(error=>{
						console.log(error.response)
					})
				},
	            replyDelete(cno){
	                axios.get('../comment/delete_vue.do',{
	                   params:{
	                      cno:cno,
	                      rno:this.rno,
	                      type:this.type
	                   }
	                }).then(res=>{
	                   console.log(res.data)
	                   this.reply_list=res.data.list
	                   this.curpage=res.data.curpage
	                   this.totalpage=res.data.totalpage
	                   this.startPage=res.data.startPage
	                   this.endPage=res.data.endPage
	                }).catch(error=>{
	                   console.log(error.response)
	                })
	             },
				replyReplyInsert(cno){
					let msg=$('#msg'+cno).val()
					if(msg.trim()===""){
						$('#msg'+cno).focus()
						return 
					}
					axios.post('../comment/reply_insert_vue.do',null,{
						params:{
							rno:this.rno,
							type:this.type,
							msg:msg,
							cno:cno
						}
					}).then(res=>{
						console.log(res.data)
						this.reply_list=res.data.list
						this.curpage=res.data.curpage
						this.totalpage=res.data.totalpage
						this.startPage=res.data.startPage
						this.endPage=res.data.endPage
						$('#msg'+cno).val('')
						$('#in'+cno).hide()
						$('#i'+cno).text("Reply")
					}).catch(error=>{
						console.log(error.response)
					})
				},
				replyUpdateForm(cno){
					$('.ins').hide()
					$('.ups').hide()
					$('.update').text('Update')
					$('.insert').text('Reply')
					if(this.upReply===false){
						this.upReply=true
						$('#up'+cno).show()
						$('#u'+cno).text("Cancel")
					}else{
						this.upReply=false
						$('#up'+cno).hide()
						$('#u'+cno).text("Update")
					}
				},
				replyForm(cno){
					$('.ins').hide()
					$('.insert').text('Reply')
					if(this.isReply===false){
						this.isReply=true
						$('#in'+cno).show()
						$('#i'+cno).text("Cancel")
					}else{
						this.isReply=false
						$('#in'+cno).hide()
						$('#i'+cno).text("Reply")
					}
				},
				replyInsert(){
					if(this.msg===""){
						this.$refs.msg.focus()
						return
					}
					axios.post('../comment/insert_vue.do',null,{
						params:{
							rno:this.rno,
							type:this.type,
							msg:this.msg
						}
					}).then(res=>{
						console.log(res.data)
						this.reply_list=res.data.list
						this.curpage=res.data.curpage
						this.totalpage=res.data.totalpage
						this.startPage=res.data.startPage
						this.endPage=res.data.endPage
						this.msg=''
					}).catch(error=>{
						console.log(error.response)
					})
				},
				dataRecv(){
					axios.get('../comment/list_vue.do',{
						params:{
							rno:this.rno,
							type:this.type,
							page:this.curpage
						}
					}).then(res=>{
						console.log(res.data)
						this.reply_list=res.data.list
						this.curpage=res.data.curpage
						this.totalpage=res.data.totalpage
						this.startPage=res.data.startPage
						this.endPage=res.data.endPage
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#replyApp')
	</script>
</body>
</html>