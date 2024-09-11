package com.sist.mapper;
// SQL 문장을 이용해서 => CRUD를 수행 => Mybatis에 의해 자동 구현
/*
 *   JSP = @Controller = @Repository = @Controller = JSP 
 */
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("SELECT no, name, subject, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num " +
	        "FROM (SELECT no, name, subject, regdate, hit, rownum as num " +
	        "FROM (SELECT no, name, subject, regdate, hit " +
	        "FROM spring_board " +
	        "ORDER BY no DESC)) " +
	        "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board")
	public int boardTotalPage();
}
