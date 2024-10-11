<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#chatArea {
		height: 450px;
		overflow-y:auto;
		border: 1px solid black; 
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket
let name
function connection(){
	// 서버 연결
	name=$('#name').val()
	if(name.trim()===""){
		$('#name').focus()
		return
	}
	websocket=new WebSocket("ws://localhost:8080/web/site/chat/chat-ws")
	websocket.onopen=onOpen
	websocket.onclose=onClose
	websocket.onmessage=onMessage
}
// => CallBack 함수 처리 
// 연결이 된 경우 
function onOpen(event){
	alert("채팅서버에 연결되었습니다!!")	
}
// 연결이 해제 된 경우
function onClose(event){
	alert("채팅서버에 연결이 종료 되었습니다!!")	
	
}
// 메시지가 정상으로 전송
function onMessage(event){
	// 서버에서 마시지 받은 경우	
}
// 
function appendMessage(msg){
	//div 출력 => 스크롤바 조절 
}
function send(){
	// 서버로 데이터 전송
}
$(function(){
	
})
</script>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="bradcumb-title text-center">
						<h2>실시간 채팅</h2>
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
						<table class="table">
							<tr>
								<td>
									<input type="text" class="input-sm" id="name" size="20">
									<input type="button" class="btn-sm btn-info" value="입장">
									<input type="button" class="btn-sm btn-danger" value="퇴장">
								</td>
							</tr>
							<tr>
								<td>
									<div id="chatArea">
										<div id="recvMsg"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<input type="text" id="sendMsg" class="input-sm" size="70">
									<input type="button" value="전송" class="btn btn-sm btn-primary">
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>