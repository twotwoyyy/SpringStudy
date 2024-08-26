package com.sist.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	// Spring 4 => xml 기반 + Java (현재) => 실무에 가장 많이 사용
	// Spring 5 => Annotation Java 기반 => xml 없이 순수하게 자바만 사용
	// Spring 6 => 도메인 기반 => 컨트롤러를 나눠서 작업 
public class MainClass {
	public static void main(String[] args) {
		String[] xml= {"sawon.xml","member.xml"}; // 동시 파싱하려면 배열 잡기
		ApplicationContext app=
				new ClassPathXmlApplicationContext("my*xml"); // my로 시작하는 모든 xml을 가져오기
		Sawon sa=(Sawon)app.getBean("sa");
		sa.print();
		Member mem=(Member)app.getBean("mem");
		mem.print();
	}
}
