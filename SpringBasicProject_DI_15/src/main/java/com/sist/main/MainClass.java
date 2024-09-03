package com.sist.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.*;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		
		Class[] cls= {MusicConfig.class,DataBaseConfig.class};
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(cls); // �� �� ���� �ε�
		MusicDAO dao=(MusicDAO)app.getBean("dao");
		List<MusicVO> list=dao.musicListData();
		for(MusicVO vo:list) {
			System.out.println(vo.getMno()+"."+vo.getTitle());
		}
		System.out.println("=====================");
		Scanner scan=new Scanner(System.in);
		System.out.print("1.��� �˻� 2.���� �˻� 3.�ٹ� �˻� : ");
		int no=scan.nextInt();
		System.out.println("�˻��� �Է� : ");
		String fd=scan.next();
//		List<MusicVO> fList=new ArrayList<MusicVO>();
//		if(no==1)
//			fList=dao.musicTitleFindData(fd);
//		else if(no==2)
//			fList=dao.musicSingerFindData(fd);
//		else if(no==3)
//			fList=dao.musicAlbumFindData(fd);
		
		List<MusicVO> fList=dao.musicFindData(no, fd);
		
		System.out.println("========= ��� ��� =========");
		for(MusicVO vo:fList) {
			System.out.println("���:"+vo.getTitle());
			System.out.println("������:"+vo.getSinger());
			System.out.println("�ٹ���:"+vo.getAlbum());
		}
	}

}
