package com.sist.spring5;

import lombok.Data;

@Data
public class Member {
	private int mno;
	private String name;
	
	public void print() {
		System.out.println("회원 번호: "+mno);
		System.out.println("이름: "+name);
	}
}
