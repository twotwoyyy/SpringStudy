package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//  Ŭ���� ��� (�����̳�)
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
				//classPath : �ڵ� �ν��ϴ� ��ġ => src / main / java 
		Sawon sa1=(Sawon)app.getBean("sa1");
		sa1.print();
		System.out.println("============");
		//System.out.println("sa1="+sa1);
		Sawon sa2=(Sawon)app.getBean("sa2");
		sa2.print();
		System.out.println("============");
		//System.out.println("sa2="+sa2);
		Sawon sa3=(Sawon)app.getBean("sa3");
		sa3.print();
		//System.out.println("sa3="+sa3);
		/*
		 * 	======================
		 *    id         ��ü
		 * 	======================
		 *    sa1    new Sawon()
		 * 	======================
		 *    sa2    new Sawon()
		 *  ======================
		 *    sa3    new Sawon()
		 *  ======================
		 *  
		 *  
		 *  ==> Setter DI
		 */
	}
}
