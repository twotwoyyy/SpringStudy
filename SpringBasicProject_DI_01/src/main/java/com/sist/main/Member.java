package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/*
 * 1. ��ü ���� => ����
 * 2. ��� ������ �ʱ�ȭ �Ŀ� ��ü ���� => ����
 *    = settXxx() => setter DI
 *    = ������      => constructor DI
 * <bean id="mem" class="com.sist.main.Mamber"> => ���� �߻� 
 * 
 *  class A{
 *  	private int a,b;
 *  	public A(int a, int b){
 *  		this.a=a;
 *  		this.b=b;
 *  	}
 *  }
 *  
 *  A a=new A(); => ���� => new A(10,20)
 */

public class Member {
	private int mno;
	private String name;
	private String sex;
	private String address;
	private String phone;
	
	// ��� �Ű������� ���� �ִ� ������ ���� @AllArgsConstructor
	public Member(int mno, String name, String sex, String address, String phone) {
		super();
		this.mno = mno;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}

	public void print() {
		System.out.println("ȸ�� ��ȣ : "+mno);
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+sex);
		System.out.println("�ּ� : "+address);
		System.out.println("�ڵ��� : "+phone);
	}
}	
