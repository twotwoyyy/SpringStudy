package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.*;
/*
 *  Spring 
 *  ====== Web ���̺귯��
 *    |
 *  Ŭ���� ���� => �޸� ���� ���� (���� = �Ҹ�)
 *              ���ռ��� ���� ���α׷� => �ٸ� Ŭ������ ������ ��ġ�� �ʴ´� 
 *              ============================================
 *               | ���� ���� 
 *              => ����� ���� 
 *                 === ��� ������ Ŭ������ �°� �ҽ� �ڵ� 
 *                     ===> ������������ ��� �޴� ���� ���� �幰�� 
 *                     ===> POJO (2.5����)
 *                     ===> �����̳� : �淮 / Ŭ����ȭ 
 *                          =====
 *                           ������ => �� ���� / �� ������ / ���콺 => ���� 
 *                     �б� / ���� / ����� / ���� => ������ 
 *                     ======================= �������� (������ ����)
 *  1. ������Ʈ�� �´� Ŭ���� ����
 *  2. 
 *                     
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		BoardModel bModel=(BoardModel)app.getBean("board");
		bModel.list();
		MemberModel memModel=(MemberModel)app.getBean("member");
		memModel.list();
		MainModel mainModel=(MainModel)app.getBean("main");
		mainModel.list();
		FoodModel fModel=(FoodModel)app.getBean("food");
		fModel.list();
		RecipeModel rModel=(RecipeModel)app.getBean("recipe");
		rModel.list();
	}
}
