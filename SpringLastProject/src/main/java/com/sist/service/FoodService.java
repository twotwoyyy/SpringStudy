package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

public interface FoodService {
	public List<FoodVO> foodHitTop5();
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	public FoodVO foodInfoData(int fno);
	public List<FoodVO> foodFindListData(Map map);
	public int foodFindTotalPage(Map map);
}
