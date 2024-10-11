package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.FreeBoardVO;

import java.util.*;
@Repository
public class FreeBoardDAO {
	@Autowired
	private FreeBoardMapper mapper;
	
	public List<FreeBoardVO> freeboardListDate(int start, int end){
		return mapper.freeboardListDate(start, end);
	}
	public int freeboardRowCount() {
		return mapper.freeboardRowCount();
	}
	public void freeboardInsert(FreeBoardVO vo) {
		mapper.freeboardInsert(vo);
	}
	public FreeBoardVO freeboardDetailData(int no) {
		mapper.freeboardHitIncrement(no);
		return mapper.freeboardDetailData(no);
	}
	public void freeboardDelete(int no) {
		mapper.freeboardDelete(no);
	}

	public FreeBoardVO freeboardupdateData(int no) {
		return mapper.freeboardupdateData(no);
	}

	public void freeboardUpdate(FreeBoardVO vo) {
		mapper.freeboardUpdate(vo);
	}
}
