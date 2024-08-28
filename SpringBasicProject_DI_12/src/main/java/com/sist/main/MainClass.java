package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {
	public static void main(String[] args) {
		// Spring �о�� �޴��� �κ� 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		FoodDAO dao=(FoodDAO)app.getBean("dao");
		
		Scanner scan=new Scanner(System.in);
		System.out.print("������ �Է�:");
		int page=scan.nextInt();
		
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		int totalpage=dao.foodTotalPage();
		List<FoodVO> list=dao.foodListData(start, end);
		for(FoodVO vo:list) {
			System.out.println("��ü ��ȣ:"+vo.getFno());
			System.out.println("��ü��:"+vo.getName());
			System.out.println("=====================");
		}
		System.out.println("======== "+page+" page "+totalpage+" pages =======");
		System.out.println("��ü ��ȣ �Է�:");
		int fno=scan.nextInt();
		FoodVO vo=dao.foodDetailData(fno);
		System.out.println("========= ��ü ���� =======");
		System.out.println("��ü ��ȣ:"+vo.getFno());
		System.out.println("��ü��:"+vo.getName());
		System.out.println("�ּ�:"+vo.getAddress());
		System.out.println("��ȭ:"+vo.getPhone());
		System.out.println("���� ����:"+vo.getType());
		System.out.println("���� �ð�:"+vo.getTime());
		System.out.println("����:"+vo.getParking());
		System.out.println("�׸�:"+vo.getTheme());
	}
}
