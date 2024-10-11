<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.nav-link {
	cursor: pointer;
}
.a{
	white-space: nowrap;
	overflow:hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>쉐프 목록</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">레시피</li>
                            <li class="breadcrumb-item active" aria-current="page">쉐프 목록</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
<section class="archive-area section_padding_80" id="listApp">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <table class="table">
                    <tr>
                        <td>
                            <table class="table" v-for="vo in chef_list" :key="vo.chef">
                                <tr>
                                    <td width="30%" class="text-center" rowspan="2">
                                        <img :src="vo.poster" style="width: 120px; height: 100px" class="img-circle nav-link"
                                             @click="detail(vo.chef)">
                                    </td>
                                    <td colspan="4">
                                        <h3 style="color: orange" class="nav-link" @click="detail(vo.chef)">{{ vo.chef }}</h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center"><img src="../img/m1.png">{{ vo.mem_cont1 }}</td>
                                    <td class="text-center"><img src="../img/m2.png">{{ vo.mem_cont3 }}</td>
                                    <td class="text-center"><img src="../img/m3.png">{{ vo.mem_cont7 }}</td>
                                    <td class="text-center"><img src="../img/m4.png">{{ vo.mem_cont2 }}</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="col-sm-6">
                <chef-list v-show="isShow" :r_list="recipe_list"></chef-list>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 text-center">
                <ul class="pagination">
                    <li><a class="nav-link" @click="prev()">&lt;</a></li>
                    <li v-for="i in range(startPage, endPage)" :class="{ active: i === curpage }">
                        <a class="nav-link" @click="pageChange(i)">{{ i }}</a>
                    </li>
                    <li><a class="nav-link" @click="next()">&gt;</a></li>
                </ul>
            </div>
        </div>
    </div>
</section>

    <script>
    	const detailComponent={
    		props:["r_list"],
    		template:`
    			<div class="row">
					<div class="col-md-3" v-for="vo in r_list">
						<div class="thumbnail">
							<a href="#" >
							<img :src="vo.poster" style="width:100%">
								<div class="caption">
									<p class="a">{{vo.title}}</p>
								</div>
							</a>
						</div>
					</div>
				</div>
    		`
    	}
    	let chefApp=Vue.createApp({
    		data(){
    			return {
    				chef_list:[],
    				curpage:1,
    				totalpage:0,
    				endPage:0,
    				startPage:0,
    				chef:'',
    				recipe_list:[],
    				isShow:false
    			}
    		},
    		mounted(){
    			this.dataRecv()
    		},
    		methods:{
    			detail(chef){
    				this.chef=chef
    				this.isShow=true
    				//alert(this.chef)
    				axios.get('../chef/recipe_make.do',{
    					params:{
    						chef:this.chef
    					}
    				}).then(res=>{
    					console.log(res.data)
    					this.recipe_list=res.data
    				}).catch(error=>{
    					console.log(error.response)
    				})
    			},
    			prev(){
    				this.curpage=this.startPage-1
    				this.dataRecv()
    			},
    			next(){
    				this.curpage=this.endPage+1  				
    				this.dataRecv()
    			},
    			pageChange(page){
    				this.curpage=page
    				this.dataRecv()
    			},
    			range(start,end){
    				let arr=[]
    				let len=end-start
    				for(let i=0;i<=len;i++){
    					arr[i]=start
    					start++
    				}
    				return arr
    			},
    			dataRecv(){
    				axios.get('../chef/list_vue.do',{
    					params:{
    						page:this.curpage
    					}
    				}).then(res=>{
    					console.log(res.data)
    					this.chef_list=res.data.list
    					this.curpage=res.data.curpage
    					this.totalpage=res.data.totalpage
    					this.startPage=res.data.startPage
    					this.endPage=res.data.endPage
    				}).catch(error=>{
    					console.log(error.response)
    				})
    			}
    		},
    		components:{
    			'chef-list':detailComponent
    		}
    	}).mount('#listApp')
    </script>
</body>
</html>