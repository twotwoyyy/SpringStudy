package com.sist.spring5;

import lombok.Data;

@Data
public class Sawon {
	private int sabun;
	private String name;
	public void print() {
		System.out.println("���: "+sabun);
		System.out.println("�̸�: "+name);
	}
}
