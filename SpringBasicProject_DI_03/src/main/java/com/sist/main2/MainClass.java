package com.sist.main2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// Spring 5 ���� => xml ���� ���� �ڹٷ� �ڵ� 
public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(MemberConfig.class);
		Member m=(Member)app.getBean("mem");
		m.print();
	}
}
