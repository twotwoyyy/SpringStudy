package com.sist.main2;

import lombok.Data;

@Data
public class Member {
	private int mno;
	private String name;
	private String sex;
	
	public void print() {
		System.out.println("mno : "+mno);
		System.out.println("name : "+name);
		System.out.println("sex : "+sex);
	}
}
