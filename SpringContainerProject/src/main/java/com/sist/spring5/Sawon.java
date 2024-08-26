package com.sist.spring5;

import lombok.Data;

@Data
public class Sawon {
	private int sabun;
	private String name;
	public void print() {
		System.out.println("사번: "+sabun);
		System.out.println("이름: "+name);
	}
}
