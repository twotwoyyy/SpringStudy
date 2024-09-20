		let recipeApp=Vue.createApp({
			data(){
				return {
					recipe_list:[],
					curpage:1,
					startPage:0,
					totalpage:0,
					endPage:0
				}
			},
			mounted(){
				// onload => 브라우저에 화면이 보이기 전 
				// 서버 연결
				this.dataRecv()
			},
			methods:{
				// 사용자 정의 함수
				pageChange(page){
					this.curpage=page
					this.dataRecv()
				},
				prev(){
					this.curpage=this.startPage-1
					this.dataRecv()
				},
				next(){
					this.curpage=this.endPage+1
					this.dataRecv()
				},
				dataRecv(){
					axios.get('http://localhost:8080/web/recipe/list_vue.do',{
	
						params:{
							page:this.curpage
						}
					}).then(response=>{
						// 결과값 받는 곳 => response.data
						console.log(response.data)
						this.recipe_list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.startPage=response.data.startPage
						this.endPage=response.data.endPage
					})
				},
				// 페이징네이션 => 범위가 없기 때문에 만들어야 한다
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0;i<=len;i++){
						arr[i]=start
						start++
					}
					return arr
				}
			}
		}).mount('.container')