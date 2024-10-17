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

	/*public List<SeoulVO> seoulShopListData(Map map){
		return mapper.seoulShopListData(map);
	}
	public int seoulShopTotalPage() {
		return mapper.seoulShopTotalPage();
	}*/
	public SeoulVO seoulLocationDetailData(int no) {
		return mapper.seoulLocationDetailData(no);
	}
	
	public SeoulVO seoulNatureDetailData(int no) {
		return mapper.seoulNatureDetailData(no);
	}
	/*
	public SeoulVO seoulShopDetailData(int no) {
		return mapper.seoulShopDetailData(no);
	}*/
	
	// 프로시저
	public List<SeoulVO> seoulShopListData(Map map){
		mapper.seoulShopListData(map);
		return (List<SeoulVO>)map.get("pResult");
	}
	public int seoulShopTotalPage() {
		
		return mapper.seoulShopTotalPage();
	}
	public SeoulVO seoulShopDetailData(Map map) {
		mapper.seoulShopDetailData(map);
		List<SeoulVO> list=(List<SeoulVO>)map.get("pResult");
		return list.get(0);
	}
	
}
