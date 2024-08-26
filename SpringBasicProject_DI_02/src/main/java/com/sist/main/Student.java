package com.sist.main;

import lombok.Data;

@Data
public class Student {
	private int hakbun;
	private String subject;
	private int kor,eng,math;
	private Human human=new Human();
	
	public void print() {
		System.out.println("학번:"+hakbun);
		System.out.println("이름:"+human.getName());
		System.out.println("성별:"+human.getSex());
		System.out.println("주소:"+human.getAddress());
		System.out.println("학과:"+subject);
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+math);
	}
}
