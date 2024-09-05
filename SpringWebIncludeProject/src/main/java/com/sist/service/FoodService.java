package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData(Map map);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	public FoodVO foodCookieInfoData(int fno);
}
