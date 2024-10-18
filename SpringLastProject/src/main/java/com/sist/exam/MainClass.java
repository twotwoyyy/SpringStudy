package com.sist.exam;
import java.util.*;
import java.sql.*;
public class MainClass {

	public static void main(String[] args) {
		try {
			String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
			String user="root";
			String password="happy";
			String driver="com.mysql.cj.jdbc.Driver";
			
			Scanner scan=new Scanner(System.in);
			System.out.print("페이지 입력:");
			int page=scan.nextInt();
			
			int rowSize=10;
			int start=(rowSize*page)-rowSize; // 시작위치가 0부터임, 자바는 1 
			// 오라클 rownum=1, limit=0
			// mysql은 limit을 쓰면 된다
			
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,user,password);
			String sql="SELECT title FROM seoul_location ORDER BY no ASC LIMIT "+start+",10";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception ex) {}
	}

}
