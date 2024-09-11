package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
// 오라클 연동
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	/*
	 * public List<BoardVO> boardListData(Map map);
	 */
	public List<BoardVO> boardListData(Map map){
		return mapper.boardListData(map);
	}
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
}
