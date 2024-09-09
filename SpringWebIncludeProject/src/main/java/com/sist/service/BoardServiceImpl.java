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
		return dao.boardListData(start, end);
	}

	@Override
	public int boardRowCount() {
		return dao.boardRowCount();
	}

	@Override
	public void boardInsert(ReplyBoardVO vo) {
		dao.boardInsert(vo);
	}

	@Override
	public ReplyBoardVO boardDetailData(int no) {
		return dao.boardDetailData(no);
	}

	@Override
	public ReplyBoardVO boardUpdateData(int no) {
		return dao.boardDetailData(no);
	}

	@Override
	public String boardUpdate(ReplyBoardVO vo) {
		return dao.boardUpdate(vo);
	}

	@Override
	public void boardReplyInsert(int pno, ReplyBoardVO vo) {
		dao.boardReplyInsert(pno, vo);
		
	}

	@Override
	public String boardDelete(int no, String pwd) {
		return dao.boardDelete(no, pwd);
	}
}
