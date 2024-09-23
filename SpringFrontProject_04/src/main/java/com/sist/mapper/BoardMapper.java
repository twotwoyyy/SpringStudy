package com.sist.mapper;
// VO => Mapper => DAO => Controller => JSP로 전송 
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.checkerframework.checker.units.qual.degrees;

/*
 * 	SELECT : 데이터 검색
 * 	1) 컬럼 대신 사용 SELECT ~~ (SELECT ~) : 스칼라 서브쿼리
 * 	2) 테이블 대신 사용 FROM (SELECT ~\) : 인라인뷰(페이징)
 * 	3) 조건문 처리가 가능 WHERE 컬럼명 (SELECT ~) : 서브쿼리
 * 
 *  정렬 시에는 속도의 최적화 => INDEX 
 *                         ======= 자동 생성 : PK,UK 
 *                         | CRUD가 많은 경우 => 속도가 저하 (게시판, 댓글..)
 *                           크롤링해서 저장된 경우 => 데이터를 갱신하지 않는다 (Index)
 */
import com.sist.vo.*;

import lombok.Delegate;
public interface BoardMapper {
	// 자동 구현 => 리턴형 / 매개변수
	// => 매개변수 : #{}, ${} => WHERE 문장이 있는 경우 
	// 리턴형 => 실행 후 : ROW가 여러 개인 경우 => List
	//                  ROW가 한 개인 경우 => VO, 일반 데이터형 
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+"FROM (SELECT no,subject,name,regdate,hit "
			+"FROM vue_board ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM vue_board")
	public int boardTotalPage();
	
	// 글쓰기
	@Insert("INSERT INTO vue_board(no,name,subject,content,pwd) "
			+"VALUES(vb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo);
	
	// 내용보기
	@Update("UPDATE vue_board SET hit=hit+1 WHERE no=#{no}")
	public void HitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday,hit "
			+"FROM vue_board "
			+"WHERE no=#{no}")
	public BoardVO boardDetailDate(int no);
	
	// 삭제하기
	// 1. 비밀번호 검색
	@Select("SELECT pwd FROM vue_board WHERE no=#{no}")
	public String boardGetPassword(int no);
	// 2. 실제 삭제 
	@Delete("DELETE FROM vue_board WHERE no=#{no}")
	public void boardDelete(int no);
	
	// 수정하기
	// 1. 데이터 읽기 
	@Select("SELECT name,subject,content,pwd "
			+"FROM vue_board "
			+"WEHRE no=#{no}")
	public BoardVO boardUpdateData(int no);
	// 2. 업데이트
	@Update("UPDATE vue_board SET name=#{name}, subject=#{subject}, content=#{content} "
			+"WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
}
