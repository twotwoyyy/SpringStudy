package com.sist.main2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// Spring 5 버전 => xml 없이 순수 자바로 코딩 
public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(MemberConfig.class);
		Member m=(Member)app.getBean("mem");
		m.print();
	}
}
