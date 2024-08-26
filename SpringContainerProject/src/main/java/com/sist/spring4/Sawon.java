package com.sist.spring4;

import lombok.Data;

@Data
public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	public Sawon() {}
	// 멤버 변수의 초기화 => 메모리 할당  
	// 스프링과 연동 : application.xml 
	public Sawon(int sabun,String name,String dept) {
		this.sabun=sabun;
		this.name=name;
		this.dept=dept; // 생성자 이용 
	}
	public void print() {
		System.out.println("사번:"+sabun);
		System.out.println("이름:"+name);
		System.out.println("부서:"+dept);
	}
}
