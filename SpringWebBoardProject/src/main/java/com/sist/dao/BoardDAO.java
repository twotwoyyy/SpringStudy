package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
/*
 *    1. ~DAO : 데이터베이스 연동
 *    2. ~Service : DAO 여러개를 한 개로 통합, 결합성이 낮은 프로그램
 *    3. ~Manager : Open API
 *    4. ~Controller : Model
 *    5. ~RestController : 자바스크립트, 코틀린
 *       =============== JSON
 *    6. ~ControllerAdvice : 통합 예외처리
 *    ==================================== 스프링에서 관리 (생송 ~ 소멸까지 관리)
 *       ~VO : 사용자 데이터형
 *       ~Mapper : 관리할 수 없다 (인터페이스)
 *    ==================================== 개발자 관리
 */
@Repository // DAO메모리 할당 요청 => 관리 => 싱글턴으로 생성
public class BoardDAO {
    // 필요한 객체를 스프링으로부터 얻어온다 => 주입(DI) => 자동 주입 : @Autowired
   @Autowired
   private BoardMapper mapper; // 구현된 클래스의 주소값을 설정
   // 메소드안에서는 어노테이션을 사용할 수 없다
   /*
    *   => 어노테이션 아래, 어노테이션 옆에 있는 것을 제어
    *   1. class 위 => TYPE(클래스 구분자)
    *   2. 메소드 위 => METHOD(메소드 구분자)
    *   3. 멤버변수 위 => FIELD(멤버변수 구분자)
    *   4. 매개변수 옆 => PARAMETER(매개변수 구분자)
    *   5. 생성자 위 => CONSTRUCTURE(생성자 구분자)
    */
   /*
    * @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
        +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
        +"FROM (SELECT no,subject,name,regdate,hit "
        +"FROM spring_board ORDER BY no DESC)) "
        +"WHERE num BETWEEN #{start} AND #{end}")
       public List<BoardVO> boardListData(@Param("start") int start,@Param("end") int end);
    */
   public List<BoardVO> boardListData(int start,int end)
   {
      return mapper.boardListData(start, end);
   }
   /*
    * @Insert("INSERT INTO spring_board(no,name,subject,content,pwd) "
        +"VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
       public void boardInsert(BoardVO vo);
    */
   public void boardInsert(BoardVO vo)
   {
      mapper.boardInsert(vo); // commit도 설정   session.close()
   }
   /*
    * @Select("SELECT COUNT(*) FROM spring_board")
       public int boardRowCount();
    */
   public int boardRowCount()
   {
      return mapper.boardRowCount();
   }
   /*
	      @Update("UPDATE spring_board SET "
			  +"hit=hit+1 "
			  +"WHERE no=#{no}")
			  public void hitIncrement(int no);
		  
		  @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit "
				  +"FROM spring_board "
				  +"WHERE no=#{no}")
		  public BoardVO boardDetailData(int no);
    */
   public BoardVO boardDetailData(int no) {
	   mapper.hitIncrement(no); // 조회수 증가
	   return mapper.boardDetailData(no);
   }
   // 업데이트 데이터 
   public BoardVO boardUpdateData(int no) {
	   return mapper.boardDetailData(no);
   }
   /*
   	  @Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	  public String boardGetPassword(int no); // 비밀번호 가지고 오기
	  
	  @Update("UPDATE spring_board SET "
			  +"name=#{name}, subject=#{subject}, content=#{content} "
			  +"WHERE no=#{no}")
	  public void boardUpdate(BoardVO vo);
    */
   public boolean boardUpdate(BoardVO vo) {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(vo.getNo());
	   if(db_pwd.equals(vo.getPwd())) {
		   bCheck=true;
		   // 수정
		   mapper.boardUpdate(vo);
	   }
	   return bCheck;
   }
   /*   @Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	  public String boardGetPassword(int no); // 비밀번호 가지고 오기
    *   @Delete("DELETE FROM spring_board "
			  +"WHERE no=#{no}")
	  public void boardDelete(int no);
    */
   // 삭제
   // 사용자 정의 매개변수는 자유롭게 사용이 가능 
   public boolean boardDelete(int no, String pwd) {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(no);
	   if(pwd.equals(db_pwd)) {
		   bCheck=true;
		   mapper.boardDelete(no);
	   }
	   return bCheck;
   }
}


