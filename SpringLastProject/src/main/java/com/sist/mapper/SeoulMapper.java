package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;
public interface SeoulMapper {
	@Select("SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title,rownum as num "
			+ "FROM (SELECT no,poster,title "
			+ "FROM project_seoul_location ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulLocationListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_seoul_location")
	public int seoulLocationTotalPage();

	@Select("SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title,rownum as num "
			+ "FROM (SELECT no,poster,title "
			+ "FROM project_seoul_nature ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulNatureListData(Map map);  
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_seoul_nature")   
	public int seoulNatureTotalPage();
	  
	/*@Select("SELECT no,poster,title,num "  
			+ "FROM (SELECT no,poster,title,rownum as num "
			+ "FROM (SELECT no,poster,title "
			+ "FROM project_seoul_shop ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}") 
	public List<SeoulVO> seoulShopListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_seoul_shop") 
	public int seoulShopTotalPage();*/
	
	// 상세보기
	@Select("SELECT no,title,poster,msg,address "
			+ "FROM project_seoul_location "
			+ "WHERE no=#{no}")
	public SeoulVO seoulLocationDetailData(int no);
	
	@Select("SELECT no,title,poster,msg,address "
			+ "FROM project_seoul_nature "
			+ "WHERE no=#{no}")
	public SeoulVO seoulNatureDetailData(int no);
	
	 /*@Select("SELECT no,title,poster,msg,address "
	  +"FROM project_seoul_shop "
	  +"WHERE no=#{no}")
public SeoulVO seoulShopDataData(int no);*/

/*
*    CREATE OR REPLACE PROCEDURE seoulShopListData(
 pStart NUMBER,
 pEnd NUMBER,
 pResult OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pResult FOR
  SELECT no,title,poster,num 
  FROM (SELECT no,title,poster,rownum as num
  FROM (SELECT no,title,poster 
  FROM project_seoul_shop ORDER BY no ASC))
  WHERE num BETWEEN pStart AND pEnd;
END;
/
-- 총페이지 
CREATE OR REPLACE PROCEDURE seoulShopTotalPage(
 pTotal OUT NUMBER
)
IS
BEGIN 
SELECT CEIL(COUNT(*)/12.0) INTO pTotal
FROM project_seoul_shop;
END;
/
-- 상세보기 
CREATE OR REPLACE PROCEDURE seoulShopDetailData(
 pNo project_seoul_shop.no%TYPE,
 pResult OUT SYS_REFCURSOR
)
IS
BEGIN
 OPEN pResult FOR
  SELECT no,title,poster,address,msg
  FROM project_seoul_shop
  WHERE no=pNo;
END;
/
*/
// 프로시저 => SELECT 
// 목록 출력 
/*
*   CREATE OR REPLACE PROCEDURE seoulShopListData(
 pStart NUMBER,
 pEnd NUMBER,
 pResult OUT SYS_REFCURSOR
)
*/
	@Results({
	@Result(property = "no",column = "no"),
	@Result(property = "title",column = "title"),
	@Result(property = "poster",column = "poster")
	})
	@Select(value="{CALL seoulShopListData(#{pStart,mode=IN,javaType=java.lang.Integer},"
	 +"#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
	@Options(statementType = StatementType.CALLABLE)
	// Statement , PreparedStatement(default) , CallableStatement(procedure호출)
	public List<SeoulVO> seoulShopListData(Map map); 

/*
*   CREATE OR REPLACE PROCEDURE seoulShopTotalPage(
 pTotal OUT NUMBER
)
*/
/*@Select(value="{CALL seoulShopTotalPage(#{pTotal,mode=OUT,javaType=java.lang.Integer,jdbcType=INTEGER})}")
@Options(statementType = StatementType.CALLABLE)
public int seoulShopTotalPage(Map map);*/
	public int seoulShopTotalPage();
/*
*   CREATE OR REPLACE PROCEDURE seoulShopDetailData(
 pNo project_seoul_shop.no%TYPE,
 pResult OUT SYS_REFCURSOR
)

SELECT no,title,poster,address,msg
  FROM project_seoul_shop
  
ResultSet rs=(ResultSet)ps.getObject("pResult")
while(rs.next())
{
SeoulVO vo=new SeoulVO()
vo.setNo(rs.getInt("no"))
   =====           =====
   property        column
}
*/
	@Results({
	@Result(property = "no",column = "no"),
	@Result(property = "title",column = "title"),
	@Result(property = "poster",column = "poster"),
	@Result(property = "address",column = "address"),
	@Result(property = "msg",column = "msg")
	})
	@Select(value="{CALL seoulShopDetailData(#{pNo,javaType=java.lang.Integer,mode=IN},"
	      +"#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public SeoulVO seoulShopDetailData(Map map);
	
	}