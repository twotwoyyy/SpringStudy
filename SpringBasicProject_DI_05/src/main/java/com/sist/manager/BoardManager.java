package com.sist.manager;

import org.springframework.stereotype.Component;

@Component("bm")
public class BoardManager {
	public void manager() {
		System.out.println("외부 API 연결...");
	}
}
