package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FoodMapper {
	@Select("SELECT fno,poster,type,name,num "
			+ "FROM (SELECT fno,poster,type,name,rownum as num "
			+ "FROM (SELECT fno,poster,type,name "
			+ "FROM project_food_house "
			+ "WHERE type LIKE '%'||#{type}||'%' ORDER BY fno)) "
			+ "WEHRE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodTypeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house WHERE type LIKE '%'||#{type}||'%'")
	public int foodTypeTotalpage();
}
