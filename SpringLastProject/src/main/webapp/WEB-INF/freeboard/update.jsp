<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
				
					<div class="bradcumb-title text-center">
						<h2>수정하기</h2>
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
	<section class="single_blog_area section_padding_80" id="updateApp">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-lg-8">
					<div class="row no-gutters">
						<table class="table">
							<tr>
								<th class="text-center" width="15%">제목</th>
								<td width="85%">
									<input type="text" size="45" class="input-sm" ref="subject" v-model="subject">
								</td>
							</tr>
							<tr>
								<td class="text-center" width="15%">내용</td>
								<td width="85%">
									<textarea rows="10" cols="48" ref="content" v-model="content"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">
									<button class="btn-sm btn-success" @click="boardUpdate()">수정하기</button>
									<button class="btn-sm btn-danger" onclick="location.href='../freeboard/list.do'">취소</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		let updateApp=Vue.createApp({
			data(){
				return {
					no:${no},
					subject:'',
					content:''
				}
			},
			mounted(){
				
			},
			methods:{
				
			}
		}).mount('#updateApp')
	</script>
</body>
</html>