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
		System.out.println("메뉴 선택(이름 검색(1), 주소 검색(2), 음식 종류 검색(3) : ");
		int menu=scan.nextInt();
		String column="";
		if(menu==1) {
			column="name";
		}else if(menu==2) {
			column="address";
		}else if(menu==3) {
			column="type";
		}
		
		System.out.println("검색어 입력:");
		String fd=scan.next();
		
		Map map=new HashMap();
		map.put("column", column);
		map.put("fd", fd);
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml"); // 두 개 동시 로딩
		FoodDAO dao=app.getBean("foodDAO",FoodDAO.class);
		List<FoodVO> list=dao.foodFindData(map);
		for(FoodVO vo:list) {
			System.out.println("업체 번호:"+vo.getFno());
			System.out.println("업체명:"+vo.getName());
			System.out.println("음식 종류:"+vo.getType());
			System.out.println("주소:"+vo.getAddress());
			System.out.println("영업시간:"+vo.getTime());
			System.out.println("주차:"+vo.getParking());
			System.out.println("==========================");
			
		}
	}

}
