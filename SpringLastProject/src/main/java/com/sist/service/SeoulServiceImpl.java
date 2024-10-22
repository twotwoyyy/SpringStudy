package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class SeoulServiceImpl implements SeoulService{
	@Autowired
	private SeoulDAO sDao;

	@Override
	public List<SeoulVO> seoulLocationListData(Map map) {
		return sDao.seoulLocationListData(map);
	}

	@Override
	public List<SeoulVO> seoulNatureListData(Map map) {
		return sDao.seoulNatureListData(map);
	}

	/*@Override
	public List<SeoulVO> seoulShopListData(Map map) {
		return sDao.seoulShopListData(map);
	}*/

	@Override
	public int seoulLocationTotalPage() {
		return sDao.seoulLocationTotalPage();
	}

	@Override
	public int seoulNatureTotalPage() {
		return sDao.seoulLNatureTotalPage();
	}

	/*@Override
	public int seoulShopTotalPage() {
		return sDao.seoulShopTotalPage();
	}*/

	@Override
	public SeoulVO seoulLocationDetailData(int no) {
		return sDao.seoulLocationDetailData(no);
	}

	@Override
	public SeoulVO seoulNatureDetailData(int no) {
		return sDao.seoulNatureDetailData(no);
	}

	@Override
	public List<SeoulVO> seoulShopListData(Map map) {
		return sDao.seoulShopListData(map);
	}

	@Override
	public int seoulShopTotalPage() {
		return sDao.seoulShopTotalPage();
	}

	@Override
	public SeoulVO seoulShopDetailData(Map map) {
		return sDao.seoulShopDetailData(map);
	}

	/*@Override
	public SeoulVO seoulShopDetailData(int no) {
		return sDao.seoulShopDetailData(no);
	}*/
	
	
}
