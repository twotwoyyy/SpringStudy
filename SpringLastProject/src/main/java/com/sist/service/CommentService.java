package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> commentListData(Map map);
	public int commentTotalPage(Map map);
}
