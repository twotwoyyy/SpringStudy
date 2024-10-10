package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
import java.util.*;
public interface CommentMapper {
	@Select("SELECT cno,rno,type,id,name,msg,sex,group_tab,TO_CHAR(modifydate,'YYYY-MM-DD HH24:MI:SS') as mday,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
			+"FROM(SELECT cno,rno,type,id,name,msg,sex,group_tab,modifydate,regdate,rownum as num "
			+ "FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,modifydate,regdate "
			+ "FROM spring_comment "
			+ "WHERE rno=#{rno} AND type=#{type}"
			+ "ORDER BY group_id DESC, group_step ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<CommentVO> commentListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_comment "
			+"WHERE rno=#{rno} AND type=#{type}")
	public int commentTotalPage(Map map);
	
	@Insert("INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,type) "
			+"VALUES(sc_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},"
			+"(SELECT NVL(MAX(group_id)+1,1) FROM spring_comment),#{type})")
	public void commentInsert(CommentVO vo);
	
	// 대댓글
	@Select("SELECT group_id,group_step,group_tab "
			+"FROM spring_comment "
			+"WHERE cno=#{cno}")
	public CommentVO commentParentInfoData(int cno);
	
	@Update("UPDATE spring_comment SET "
			+"group_step=group_step+1 "
			+"WHERE group_id=#{group_id} AND group_step>#{group_step}")
	public void commentGroupStepIncrement(CommentVO vo);
	
	@Insert("INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,group_step,group_tab,root,type) "
			+"VALUES(sc_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},#{group_id},#{group_step},#{group_tab},#{root},#{type})")
	public void commentReplyReplyInsert(CommentVO vo);
	
	@Update("UPDATE spring_comment SET depth=depth+1 WHERE cno=#{cno}")
	public void commentDepthIncrement(int cno);
	
	// 삭제하기
	@Select("SELECT group_id,group_step FROM spring_comment WHERE cno=#{cno}")
	public CommentVO commentDeleteInfoData(int cno);
	// MyBatis 동적 쿼리 => 여러 개의 SQL 문장을 사용자 요청에 따라 한 개의 SQL문장으로 처리
	// 삭제하기 / 검색하기 => 관리자 모드 : 삭제 / 수정 => 체크박스
	//                   => 등급 => 동적 쿼리 이용 
	@Delete("<script>"
			+ "DELETE FROM spring_comment "
			+ "WHERE <if test=\"group_step==0\">"
			+ "group_id=#{group_id}"
			+ "</if> "
			+ "<if test=\"group_step!=0\">"
			+ "cno=#{cno} "
			+ "</if>"
			+ "</script>")
	public void commentDelete(Map map);
	// 댓글 카운트
	@Update("UPDATE project_food_house SET replycount=replycount+1 WHERE fno=#{fno}")
	public void foodReplyIncrement(int fno);
	
	@Update("UPDATE project_food_house SET replycount=replycount-1 WHERE fno=#{fno}")
	public void foodReplyDecrement(int fno);
	
	// 수정하기
	@Update("UPDATE spring_comment SET msg=#{msg},modifydate=SYSDATE WHERE cno=#{cno}")
	public void commentUpdate(CommentVO vo);
	
}
