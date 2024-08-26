package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		Member mem1=(Member)app.getBean("mem1");
		mem1.print();
		Member mem2=(Member)app.getBean("mem2");
		mem2.print();
		Member mem3=(Member)app.getBean("mem3");
		mem3.print();
		Member mem4=(Member)app.getBean("mem4");
		mem4.print();
	}
}
