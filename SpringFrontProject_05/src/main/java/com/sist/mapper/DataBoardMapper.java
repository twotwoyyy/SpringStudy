package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
/*
 *   FormData
 */

import lombok.Delegate;
public interface DataBoardMapper {
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+"FROM (SELECT no,subject,name,regdate,hit "
			+"FROM vue_databoard ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM vue_databoard")
	public int databoardCount();
	
	// Mybatis에서 sequence 만드는 방법 
	@SelectKey(keyProperty = "no", resultType = int.class, before = true, 
			statement= "SELECT NVL(MAX(no)+1,1) as no FROM vue_databoard")
	@Insert("INSERT INTO vue_databoard(no,name,subject,content,pwd,filename,filesize,filecount) "
			+"VALUES(#{no},#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	// 상세보기 
	// 조회수 증가 
	@Update("UPDATE vue_databoard SET hit=hit+1 WHERE no=#{no}")
	public void hitIncrement(int no);
	// 게시물의 모든 데이터를 읽기
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday,filename,filesize,filecount,hit "
			+"FROM vue_databoard WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	
	// 삭제하기
	// 1. 비밀번호 처리
	@Select("SELECT pwd FROM vue_databoard WHERE no=#{no}")
	public String databoardGetPassword(int no);
	// 2. 파일 정보 읽기
	@Select("SELECT filename,filecount FROM vue_databoard WHERE no=#{no}")
	public DataBoardVO databoardFileInfoData(int no);
	// 3. 삭제하기
	@Delete("DELETE FROM vue_databoard WHERE no=#{no}")
	public void databoardDelete(int no);
	
	// 수정하기
	@Update("UPDATE vue_databoard SET "
			+"name=#{name},subject=#{subject},content=#{content},filename=#{filename},filesize=#{filesize},filecount=#{filecount} "
			+"WHERE no=#{no}")
	public void databoardUpdate(DataBoardVO vo);
}
