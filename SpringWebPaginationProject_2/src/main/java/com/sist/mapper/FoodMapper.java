package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
public interface FoodMapper {
	@Select("SELECT fno,name,type,poster,score,num "
			+"FROM(SELECT fno,name,type,poster,score,rownum as num "
			+"FROM(SELECT fno,name,type,poster,score "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
	public int foodTotalPage();
}
