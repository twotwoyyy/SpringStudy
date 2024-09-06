package com.sist.service;

import java.util.List;

import com.sist.vo.ReplyBoardVO;

public interface BoardService {
	public List<ReplyBoardVO> boardListData(int start, int end);
	public int boardRowCount();
	public void boardInsert(ReplyBoardVO vo);
	public ReplyBoardVO boardDetailData(int no);
}	
