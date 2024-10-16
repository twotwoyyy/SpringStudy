package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.SeoulVO;

public interface SeoulService {
	public List<SeoulVO> seoulLocationListData(Map map);
	public int seoulLocationTotalPage();
	public List<SeoulVO> seoulNatureListData(Map map);
	public int seoulNatureTotalPage();
	public List<SeoulVO> seoulShopListData(Map map);
	public int seoulShopTotalPage();
}
