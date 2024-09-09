package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	/*
	 * 	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab,num "
			+"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
			+"FROM (SELECT no,subject,name,regdate,hit,group_tab "
			+"FROM spring_replyboard ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<ReplyBoardVO> boardListData(@Param("start") int start, @Param("end") int end);
		
		@Select("SELECT COUNT(*) FROM spring_replyboard")
		public int boardRowCount();
	
	 */
	public List<ReplyBoardVO> boardListData(int start, int end){
		return mapper.boardListData(start, end);
	}
	public int boardRowCount() {
		return mapper.boardRowCount();
	}
	/*
	 * 	@Insert("INSERT INTO spring_replyboard(no,name,subject,content,pwd,group_id) "
			+"VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
			+"(SELECT NVL(MAX(group_id)+1,1) FROM spring_replyboard))")
		public void boardInsert(ReplyBoardVO vo); 
	 */
	public void boardInsert(ReplyBoardVO vo) {
		mapper.boardInsert(vo);
	}
	/* <상세보기>
	 * 	@Update("UPDATE spring_replyboard SET "
			+"hit=hit+1 WHERE no=#{no}")
		public void boardHitIncrement(int no);
		
		@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
				+"FROM spring_replyboard "
				+ "WHERE no=#{no}")
		public ReplyBoardVO boardDetailData(int no);
	 */
	public ReplyBoardVO boardDetailData(int no) {
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	// 수정
	public ReplyBoardVO boardUpdateData(int no) {
		return mapper.boardDetailData(no);
	}
	/*
	 * 	@Select("SELECT pwd FROM spring_replyboard WHERE no=#{no}")
		public String boardGetPassword(int no);
		@Update("UPDATE spring_replyboard SET name=#{name}, subject=#{subject}, content=#{content} "
				+"WHERE no=#{no}")
		public void boardUpdate(ReplyBoardVO vo);
	 */
	public String boardUpdate(ReplyBoardVO vo) {
		String result="no";
		String db_pwd=mapper.boardGetPassword(vo.getNo()); // 번호에 해당되는 비밀번호를 가져온다
		if(db_pwd.equals(vo.getPwd())){
			result="yes";
			mapper.boardUpdate(vo);
		}
		return result;
	}
	
	// 답변 (트랜잭션 이용)
	/*
	 * 	@Select("SELECT group_id,group_step,group_tab "
			+"FROM spring_replyboard "
			+"WHERE no=#{no}")
		public ReplyBoardVO boardGroupData(int no);
		
		@Update("UPDATE spring_replyboard SET group_step=group_step+1 "
				+"WHERE group_id=#{group_id} AND group_step>#{group_step}")
		public void boardGroupStepIncrement(ReplyBoardVO vo);
		
		@Insert("INSERT INTO spring_replyboard(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
				+"VALUES(srb_no_sep.nextval,#{name},#{subject},#{content},#{pwd},#{group_id},#{group_step},#{group_tab},#{root})")
		public void boardReplyInsert(ReplyBoardVO vo);
		
		@Update("UPDATE spring_replyboard SET depth=depth+1 WHERE no=#{no}")
		public void boardDepthIncrement(int no);
	 */
	/*                              답변 모음   답변 출력 순서   답변 위치    
	 *                        no   group_id  group_step  group_tab  root  depth
	 *     AAAAA               1       1          0           0       0     2
	 *       => KKKKK          6       1          1           1       1     0
	 *       => BBBBB          4       1          2           1       1     1        
	 *         => CCCCC        5       1          3           2       4     0
	 *     DDDDD               2       2          0           0       0     0
	 *     EEEEE               3       3          0           0       0     0
	 */
	// SQL 일괄 처리 => 트랜잭션 
	// 금융권 => 카드 결제, 포인트 등록
	// => SQL 문장의 핵심 
	// DML (INSERT,UPDATE,DELETE) 여러 개가 동시에 수행 
	// AOP 기반으로 만들어져 있다
	// Transaction / Security => AOP가 포함
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class) // 실행할 때마다 트랜잭션, 오류나면 Exception
	public void boardReplyInsert(int pno,ReplyBoardVO vo) {
		//try {
			//conn.setAutoCommit(false); // Around
		ReplyBoardVO pvo=mapper.boardGroupData(pno);
		mapper.boardGroupStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		mapper.boardReplyInsert(vo);
		mapper.boardDepthIncrement(pno);
			//coon.commit(); // Around
		//}catch(Exception ex) {
			//conn.rollback(); // after-throwing
		//}finally {
			//conn.setAutoCommit(true); // after
		//}
	}
	
	
	
	/*
		// 삭제
		// 1-1 비밀번호 확인 => 이미 제작 
		// 	@Select("SELECT pwd FROM spring_replyboard WHERE no=#{no}")
		// public String boardGetPassword(int no);
	 * 		// 1-2 삭제 대상 => root,depth 읽기 
		@Select("SELECT root,depth FROM spring_replyboard WHERE no=#{no}")
		public ReplyBoardVO boardDeleteInfoData(int no);
			// 1-3 depth==0 삭제
		@Delete("DELETE FROM spring_replyboard WHERE no=#{no}")
		public void boardDelete(int no);
			// 1-4 depth!=0 수정 => "관리자가 삭제한 게시물입니다."
		@Update("UPDATE spring_replyboard SET subject='관리자가 삭제한 게시물입니다', content='관리자가 삭제한 게시물입니다' "
				+"WHERE no=#{no}")
		public void boardSubjectUpdate(int no);
			// 1-5 삭제 할 경우 depth를 감소 
		@Update("UPDATE spring_replyboard SET depth=depth-1 WHERE no=#{no}")
		public void boardDepthDecrement(int no);
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public String boardDelete(int no,String pwd) {
		String result="no";
		// 1. 비밀번호 검색 
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			result="yes";
		// 2. root/depth 가져오기
			ReplyBoardVO vo=mapper.boardDeleteInfoData(no);
			if(vo.getDepth()==0) { // 3. 답변이 없다면 => 삭제
				mapper.boardDelete(no);
			}else { // 4. 답변이 있다면 => 수정 
				mapper.boardSubjectUpdate(no);
			}
			mapper.boardDepthDecrement(vo.getRoot()); // 5. 상위 depth 감소 
		}
		return result;
	}
}
