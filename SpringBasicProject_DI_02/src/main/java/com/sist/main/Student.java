package com.sist.main;

import lombok.Data;

@Data
public class Student {
	private int hakbun;
	private String subject;
	private int kor,eng,math;
	private Human human=new Human();
	
	public void print() {
		System.out.println("�й�:"+hakbun);
		System.out.println("�̸�:"+human.getName());
		System.out.println("����:"+human.getSex());
		System.out.println("�ּ�:"+human.getAddress());
		System.out.println("�а�:"+subject);
		System.out.println("����:"+kor);
		System.out.println("����:"+eng);
		System.out.println("����:"+math);
	}
}
