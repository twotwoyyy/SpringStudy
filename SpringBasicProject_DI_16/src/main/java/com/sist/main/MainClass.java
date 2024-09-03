package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import com.sist.vo.*;

@Component("mc")
// MainClass�� ���������� ���� => �ʿ��� ���� �ݵ�� �������� ���ؼ� ��ü�� ���´�
// ���Ǹ� : MainClass mc=(MainClass)app.getBean("mc");
// new MainClass() => �������� ������ ���� => @Autowired�� ������� �ʴ´� 
public class MainClass {
	@Autowired
	private GoodsDAO dao;
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		//MainClass mc=new MainClass(); �̷��� �������� �ȵȴ� => �������� ���� ���� �����;� �Ѵ� new ���� �ȵ� 
		MainClass mc=(MainClass)app.getBean("mc");
		String[] tabs= {"","goods_all","goods_best","goods_new","goods_special"};
		Scanner scan=new Scanner(System.in);
		System.out.print("1.��ü ��ǰ 2.����Ʈ ��ǰ 3.�Ż�ǰ 4.Ư����ǰ");
		int cno=scan.nextInt();
		System.out.print("������ �Է�:");
		int page=scan.nextInt();
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		Map map=new HashMap();
		map.put("table_name", tabs[cno]);
		map.put("start", start);
		map.put("end", end);
		List<GoodsVO> list=mc.dao.goodsListData(map);
		int totalpage=mc.dao.goodsTotalPage(map);
		System.out.println(page+" page / "+totalpage+" pages");
		
		for(GoodsVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getGoods_name());
		}
		
		System.out.println("================================");
		System.out.print("�� �� ��ǰ ���� : ");
		int no=scan.nextInt();
		map.put("no", no);
		GoodsVO vo=mc.dao.goodsDetailData(map);
		System.out.println("��ǰ��ȣ:"+vo.getNo());
		System.out.println("��ǰ��:"+vo.getGoods_name());
		System.out.println("��ǰ����:"+vo.getGoods_price());
		System.out.println("��ǰ�Ұ�:"+vo.getGoods_sub());
		System.out.println("�̹���:"+vo.getGoods_poster());
	}
}
