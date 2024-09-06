package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;

	@Override
	public List<ReplyBoardVO> boardListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.boardListData(start, end);
	}

	@Override
	public int boardRowCount() {
		// TODO Auto-generated method stub
		return dao.boardRowCount();
	}

	@Override
	public void boardInsert(ReplyBoardVO vo) {
		// TODO Auto-generated method stub
		dao.boardInsert(vo);
	}

	@Override
	public ReplyBoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.boardDetailData(no);
	}
}
