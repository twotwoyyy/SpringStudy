		const image_card={
			props:['list'],
			template:`<div class="col-md-3" v-for="vo in $parent.list">
				<div class="thumbnail">
					<a :href="'../recipe/detail.do?no='+vo.no"> 
					<img :src="vo.poster" style="width: 230px;height: 210px">
						<div class="caption">
							<p>{{vo.title}}</p>
						</div>
					</a>
				</div>
			</div>`
		}