package com.sist.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *	1. XML ���� => ���
 *	2. ���� => Annotation
 *  ===================== ����
 *	3. ��� => Container ���� 
 *      DI
 *      AOP
 *      MVC
 *      Transaction
 *      Security
 *      WebSocket
 *      Betch : �����ٷ� 
 *	=====================
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		sa.setSabun(5);
		sa.setName("������");
		sa.setDept("�ѹ���");
		sa.print();
		//System.out.println(sa);
		Sawon sa1=(Sawon)app.getBean("sa");
		sa1.print();
		//System.out.println(sa1);
		Sawon sa3=(Sawon)app.getBean("sa");
		sa3.print();
		//System.out.println(sa3);
		Sawon sa4=(Sawon)app.getBean("sa");
		sa4.print();
		//System.out.println(sa4);
		// �ϳ��� ��ü�� ����� �� �ְ� �Ѵ� => �̱��� (�ּҰ� ����)
		// setter �̿� (p:)=> �ʱ�ȭ
		// System.out.println(sa);
		sa.print();
		Sawon sa2=(Sawon)app.getBean("sa2");
		// ������ �̿� (c:) => �ʱ�ȭ
		sa2.print();
	}
}
