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
.row {
	margin: 0px auto;
	width: 1000px;
}
p {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.movieTr:hover{
	cursor: pointer
}
</style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th>제목</th>
							<th>감독</th>
							<th>장르</th>
						</tr>
					</thead>
					<tbody>
					<%--
						vo={"rank":1,"movieMm":"aaa"}
							vo.rank
						class A {
							int rank;
							String movieNm;
						}
						
						vo로 시작하지 않는 속성은 :
					 --%>
						<tr v-for="vo in movie_list" class="movieTr" v-on:mouseover="detail_data(vo)">
							<td>{{vo.rank}}</td>
							<td>
								<img :src="'https://www.kobis.or.kr'+vo.thumbUrl" style="width: 35px; height: 35px">
							</td>
							<td>{{vo.movieNm}}</td>
							<td>{{vo.director}}</td>
							<td>{{vo.genre}}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-sm-5" v-show="isShow">
				<table class="table">
					<tr>
						<td width="30%" class="text-center" rowspan="7">
							<img :src="'https://www.kobis.or.kr'+movie_detail.thumbUrl" style="width: 100%">
						</td>
						<td colspan="2">
							<h3>{{movie_detail.movieNm}}</h3>
						</td>
					</tr>
					<tr>	
						<td width="20%">감독</td>
						<td width="50%">{{movie_detail.director}}</td>
					</tr>
					<tr>	
						<td width="20%">국가</td>
						<td width="50%">{{movie_detail.repNationCd}}</td>
					</tr>
					<tr>	
						<td width="20%">장르</td>
						<td width="50%">{{movie_detail.genre}}</td>
					</tr>
					<tr>	
						<td width="20%">등급</td>
						<td width="50%">{{movie_detail.watchGradeNm}}</td>
					</tr>
					<tr>	
						<td width="20%">개봉일</td>
						<td width="50%">{{movie_detail.startDate}}</td>
					</tr>
					<tr>	
						<td width="20%">줄거리</td>
						<td width="50%">{{movie_detail.synop}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<!--<script>
	let movieApp=Vue.createApp({
			data(){
				return {
					// 멤버 변수 => HTML에 출력할 데이터 
					movie_list:[{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20239670","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/08/thumb/thn_886a61eb398d4cedb346d9ffbf3345c3.jpg","movieNm":"베테랑2","movieNmEn":"I, THE EXECUTIONER","synop":"가족들도 못 챙기고 밤낮없이 범죄들과 싸우는 베테랑 형사 '서도철'(황정민)과 강력범죄수사대 형사들.\r\n\r\n어느 날, 한 교수의 죽음이 이전에 발생했던 살인 사건들과 연관성이 있는 것으로 밝혀지며 전국은 연쇄살인범으로 인해 떠들썩해진다. 이에 단서를 추적하며 수사를 시작한 형사들. 하지만 이들을 비웃기라도 하듯, 연쇄살인범은 다음 살인 대상을 지목하는 예고편을 인터넷에 공개하며 또 한 번 전 국민을 흔들어 놓는다.\r\n\r\n강력범죄수사대는 서도철의 눈에 든 정의감 넘치는 막내 형사 '박선우' (정해인)를 투입한다. 그리고 사건은 새로운 방향으로 흐르게 되는데...","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"118","showTs":"3","director":"류승완","prNm":"(주)외유내강","dtNm":"(주)씨제이이엔엠","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"액션,범죄","watchGradeNm":"15세이상관람가","openDt":"20240913","salesAmt":7128022589,"audiCnt":738641,"totalSalesAmt":43349419948,"totalAudiCnt":4453525,"scrCnt":2647,"showCnt":13139,"rank":1,"rankInten":0,"rankOldAndNew":"OLD","rownum":1},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20249733","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/07/thumb/thn_802e82bdf0af47fcbdab6d012aeac2bb.jpg","movieNm":"사랑의 하츄핑","movieNmEn":"Heartsping : Teenieping of Love","synop":"처음 본 순간, 한눈에 반해버렸어!\r\n설레는 운명이 시작된 우리의 첫 만남!\r\n\r\n인생의 소울메이트를 꼭 만나길 바라는 ‘로미’\r\n우연한 기회에 ‘하츄핑’을 처음 본 뒤, 운명의 인연임을 알아본다.\r\n'로미'는 ‘하츄핑’을 찾기 위해 반대를 무릅쓰고 새로운 길을 떠나지만,\r\n마침내 만나게 된 ‘하츄핑’은 인간과의 소통을 거부하는데…","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"86","showTs":"0","director":"김수훈","prNm":"(주)에스에이엠지엔터테인먼트","dtNm":"(주)쇼박스","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20240807","salesAmt":258476280,"audiCnt":32769,"totalSalesAmt":9527570482,"totalAudiCnt":1067322,"scrCnt":495,"showCnt":712,"rank":2,"rankInten":0,"rankOldAndNew":"OLD","rownum":2},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20242495","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/08/thumb/thn_69cc8f7d467a494da38e044385137166.jpg","movieNm":"브레드이발소: 빵스타의 탄생","movieNmEn":"Bread Barbershop: The Birth Of The Bread Star","synop":"천재 이발사 ‘브레드’와 사고뭉치 조수 ‘윌크’는 물론 ‘초코’와 ‘소시지’까지, 최고의 빵스타로 돌아온 친구들의 신나는 일상을 그린 애니메이션","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"76","showTs":"42","director":"정지환","prNm":"㈜브레드이발소","dtNm":"씨제이 씨지브이(CJ CGV)(주)","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20240914","salesAmt":286027600,"audiCnt":32234,"totalSalesAmt":1254279500,"totalAudiCnt":142608,"scrCnt":351,"showCnt":796,"rank":3,"rankInten":0,"rankOldAndNew":"OLD","rownum":3},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20149629","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/08/thumb/thn_96c00bb07a5e44dbbb5520aaeadaa0cc.jpg","movieNm":"비긴 어게인","movieNmEn":"Begin Again","synop":"“다시 시작해, 너를 빛나게 할 노래를!”\r\n\r\n싱어송라이터인 ‘그레타’(키이라 나이틀리)는 \r\n남자친구 ‘데이브’(애덤 리바인)가 메이저 음반회사와 계약을 하게 되면서 뉴욕으로 오게 된다. \r\n그러나 행복도 잠시, 오랜 연인이자 음악적 파트너로서 함께 노래를 만들고 부르는 것이 좋았던 그레타와 달리 \r\n스타가 된 데이브의 마음은 어느새 변해버린다. \r\n\r\n스타 음반프로듀서였지만 이제는 해고된 ‘댄’(마크 러팔로)은 \r\n미치기 일보직전 들른 뮤직바에서 그레타의 자작곡을 듣게 되고 아직 녹슬지 않은 촉을 살려 음반제작을 제안한다. \r\n거리 밴드를 결성한 그들은 뉴욕의 거리를 스튜디오 삼아 진짜로 부르고 싶었던 노래를 만들어가는데…","prdtYear":"2013","indieYn":null,"artmovieYn":"Y","multmovieYn":null,"showTm":"103","showTs":"58","director":"존 카니","prNm":null,"dtNm":"판씨네마(주)","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"멜로/로맨스","watchGradeNm":"15세이상관람가","openDt":"20140813","salesAmt":191302340,"audiCnt":19650,"totalSalesAmt":27660348471,"totalAudiCnt":3502420,"scrCnt":353,"showCnt":472,"rank":4,"rankInten":21,"rankOldAndNew":"OLD","rownum":4},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20243721","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/08/thumb/thn_c28d43cbf6e54af9b816633b50f1c313.jpg","movieNm":"정국: 아이 엠 스틸","movieNmEn":"JUNG KOOK: I AM STILL","synop":"‘21세기 팝 아티스트' 방탄소년단의 정국,\r\n그가 2023년 7월, 첫 솔로 싱글 ‘Seven(feat. Latto)’을 발표하며 ‘글로벌 팝스타'로 거듭났다.\r\n\r\n- ‘Seven’, 아시아 솔로 아티스트 최초 빌보드 HOT 100, Global 200, Global 200 Excl. US 1위 올킬\r\n- ‘Seven’ 스포티파이 역사상 최단기간 10억 스트리밍 달성\r\n- ‘Seven’, ‘3D (feat. Jack Harlow)’, ‘Standing Next to You’...빌보드 HOT 100 10위권에 3곡을 올린 유일한 K-팝 솔로 가수\r\n- ‘GOLDEN’ 빌보드 200서 24주 연속 진입…K-팝 솔로 앨범 최장기 차트인!\r\n\r\nSeven, 3D, Standing Next to You를 연달아 히트시키며\r\n2020년대를 대표하는 남성 솔로 가수로 자리매김한 정국.\r\n\r\n‘K-팝 솔로 최초’, ‘유일무이’ 등 각종 수식어가 따라오는 정국이지만\r\n아미(ARMY)에게 부끄럽지 않은 자랑스러운 아티스트가 되기 위해 끊임없이 노력하고 성장한다.\r\n\r\n“저는 제 나침반 보고 갑니다”\r\n\r\n타고난 재능, 그 속의 빛나는 노력으로 자신만의 길을 나아가는 아티스트 정국.\r\n그의 첫 솔로 싱글부터 GOLDEN 앨범 활동기까지\r\n뉴욕, 런던, 서울 등 세계 각지를 누비며 진행된 약 8개월간의 ‘황금빛 순간’.\r\n그간 보지 못했던 미공개 인터뷰와 비하인드,\r\n그리고 전 세계 224개 국가/지역의 팬들과 온오프라인에서 함께했던\r\n‘Jung Kook ‘GOLDEN’ Live On Stage’ 그날의 현장으로!\r\n\r\n여전히 하고 싶은 것도, 보여줄 것도 많은 정국의 이야기\r\n","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"93","showTs":"34","director":"박준수","prNm":"(주)하이브","dtNm":"CGV ICECON","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"공연","watchGradeNm":"전체관람가","openDt":"20240918","salesAmt":296657500,"audiCnt":11867,"totalSalesAmt":302338500,"totalAudiCnt":12114,"scrCnt":94,"showCnt":380,"rank":5,"rankInten":-5,"rankOldAndNew":"NEW","rownum":5},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20242541","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/08/thumb/thn_f98bc75622c1428f8fc1ef8403f22bc3.jpg","movieNm":"룩백","movieNmEn":"Look Back","synop":"“만화를 그려서 다행이라고 생각해”\r\n그림에 대한 자신감으로 가득한 ‘후지노’ \r\n\r\n“세상에 나와서 다행이라고 생각해”\r\n세상과의 단절 속에 그림만이 전부였던 ‘쿄모토’ \r\n\r\n만화를 향한 한결 같은 마음으로\r\n잊지 못할 사계절을 함께한 두 소녀의 아름다운 우정 이야기가 시작된다! ","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"57","showTs":"14","director":"오시야마 키요타카","prNm":null,"dtNm":"메가박스중앙(주)","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20240905","salesAmt":110040180,"audiCnt":11430,"totalSalesAmt":1586922844,"totalAudiCnt":165959,"scrCnt":231,"showCnt":504,"rank":6,"rankInten":-1,"rankOldAndNew":"OLD","rownum":6},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20249188","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/08/thumb/thn_32c84ebea97c4f48b52515ebf6e81aec.jpg","movieNm":"에이리언: 로물루스","movieNmEn":"Alien: Romulus","synop":"영화 역사상 가장 위대한 시리즈 <에이리언>\r\n리들리 스콧 제작 · <맨 인 더 다크> 페데 알바레즈 감독의 숨 막히는 서바이벌 스릴러로 돌아오다!\r\n\r\n2142년, 부모 세대가 맞닥뜨렸던 암울한 미래를 피하려는 청년들이 더 나은 삶을 찾기 위해 식민지를 떠날 계획을 세운다. \r\n하지만 버려진 우주 기지 ‘로물루스’에 도착한 이들은 악몽과도 같은 에이리언의 무자비한 공격에 쫓기기 시작한다. \r\n그 누구도 그들의 절규를 들을 수 없는 우주 한가운데, 생존을 위한 치열한 사투를 벌여야 하는데...\r\n\r\n폐쇄된 공간에서 펼쳐지는 압도적인 공포를 느껴라!\r\n","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"118","showTs":"51","director":"페데 알바레즈","prNm":null,"dtNm":"월트디즈니컴퍼니코리아 유한책임회사","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"공포(호러),SF","watchGradeNm":"15세이상관람가","openDt":"20240814","salesAmt":107670820,"audiCnt":10493,"totalSalesAmt":19963007060,"totalAudiCnt":1954418,"scrCnt":343,"showCnt":446,"rank":7,"rankInten":-3,"rankOldAndNew":"OLD","rownum":7},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20242794","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/07/thumb/thn_4cc5fdaed5534f5b90e54828e49eb726.jpg","movieNm":"임영웅│아임 히어로 더 스타디움","movieNmEn":"LIM YOUNG WOONG│IM HERO THE STADIUM","synop":"10만 영웅시대와 함께 상암벌을 정복한 임영웅의 스타디움 입성기!\r\n\r\n“영웅시대가 저와 별의 이야기를 함께 써 내려가고 있다고 생각해요”\r\n\r\n2024년 5월, 서울월드컵경기장에서 양일 10만 명의 관객을 동원하며\r\n콘서트 안팎으로 폭발적인 화제를 일으켰던 임영웅의 콘서트를 극장에서 다시 만난다.\r\n\r\n무대 위 압도적인 가창력과 다채로운 퍼포먼스,\r\n새로운 도전을 마다 않는 무대 뒤의 열정적인 모습과 영웅시대를 향한 진솔한 마음,\r\n그리고 최고의 공연을 위해 임영웅과 제작진 모두가 합심해 달려온 1년여의 기록까지,\r\n초대형 IMAX와 ScreenX로 풍성하게 담았다!\r\n\r\n영웅시대와 함께 더 큰 꿈을 꾸는 가수 임영웅의 하늘빛 축제가 스크린에서 펼쳐진다!","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"108","showTs":"22","director":"조우영,정현철","prNm":"(주)씨제이이엔엠","dtNm":"CGV ICECON,씨제이포디플렉스 주식회사","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"공연,다큐멘터리","watchGradeNm":"전체관람가","openDt":"20240828","salesAmt":228673500,"audiCnt":8853,"totalSalesAmt":8044439500,"totalAudiCnt":283235,"scrCnt":98,"showCnt":176,"rank":8,"rankInten":0,"rankOldAndNew":"OLD","rownum":8},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20243824","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/09/thumb/thn_0a7fdcd18df74b938806826d04fc7d7c.jpg","movieNm":"오지: 사라진 숲을 찾아서","movieNmEn":"Ozi: Voice of the Forest","synop":"안녕, 팔로워들?\r\n세계 최초! 인플루언서 오랑우탄의 등장!\r\n\r\n부모와 함께 살던 고향 숲이 파괴되고\r\n인간 ‘키라니‘의 손에 길러진 오랑우탄 ‘오지‘\r\n\r\n‘키라니’로부터 수화를 배우고,\r\n미디어로 대중과 소통하며 전세계 최초, 인플루언서 오랑우탄이 된다\r\n\r\n그런 ‘오지‘를 탐내는 개발 전문 기업 ‘그린자‘는 \r\n그녀의 환심을 사기 위해 태블릿을 보내오고,\r\n‘오지‘는 태블릿 안에서 어릴 적 헤어진 부모님의 사진을 발견한다\r\n\r\n그들을 찾기 위해 원숭이 ‘찬스‘와 함께 모험을 떠나게 된 ‘오지‘\r\n긴 여행 속에서 ‘오지‘는 생태계를 파괴하는 ‘그린자‘의 횡포를 목격하고,\r\n그들을 막기 위한 작전을 시작하는데…\r\n\r\n천재 오랑우탄 ‘오지‘!\r\n전 세계 팔로워들과 힘을 합쳐 자연을 구하라!\r\n환경을 지키기 위한 초대형 라이브 방송이 시작된다!\r\n","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"86","showTs":"47","director":null,"prNm":null,"dtNm":"(주)팝엔터테인먼트,(주)플레이그램","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20240913","salesAmt":62643850,"audiCnt":7067,"totalSalesAmt":283131575,"totalAudiCnt":35480,"scrCnt":201,"showCnt":304,"rank":9,"rankInten":1,"rankOldAndNew":"OLD","rownum":9},{"startYearDate":"2024.09.18","endYearDate":"2024.09.18","startDate":"2024년 09월 18일(수)","endDate":"2024년 09월 18일(수)","movieCd":"20240925","showDt":"20240918","thumbUrl":"/common/mast/movie/2024/09/thumb/thn_2e941900f0fd4b788e6af381b38ebbcb.jpg","movieNm":"안녕, 할부지","movieNmEn":"My Dearest Fu Bao","synop":"선물로 찾아온 만남, 예정된 이별\r\n\r\n푸바오의 중국 귀환 일정이 결정되고,\r\n사랑하는 이들의 아쉬움이 커져만 간다\r\n\r\n마침내 다가온 이별의 순간,\r\n푸바오의 행복을 위해 애써 담담해 보였던\r\n강바오와 송바오 역시 흔들리기 시작하는데…\r\n\r\n헤어질 때를 알기에 매 순간 진심이고 애틋했던 그들\r\n1354일, 그동안의 못다 한 이야기\r\n\r\n안녕, 그리고 안녕…","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"94","showTs":"32","director":"심형준,토마스 고","prNm":"(주)에이컴즈","dtNm":"(주)바른손이앤에이","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"다큐멘터리,애니메이션","watchGradeNm":"전체관람가","openDt":"20240904","salesAmt":62574600,"audiCnt":6830,"totalSalesAmt":2087735259,"totalAudiCnt":224700,"scrCnt":274,"showCnt":335,"rank":10,"rankInten":-4,"rankOldAndNew":"OLD","rownum":10}],
					movie_detail:{},
					isShow:false
				}
			},
			mounted(){
				// 서버에서 값을 읽어서 멤버 변수 초기화 axios
				// 다른 라이브러리 연동 => Jquery 라이브러리 연동 / 지도 출력 
			},
			methods:{
				// 사용자 정의 => 이벤트 (페이지 나누기) => 상세보기 / 읽기 
				detail_data(vo){
					this.isShow=true
					this.movie_detail=vo
				}
			}
		}).mount('.container') 
	</script>-->
	<script src="js/movie.js"></script>
</body>
</html>