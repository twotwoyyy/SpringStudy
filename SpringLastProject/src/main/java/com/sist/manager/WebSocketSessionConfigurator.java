package com.sist.manager;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;
// HttpSession => 연결 
public class WebSocketSessionConfigurator extends Configurator{

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		HttpSession session=(HttpSession)request.getHttpSession();
		if(session!=null)
			sec.getUserProperties().put(HttpSession.class.getName(), session);
		// properties에 Session을 사용할 수 있게 저장 
	}
   
}