package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.ChefVO;
import com.sist.mapper.*;
@Repository
public class ChefDAO {
	@Autowired
	private ChefMapper mapper;
	public ChefVO chefToday() {
		return mapper.chefToday();
	}
	public List<ChefVO> chefListData(Map map){
		return mapper.chefListData(map);
	}
	public int chefTotalPage() {
		return mapper.chefTotalPage();
	}
}
