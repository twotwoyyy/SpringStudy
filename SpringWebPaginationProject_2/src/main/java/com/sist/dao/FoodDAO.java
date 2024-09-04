package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
	/*
	 * 	@Select("SELECT fno,name,type,poster,score,num "
			+"FROM(SELECT fno,name,type,poster,score,rownum as num "
			+"FROM(SELECT fno,name,type,poster,score "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
	public int foodTotalPage();
	 */
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodListData(Map map){
		return mapper.foodListData(map);
	}
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
}
