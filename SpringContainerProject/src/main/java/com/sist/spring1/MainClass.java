package com.sist.spring1;

public class MainClass {
	public static void main(String[] args) {
		Hello hello=new Hello();
		//hello.aaa("홍길동"); // 한 개의 기능을 가지고 있다
		hello.sayHello("홍길동"); // 한 개의 기능을 가지고 있다
		// 결합성이 강한 프로그램
		// 수정시 => 다른 클래스에 영향
		// 가급적 new를 사용하지 않는다 (new를 사용하면 결합성이 높은 프로그램이 된다)
	}
}
