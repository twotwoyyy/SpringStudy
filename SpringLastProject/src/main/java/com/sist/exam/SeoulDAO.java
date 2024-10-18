package com.sist.exam;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;
public class SeoulDAO {
	private static SqlSessionFactory ssf;
	// <bean id="ssf" class="" p:dataSource-ref="ds">
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static List<SeoulVO> seoulListData(int start){
		List<SeoulVO> list=new ArrayList<SeoulVO>();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("seoulListData",start);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int seoulTotalPage() {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("seoulTotalPage");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
}
