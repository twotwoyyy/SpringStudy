package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
public class EmpDAO {
	private MyDataSource ds;
	private Connection conn;
	private PreparedStatement ps;
	
	@Autowired
	public EmpDAO(MyDataSource ds) {
		this.ds=ds;
		try {
			Class.forName(ds.getDriver());
		}catch(Exception ex) {}
	}
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
		}catch(Exception ex) {}
	}
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception ex) {}
	}
	
	// 기능 설정 
	// around => 시간 (수행 시간) => 트랜잭션 
	//           ============= log 파일 
	public List<EmpVO> empListData(){
		List<EmpVO> list=new ArrayList<EmpVO>();
		try {
			// getConnection() => AOP
			String sql="SELECT empno,ename,job,sal "
					+"FROM emp ORDER BY empno ASC";
			/*
			 * <select id="" resultType="EmpVO">
			 * 	SELECT... 
			 * </select>
			 */
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				list.add(vo);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
//		finally {
//			AOP => disConnection() => AFTER
//		}
		return list;
	}
	public EmpVO empDetailData(int empno) {
		EmpVO vo=new EmpVO();
		try {
			String sql="SELECT empno,ename,job,sal "
					+"FROM emp WHERE empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setSal(rs.getInt(4));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
}
