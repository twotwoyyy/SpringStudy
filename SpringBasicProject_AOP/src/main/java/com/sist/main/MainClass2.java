package com.sist.main;
class My{
	public void execute() {
		System.out.println("Hello AOP");
	}
}
class MyTarget{
	private My my;
	public MyTarget(My my) {
		this.my=my;
	}
	// weaving => proxy 패턴 (대리자)
	public void execute() {
		my.execute();
		System.out.println("my.execute 실행");
	}
}
public class MainClass2 {
	public static void main(String[] args) {
		My m=new My();
		m.execute();
		MyTarget mm=new MyTarget(m);
		mm.execute();
	}
}
