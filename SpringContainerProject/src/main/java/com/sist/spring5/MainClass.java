package com.sist.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	// Spring 4 => xml ��� + Java (����) => �ǹ��� ���� ���� ���
	// Spring 5 => Annotation Java ��� => xml ���� �����ϰ� �ڹٸ� ���
	// Spring 6 => ������ ��� => ��Ʈ�ѷ��� ������ �۾� 
public class MainClass {
	public static void main(String[] args) {
		String[] xml= {"sawon.xml","member.xml"}; // ���� �Ľ��Ϸ��� �迭 ���
		ApplicationContext app=
				new ClassPathXmlApplicationContext("my*xml"); // my�� �����ϴ� ��� xml�� ��������
		Sawon sa=(Sawon)app.getBean("sa");
		sa.print();
		Member mem=(Member)app.getBean("mem");
		mem.print();
	}
}
