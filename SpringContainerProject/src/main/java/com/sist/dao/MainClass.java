package com.sist.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("db.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate()+" "
					+vo.getSal());
		}
	}
}
