package com.sist.main;

import lombok.Data;
// 1. setter DI => setXXX()�� �̿��ؼ� ��� ���� �ʱ�ȭ
// 2. ������ �̿��ϴ� ��� 
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
		System.out.println("���:"+sabun);
		System.out.println("�̸�:"+name);
		System.out.println("����:"+sex);
		System.out.println("�μ�:"+dept);
		System.out.println("����:"+job);
		System.out.println("�ٹ���:"+loc);
		System.out.println("����:"+pay);
	}
}
