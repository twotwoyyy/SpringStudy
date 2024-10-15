package com.sist.service;
import com.sist.vo.*;
import java.util.*;

public interface GoodsService {
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
	public void goodsHitIncrement(int no);
	public GoodsVO goodsDetailData(int no);
	public MemberVO memberInfoData(String userId);
	public void goodsCartInsert(CartVO vo);
	public void goodsCartAccountUpdate(CartVO vo);
	public int goodsCartGnoCount(int gno);
	public List<CartVO> goodsCartListData(String id);
	public void goodsCartCancel(int cno);
	public void goodsBuy(int cno);
	public List<CartVO> goodsBuyListData(String id);
}
