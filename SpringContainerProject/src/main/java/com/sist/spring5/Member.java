package com.sist.spring5;

import lombok.Data;

@Data
public class Member {
	private int mno;
	private String name;
	
	public void print() {
		System.out.println("ȸ�� ��ȣ: "+mno);
		System.out.println("�̸�: "+name);
	}
}
