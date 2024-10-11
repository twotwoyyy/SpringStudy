package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface FreeBoardService {
	public List<FreeBoardVO> freeboardListDate(int start, int end);
	public int freeboardRowCount();
	public void freeboardInsert(FreeBoardVO vo);
	public FreeBoardVO freeboardDetailData(int no);
	public void freeboardDelete(int no);
	public FreeBoardVO freeboardupdateData(int no);
	public void freeboardUpdate(FreeBoardVO vo);
}
