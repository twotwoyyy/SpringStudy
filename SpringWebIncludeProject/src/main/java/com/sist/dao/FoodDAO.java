package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	// 리스트
	/*
	 * 	@Select("SELECT fno,name,poster,num "
			+"FROM(SELECT fno,name,poster,rownum as num "
			+"FROM(SELECT fno,name,poster "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodListData(Map map);
		
		@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
		public int foodTotalPage();
	 */
	public List<FoodVO> foodListData(Map map){
		return mapper.foodListData(map);
	}
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	// 상세보기
	/*
		@Update("UPDATE project_food_house SET hit=hit+1 WHERE fno=#{fno}")
		public void foodHitIncrement(int fno); 
		@Select("SELECT * FROM project_food_house WHERE fno=#{fno}")
		public FoodVO foodDetailData(int fno);
	 */
	public FoodVO foodDetailData(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	// 쿠키
	/*
	 * 	@Select("SELECT fno,name,poster FROM project_food_house WHERE fno=#{fno}")
		public FoodVO foodCookieInfoData(int fno);
	 */
	public FoodVO foodCookieInfoData(int fno) {
		return mapper.foodCookieInfoData(fno);
	}
}
