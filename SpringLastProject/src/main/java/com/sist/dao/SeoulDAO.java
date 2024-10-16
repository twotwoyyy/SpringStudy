package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulLocationListData(Map map){
		return mapper.seoulLocationListData(map);
	}
	public int seoulLocationTotalPage() {
		return mapper.seoulLocationTotalPage();
	}
	public List<SeoulVO> seoulNatureListData(Map map){
		return mapper.seoulNatureListData(map);
	}
	public int seoulLNatureTotalPage() {
		return mapper.seoulNatureTotalPage();
	}

	public List<SeoulVO> seoulShopListData(Map map){
		return mapper.seoulShopListData(map);
	}
	public int seoulShopTotalPage() {
		return mapper.seoulShopTotalPage();
	}
}
