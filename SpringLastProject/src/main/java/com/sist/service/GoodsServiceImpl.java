package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDAO gDao;
	
	@Override
	public List<GoodsVO> goodsListData(Map map) {
		return gDao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		return gDao.goodsTotalPage();
	}

	@Override
	public void goodsHitIncrement(int no) {
		gDao.goodsHitIncrement(no);
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		return gDao.goodsDetailData(no);
	}

	@Override
	public MemberVO memberInfoData(String userId) {
		return gDao.memberInfoData(userId);
	}

	@Override
	public void goodsCartInsert(CartVO vo) {
		gDao.goodsCartInsert(vo);
	}

	@Override
	public void goodsCartAccountUpdate(CartVO vo) {
		gDao.goodsCartAccountUpdate(vo);
	}

	@Override
	public int goodsCartGnoCount(int gno) {
		return gDao.goodsCartGnoCount(gno);
	}

	@Override
	public List<CartVO> goodsCartListData(String id) {
		return gDao.goodsCartListData(id);
	}

	@Override
	public void goodsCartCancel(int cno) {
		gDao.goodsCartCancel(cno);
		
	}

	@Override
	public void goodsBuy(int cno) {
		gDao.goodsBuy(cno);
	}

	@Override
	public List<CartVO> goodsBuyListData(String id) {
		return gDao.goodsBuyListData(id);
	}

}
