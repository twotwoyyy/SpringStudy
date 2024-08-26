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
		// 아이디가 지정되지 않았을 때 => 자동 지정 => 클래스 이름이 ID가 되기 때문에(앞이 소문자가 된다) 공백 주면 X
		BoardModel model=(BoardModel)app.getBean("boardModel");
		model.model();
	}
}
