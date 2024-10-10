package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.CommentDAO;
import com.sist.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDAO cDao;

	@Override
	public List<CommentVO> commentListData(Map map) {
		return cDao.commentListData(map);
	}

	@Override
	public int commentTotalPage(Map map) {
		return cDao.commentTotalPage(map);
	}

	@Override
	public void commentInsert(CommentVO vo) {
		cDao.commentInsert(vo);
	}

	@Override
	public void commentReplyReplyInsert(int cno, CommentVO vo) {
		cDao.commentReplyReplyInsert(cno, vo);
		
	}

	@Override
	public CommentVO commentDeleteInfoData(int cno) {
		return cDao.commentDeleteInfoData(cno);
	}

	@Override
	public void commentDelete(Map map) {
		cDao.commentDelete(map);
	}

	@Override
	public void foodReplyDecrement(int fno) {
		cDao.foodReplyDecrement(fno);
	}

	@Override
	public void commentUpdate(CommentVO vo) {
		cDao.commentUpdate(vo);
		
	}

}
