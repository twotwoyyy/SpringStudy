package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("�޴� ����(�̸� �˻�(1), �ּ� �˻�(2), ���� ���� �˻�(3) : ");
		int menu=scan.nextInt();
		String column="";
		if(menu==1) {
			column="name";
		}else if(menu==2) {
			column="address";
		}else if(menu==3) {
			column="type";
		}
		
		System.out.println("�˻��� �Է�:");
		String fd=scan.next();
		
		Map map=new HashMap();
		map.put("column", column);
		map.put("fd", fd);
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml"); // �� �� ���� �ε�
		FoodDAO dao=app.getBean("foodDAO",FoodDAO.class);
		List<FoodVO> list=dao.foodFindData(map);
		for(FoodVO vo:list) {
			System.out.println("��ü ��ȣ:"+vo.getFno());
			System.out.println("��ü��:"+vo.getName());
			System.out.println("���� ����:"+vo.getType());
			System.out.println("�ּ�:"+vo.getAddress());
			System.out.println("�����ð�:"+vo.getTime());
			System.out.println("����:"+vo.getParking());
			System.out.println("==========================");
			
		}
	}

}
