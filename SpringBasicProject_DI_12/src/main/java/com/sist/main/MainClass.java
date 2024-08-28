package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {
	public static void main(String[] args) {
		// Spring 읽어가는 메뉴얼 부분 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		FoodDAO dao=(FoodDAO)app.getBean("dao");
		
		Scanner scan=new Scanner(System.in);
		System.out.print("페이지 입력:");
		int page=scan.nextInt();
		
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		int totalpage=dao.foodTotalPage();
		List<FoodVO> list=dao.foodListData(start, end);
		for(FoodVO vo:list) {
			System.out.println("업체 번호:"+vo.getFno());
			System.out.println("업체명:"+vo.getName());
			System.out.println("=====================");
		}
		System.out.println("======== "+page+" page "+totalpage+" pages =======");
		System.out.println("업체 번호 입력:");
		int fno=scan.nextInt();
		FoodVO vo=dao.foodDetailData(fno);
		System.out.println("========= 업체 정보 =======");
		System.out.println("업체 번호:"+vo.getFno());
		System.out.println("업체명:"+vo.getName());
		System.out.println("주소:"+vo.getAddress());
		System.out.println("전화:"+vo.getPhone());
		System.out.println("음식 종류:"+vo.getType());
		System.out.println("영업 시간:"+vo.getTime());
		System.out.println("주차:"+vo.getParking());
		System.out.println("테마:"+vo.getTheme());
	}
}
