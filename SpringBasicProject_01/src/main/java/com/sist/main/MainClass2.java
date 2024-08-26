package com.sist.main;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext app=
				new GenericXmlApplicationContext("app2.xml"); // 객체 생성
		Board b=(Board)app.getBean("board"); // 필요한 기능 호출
		b.list();
		b.insert();
		app.close(); // 객체 소멸 destory() 자동 호출
		// 컨테이너는 객체를 모아서 관리
		// 객체 생성 = setter = 개발자 사용 = 객체 소멸 
	}
}
