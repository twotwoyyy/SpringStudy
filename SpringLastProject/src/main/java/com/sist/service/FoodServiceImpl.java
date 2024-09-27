package com.sist.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
/*	
 * 	링크 : JSP
 *         |
 *       @Controller => Mapper => DAO => Service => ServiceImpl
 *                        |        |        |            |
 *                       SQL  구현된 Mapper 기능(메소드)     구현
 *            |
 *        데이터베이스 내용을 JSP로 전송 
 *        1. JSP로 전송 => Model 
 *        2. Vue로 전송 => JSON 
 */
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
	// hit수 증가 없는 info 데이터 => Cookie용
	@Override
	public FoodVO foodInfoData(int fno) {
		return fDao.foodInfoData(fno);
	}

	@Override
	public List<FoodVO> foodFindListData(Map map) {
		return fDao.foodFindListData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		return fDao.foodFindTotalPage(map);
	}
}
