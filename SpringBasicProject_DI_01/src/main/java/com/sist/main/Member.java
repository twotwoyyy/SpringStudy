package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/*
 * 1. 객체 생성 => 관리
 * 2. 멤버 변수의 초기화 후에 객체 생성 => 관리
 *    = settXxx() => setter DI
 *    = 생성자      => constructor DI
 * <bean id="mem" class="com.sist.main.Mamber"> => 오류 발생 
 * 
 *  class A{
 *  	private int a,b;
 *  	public A(int a, int b){
 *  		this.a=a;
 *  		this.b=b;
 *  	}
 *  }
 *  
 *  A a=new A(); => 오류 => new A(10,20)
 */

public class Member {
	private int mno;
	private String name;
	private String sex;
	private String address;
	private String phone;
	
	// 모든 매개변수를 갖고 있는 생성자 생성 @AllArgsConstructor
	public Member(int mno, String name, String sex, String address, String phone) {
		super();
		this.mno = mno;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}

	public void print() {
		System.out.println("회원 번호 : "+mno);
		System.out.println("이름 : "+name);
		System.out.println("성별 : "+sex);
		System.out.println("주소 : "+address);
		System.out.println("핸드폰 : "+phone);
	}
}	
