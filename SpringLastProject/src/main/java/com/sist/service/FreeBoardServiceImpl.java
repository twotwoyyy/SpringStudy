package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.FreeBoardVO;
@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Autowired
	private FreeBoardDAO fDao;

	@Override
	public List<FreeBoardVO> freeboardListDate(int start, int end) {
		return fDao.freeboardListDate(start, end);
	}

	@Override
	public int freeboardRowCount() {
		return fDao.freeboardRowCount();
	}

	@Override
	public void freeboardInsert(FreeBoardVO vo) {
		fDao.freeboardInsert(vo);
	}

	@Override
	public FreeBoardVO freeboardDetailData(int no) {
		return fDao.freeboardDetailData(no);
	}

	@Override
	public void freeboardDelete(int no) {
		fDao.freeboardDelete(no);
		
	}
}
