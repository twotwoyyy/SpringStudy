package com.sist.vo;
import javax.websocket.Session;

import lombok.Data;

@Data
public class ChatVO {
	private String userId;
	private String userName;
	private Session session;
}