package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class ReserveServiceImpl implements ReserveService{

	@Autowired
	private ReserveDAO rDao;
	
	@Override
	public List<FoodVO> reserveFoodInfoData(Map map) {
		return rDao.reserveFoodInfoData(map);
	}

	@Override
	public int reserveFoodTotalPage(Map map) {
		return rDao.reserveFoodTotalPage(map);
	}

	@Override
	public void reserveInsert(ReserverVO vo) {
		rDao.reserveInsert(vo);
		
	}

	@Override
	public List<ReserverVO> reserveMypageListData(String id) {
		return rDao.reserveMypageListData(id);
	}

	@Override
	public List<ReserverVO> reserveAdminListData() {
		return rDao.reserveAdminListData();
	}

	@Override
	public void reserveOk(int rno) {
		rDao.reserveOk(rno);
		
	}

	@Override
	public ReserverVO reserveInfoData(int rno) {
		return rDao.reserveInfoData(rno);
	}

}
