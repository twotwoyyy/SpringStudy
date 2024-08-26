package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass3 {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app3.xml");
		Board b=(Board)app.getBean("board");
		b.print();
		// »ý¼ºÀÚ => setXxx()
	}
}
