package com.sist.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		EmpDAO dao=app.getBean("dao",EmpDAO.class);
		// 제네릭스 이용
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday());
		}
	}
}
