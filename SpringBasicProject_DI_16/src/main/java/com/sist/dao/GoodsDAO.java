package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository("dao")
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper; // 스프링에서 구현한 클래스 주소를 받아 온다 
	/*
	 * 	@Select("SELECT no,goods_name,goods_price,goods_poster,num "
			+"FROM (SELECT no,goods_name,goods_price,goods_poster,rownum as num "
			+"FROM (SELECT no,goods_name,goods_price,goods_poster "
			+"FROM ${table_name} ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<GoodsVO> goodsListData(Map map);
	
	 */
	public List<GoodsVO> goodsListData(Map map){
		return mapper.goodsListData(map);
	}
	/*
	 * 		@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${table_name}")
			public int goodsTotalPage(Map map);
	 */
	public int goodsTotalPage(Map map) {
		return mapper.goodsTotalPage(map);
	}
	/*
		@Select("SELECT no,goods_name,goods_price,goods_poster,goods_first_price,goods_delivery,goods_discount,goods_sub "
				+"FROM ${table_name}")
		public GoodsVO goodsDetailData(Map map);
	 */
	public GoodsVO goodsDetailData(Map map) {
		return mapper.goodsDetailData(map);
	}
}
