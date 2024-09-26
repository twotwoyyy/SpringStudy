package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> foodHitTop5() {
		return fDao.foodHitTop5();
	}

	@Override
	public List<FoodVO> foodListData(int start, int end) {
		return fDao.foodListData(start, end);
	}

	@Override
	public int foodTotalPage() {
		return fDao.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		return fDao.foodDetailData(fno);
	}
	// hit수 증가 없는 info 데이터
	@Override
	public FoodVO foodInfoData(int fno) {
		return fDao.foodInfoData(fno);
	}
}
