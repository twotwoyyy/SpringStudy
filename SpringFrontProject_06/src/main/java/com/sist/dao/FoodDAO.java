package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodTypeListData(Map map){
		return mapper.foodTypeListData(map);
	}
	
	public int foodTypeTotalpage(String type) {
		return mapper.foodTypeTotalPage(type);
	}
	public FoodVO foodDetailData(int fno) {
		mapper.hitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	public List<FoodVO> foodNearHouseData(String address){
		return mapper.foodNearHouseData(address);
	}
}
