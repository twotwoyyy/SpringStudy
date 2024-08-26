package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.main.*;
/*
 * 1. xml => �޸� �Ҵ� <bean>:class 1�� ���, <context:component-scan>:package ���� ��� 
 * 
 * 2. �޸� �Ҵ��ϴ� ������̼�
 *               @Component
 *               @Repository
 *               @Service
 *               @Controller
 *               @RestController
 * 3. �ּҰ� ����
 *    @Autowired
 *    @Resource
 *    @Qualifier
 *    
 * 4. AOP 
 *    @Before
 *    @After
 *    @Around
 *    @After-Returning
 *    @After-Throwing
 */
@Component("mc")
public class MainClass {
	@Autowired
	private EmpDAO eDao;
	@Autowired
	private DeptDAO dDao;
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<EmpVO> eList=mc.eDao.empListData();
		List<DeptVO> dList=mc.dDao.deptListData();
		
		for(EmpVO vo:eList) {
			System.out.println(vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday());
		}
		System.out.println("====================");
		for(DeptVO vo:dList) {
			System.out.println(vo.getDeptno()+" "
					+vo.getDname()+" "
					+vo.getLoc()+" ");
		}
	}

}
