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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
				
					<div class="bradcumb-title text-center">
						<h2>레시피 상세보기</h2>
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
	<section class="single_blog_area section_padding_80" id="detailApp">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-lg-8">
					<table class="table">
						<tr>
							<td class="text-center" colspan="3">
								<img :src="vo.poster" style="width: 800px; height: 300px">
							</td>
						</tr>
						<tr>
							<td class="text-center" colspan="3">
								<h3>{{vo.title}}</h3>
							</td>
						</tr>
						<tr>
							<td class="text-center" colspan="3">{{vo.content}}</td>
						</tr>
						<tr>
							<td class="text-center"><img src="a1.png"></td>
							<td class="text-center"><img src="a2.png"></td>
							<td class="text-center"><img src="a3.png"></td>
						</tr>
						<tr>
							<td class="text-center">{{vo.info1}}</td>
							<td class="text-center">{{vo.info2}}</td>
							<td class="text-center">{{vo.info3}}</td>
						</tr>
					</table>
					<h3>[재료]</h3>
					<table class="table">
						<tr>
							<td>
								<ul style="list-style-type: none">
									<li v-for="d in datas">{{d}}</li>
								</ul>
							</td>
						</tr>
					</table>
					<h3>[조리순서]</h3>
					<table class="table">
						<tr>
							<td>
								<table class="table" v-for="(m,index) in makes">
									<tr>
										<td width="80%" class="text-left">
											<h4 style="font-size: medium;">{{m}}</h4>
										</td>
										<td width="20%" class="text-right">
											<img :src="images[index]" style="width: 120px;height: 100px">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table class="table">
						<h3>[레시피 작성자]</h3>
						<table class="table">
							<tr>
								<td width="20%" class="text-center" rowspan="2">
									<img :src="vo.chef_poster" style="width: 100px;height: 100px; border-radius: 150px;">
								</td>
								<td width="80%" style="font-weight: bold;"><span style="font-size: 25px">{{vo.chef}}</span></td>
							</tr>
							<tr>
								<td width="80%">{{vo.chef_profile}}</td>
							</tr>
						</table>
					</table>
				</div>
			</div>
		</div>
	</section>
	<script>
		let detailApp=Vue.createApp({
			data(){
				return {
					vo:{},
					no:${no}, // no를 보내줄 값이 없으니 EL을 통해 받는다, 화면 바꿀 때 attribute로 no 보냈기에
					sessionId:'${sessionId}',
					makes:[],
					images:[]
				}
			},
			mounted(){
				axios.get('../recipe/detail_vue.do',{
					params:{
						no:this.no						
					}
				}).then(response=>{
					console.log(response.data)
					this.vo=response.data.vo
					this.makes=response.data.mList
					this.images=response.data.iList
					this.datas=response.data.vo.data.split(",")
				}).catch(error=>{
					console.log(error.response)
				})
			}
		}).mount('#detailApp')
	</script>
</body>
</html>