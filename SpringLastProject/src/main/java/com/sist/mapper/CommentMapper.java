package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
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
}
