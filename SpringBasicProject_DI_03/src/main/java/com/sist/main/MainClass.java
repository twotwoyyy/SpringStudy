package com.sist.main;

public class MainClass {
	public static void main(String[] args) {
		String path="C:\\SpringDev\\springStudy\\SpringBasicProject_DI_03\\src\\main\\java\\app.xml";
		ApplicationContext app=
				new ApplicationContext(path);
		Sawon sa1=(Sawon)app.getBean("sa1");
		System.out.println(sa1);
		Sawon sa2=(Sawon)app.getBean("sa2");
		System.out.println(sa2);
		Sawon sa3=(Sawon)app.getBean("sa3");
		System.out.println(sa3);
	}
}
