package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+"FROM(SELECT fno,name,poster,rownum as num "
			+"FROM(SELECT fno,name,poster "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
	public int foodTotalPage();
	
	// 상세
	@Update("UPDATE project_food_house SET hit=hit+1 WHERE fno=#{fno}")
	public void foodHitIncrement(int fno); 
	
	@Select("SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content "
			+"FROM project_food_house "
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	// 쿠키 정보 데이터
	@Select("SELECT fno,name,poster FROM project_food_house WHERE fno=#{fno}")
	public FoodVO foodCookieInfoData(int fno);
}
