package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_price,goods_poster,num "
			+"FROM (SELECT no,goods_name,goods_price,goods_poster,rownum as num "
			+"FROM (SELECT no,goods_name,goods_price,goods_poster "
			+"FROM ${table_name} ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${table_name}")
	public int goodsTotalPage(Map map);
	
	@Select("SELECT no,goods_name,goods_price,goods_poster,goods_first_price,goods_delivery,goods_discount,goods_sub "
			+"FROM ${table_name} WHERE no=#{no}")
	public GoodsVO goodsDetailData(Map map);
}
