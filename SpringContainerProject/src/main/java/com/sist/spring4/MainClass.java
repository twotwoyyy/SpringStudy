package com.sist.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *	1. XML 사용법 => 등록
 *	2. 구분 => Annotation
 *  ===================== 사용법
 *	3. 기능 => Container 종류 
 *      DI
 *      AOP
 *      MVC
 *      Transaction
 *      Security
 *      WebSocket
 *      Betch : 스케줄러 
 *	=====================
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		sa.setSabun(5);
		sa.setName("강감찬");
		sa.setDept("총무부");
		sa.print();
		//System.out.println(sa);
		Sawon sa1=(Sawon)app.getBean("sa");
		sa1.print();
		//System.out.println(sa1);
		Sawon sa3=(Sawon)app.getBean("sa");
		sa3.print();
		//System.out.println(sa3);
		Sawon sa4=(Sawon)app.getBean("sa");
		sa4.print();
		//System.out.println(sa4);
		// 하나의 객체를 사용할 수 있게 한다 => 싱글턴 (주소가 같다)
		// setter 이용 (p:)=> 초기화
		// System.out.println(sa);
		sa.print();
		Sawon sa2=(Sawon)app.getBean("sa2");
		// 생성자 이용 (c:) => 초기화
		sa2.print();
	}
}
