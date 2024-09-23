package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAO {
	// spring으로부터 구현된 Mapper의 주소를 대입 => 요청 
	@Autowired // 주소값 자동 주입 => @Autowired => 객체에만 적용 
	// 스프링 => 클래스의 생명주기 관리 => 주로 객체 주소 주입 
	// @Autowired => 1) 멤버 변수 2) 생성자 3) setXxx()
	// Annotation은 밑에 있는 변수/메소드/생성자 적용, 옆에 있는 내용을 제어
	private BoardMapper mapper;
	public List<BoardVO> boardListData(int start, int end){
		return mapper.boardListData(start, end);
	}
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	public BoardVO boardDetailDate(int no) {
		mapper.HitIncrement(no);
		return mapper.boardDetailDate(no);
	}
	public String boardDelete(int no, String pwd) {
		String result="no";
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			result="yes";
			mapper.boardDelete(no);
		}
		return result;
	}
	public BoardVO boardUpdateData(int no) {
		return mapper.boardDetailDate(no);
	}
	public String boardUpdate(BoardVO vo) {
		String result="no";
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			result="yes";
			mapper.boardUpdate(vo);
		}
		return result;
	}
}
