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
	width: 960px;
}
p {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.link:hover{
	cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3" v-for="vo in recipe_list">
				<div class="thumbnail">
					<a :href="'detail.do?no='+vo.no"> 
					<img :src="vo.poster" style="width: 230px; height: 150px">
						<div class="caption">
							<p>{{vo.title}}</p>
						</div>
					</a>
				</div>
			</div>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<li v-if="startPage>1"><a class="link" @click="prev()">&lt;</a></li>
					<li v-for="i in range(startPage,endPage)" :class="i==curpage?'active':''"><a class="link" @click="pageChange(i)">{{i}}</a></li>
					<li v-if="endPage<totalpage"><a class="link" @click="next()">&gt;</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script src="recipe_list.js"></script> 
</body>
</html>