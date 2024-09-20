package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+"FROM (SELECT fno,name,poster,rownum as num "
			+"FROM (SELECT fno,name,poster "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start")int start, @Param("end")int end);
	
	// 여러 개의 매개 변수 => @Param, Map, VO
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
	public int foodTotalPage();
	
	// 검색 find 
	@Select("SELECT fno,name,poster,address,num "
			+"FROM (SELECT fno,name,poster,address,rownum as num "
			+"FROM (SELECT fno,name,poster,address "
			+"FROM project_food_house WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	
	// 여러 개의 매개 변수 => @Param, Map, VO
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house WHERE address LIKE '%'||#{address}||'%'")
	public int foodFindTotalPage(Map map);
}
