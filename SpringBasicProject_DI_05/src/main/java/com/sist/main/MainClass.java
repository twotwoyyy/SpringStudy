package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.BoardDAO;
import com.sist.manager.BoardManager;
import com.sist.model.BoardModel;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		BoardDAO dao=(BoardDAO)app.getBean("dao");
		dao.list();
		
		BoardManager bm=(BoardManager)app.getBean("bm");
		bm.manager();
		// ���̵� �������� �ʾ��� �� => �ڵ� ���� => Ŭ���� �̸��� ID�� �Ǳ� ������(���� �ҹ��ڰ� �ȴ�) ���� �ָ� X
		BoardModel model=(BoardModel)app.getBean("boardModel");
		model.model();
	}
}
