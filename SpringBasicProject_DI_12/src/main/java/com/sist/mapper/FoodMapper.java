package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,score,address,phone,num "
			+"FROM (SELECT fno,name,score,address,phone,rownum as num "
			+"FROM (SELECT fno,name,score,address,phone "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM project_food_house")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,score,address,phone,theme,type,time,parking "
			+"FROM project_food_house "
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
