package com.sist.main;

import lombok.Data;
// 1. setter DI => setXXX()를 이용해서 멤버 변수 초기화
// 2. 생성자 이용하는 방식 
@Data
public class Sawon {
	private int sabun;
	private String name;
	private String sex;
	private String dept;
	private String job;
	private String loc;
	private int pay;
	
	public void print() {
		System.out.println("사번:"+sabun);
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("부서:"+dept);
		System.out.println("직위:"+job);
		System.out.println("근무지:"+loc);
		System.out.println("연봉:"+pay);
	}
}
