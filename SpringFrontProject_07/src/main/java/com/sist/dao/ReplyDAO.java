package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyVO> replyListData(int fno){
		return mapper.replyListData(fno);
	}
	public void replyInsert(ReplyVO vo) {
		mapper.replyInsert(vo);
	}
	public void replyDelete(int rno) {
		mapper.replyDelete(rno);
	}
	public void replyUpdate(ReplyVO vo) {
		mapper.replyUpdate(vo);
	}
}
