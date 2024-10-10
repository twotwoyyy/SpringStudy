package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface FreeBoardMapper {
	@Select("SELECT no,subject,id,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+"FROM (SELECT no,subject,id,name,regdate,hit,rownum as num "
			+"FROM (SELECT no,subject,id,name,regdate,hit "
			+"FROM spring_freeboard ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FreeBoardVO> freeboardListDate(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM spring_freeboard")
	public int freeboardRowCount();
	
	// 상세보기
	@Update("UPDATE spring_freeboard SET hit=hit+1 WHERE no=#{no}")
	public void freeboardHitIncrement(int no);
	@Select("SELECT no,id,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit "
			+ "FROM spring_freeboard "
			+ "WHERE no=#{no}")
	public FreeBoardVO freeboardDetailData(int no);
	// 수정하기 
	// 삭제하기
	@Delete("DELETE FROM spring_freeboard WHERE no=#{no}")
	public void freeboardDelete(int no);
	// 추가하기
	@Insert("INSERT INTO spring_freeboard VALUES("
			+ "sf_no_seq.nextval,#{id},#{name},#{subject},#{content},0,SYSDATE)")
	public void freeboardInsert(FreeBoardVO vo);
}
