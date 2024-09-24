package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(int start,int end){
		return mapper.databoardListData(start, end);
	}
	public int databoardCount() {
		return mapper.databoardCount();
	}
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	public DataBoardVO databoardFileInfoData(int no) {
		return mapper.databoardFileInfoData(no);
	}
	public String databoardDelete(int no, String pwd) {
		String result="no";
		// 1. 데이터베이스에서 비밀번호 읽기
		String db_pwd=mapper.databoardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			result="yes";
			mapper.databoardDelete(no);
		}
		return result;
	}
	
	// 수정하기
	// 1. 이전에 입력한 데이터를 읽어서 출력
	public DataBoardVO databoardUpdateData(int no) {
		return mapper.databoardDetailData(no);
	}
	// 2. 수정하기
	public String databoardUpdate(DataBoardVO vo) {
		String result="no";
		String db_pwd=mapper.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			result="yes";
			mapper.databoardUpdate(vo);
		}
		return result;
	}
}
