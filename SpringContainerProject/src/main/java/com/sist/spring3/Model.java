package com.sist.spring3;
// 공통 기반 => 모든 클래스가 동일한 기능 수행
public interface Model {
	public String execute();
	default public void write() {
		// 구현된 메소드 => 추상 클래스 사용이 거의 사라진다 jdk1.8부터 등장
		// 인터페이스 : 자바스크립트 (프로그램 언어 형식)
	}
}
