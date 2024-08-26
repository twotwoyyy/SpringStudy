package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.*;
/*
 *  Spring 
 *  ====== Web 라이브러리
 *    |
 *  클래스 관리 => 메모리 관리 용이 (생성 = 소멸)
 *              결합성이 낮은 프로그램 => 다른 클래스에 영향을 미치지 않는다 
 *              ============================================
 *               | 유지 보수 
 *              => 상속이 없다 
 *                 === 상속 내리는 클래스에 맞게 소스 코딩 
 *                     ===> 스프링에서는 상속 받는 일이 극히 드물다 
 *                     ===> POJO (2.5부터)
 *                     ===> 컨테이너 : 경량 / 클래스화 
 *                          =====
 *                           툴형식 => 웹 로직 / 웹 스퀘어 / 제우스 => 유료 
 *                     학교 / 은행 / 공기업 / 대기업 => 스프링 
 *                     ======================= 유지보수 (차세대 개발)
 *  1. 프로젝트에 맞는 클래스 제작
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
