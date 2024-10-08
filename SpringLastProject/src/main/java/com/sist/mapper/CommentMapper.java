package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
import java.util.*;
public interface CommentMapper {
	@Select("SELECT cno,rno,type,id,name,msg,sex,group_tab,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
			+"FROM(SELECT cno,rno,type,id,name,msg,sex,group_tab,regdate,rownum as num "
			+ "FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,regdate "
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
}
