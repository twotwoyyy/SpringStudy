package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class ReserveDAO {
	@Autowired
	private ReserveMapper mapper;

	public List<FoodVO> reserveFoodInfoData(Map map){
		return mapper.reserveFoodInfoData(map);
	}
	
	public int reserveFoodTotalPage(Map map) {
		return mapper.reserveFoodTotalPage(map);
	}
	public void reserveInsert(ReserverVO vo) {
		mapper.reserveInsert(vo);
	}
	public List<ReserverVO> reserveMypageListData(String id){
		return mapper.reserveMypageListData(id);
	}
	public List<ReserverVO> reserveAdminListData(){
		return mapper.reserveAdminListData();
	}
	public void reserveOk(int rno) {
		mapper.reserveOk(rno);
	}
	public ReserverVO reserveInfoData(int rno) {
		return mapper.reserveInfoData(rno);
	}
}
