package com.sist.spring4;

import lombok.Data;

@Data
public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	public Sawon() {}
	// ��� ������ �ʱ�ȭ => �޸� �Ҵ�  
	// �������� ���� : application.xml 
	public Sawon(int sabun,String name,String dept) {
		this.sabun=sabun;
		this.name=name;
		this.dept=dept; // ������ �̿� 
	}
	public void print() {
		System.out.println("���:"+sabun);
		System.out.println("�̸�:"+name);
		System.out.println("�μ�:"+dept);
	}
}
