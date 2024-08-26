package com.sist.spring2;

public class HelloImp1 implements Hello{
/*
 * 인터페이스를 사용하면 본인 것만 영향을 준다. 
 */
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"님 로그인되었습니다");
	}

}
