package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

/*
 *		1. 스프링에 관리 (클래스) 
 *         = DAO ============= @Repository 
 *         = Service ========= @Service
 *         = Manager ========= @Component ==> 일반 클래스 
 *         = Controller ====== @Controller
 *         = Interceptor ===== xml => <bean>
 *         = AOP ============= @Component ==> 일반 클래스
 *         =================== 스프링에 의해 관리
 *         
 *         interface
 *         ~VO 
 *         제외 
 *         => 클래스
 *            1) 데이터형 클래스 => 변수로 구성
 *            	= 사용자 정의 데이터형 => ~VO 
 *            2) 액션 클래스 => 기능을 가지고 있는 클래스 (메소드로 구성) => spring 관리 
 */

@Repository // 메모리 할당 요청 => 스프링이 관리 
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	/*
	 * 	// ID 존재 여부 확인 
		@Select("SELECT COUNT(*) FROM project_member "
				+"WHERE id=#{id}")
		public int memberIdCount(String id);
		
		// PWD를 검색 
		@Select("SELECT pwd,id,name,admin FROM project_member "
				+"WHERE id=#{id}")
		public MemberVO memberGetPassword(String id);
	 */
	public int memberIdCount(String id) {
		return mapper.memberIdCount(id);
	}
	public MemberVO memberGetPassword(String id) {
		return mapper.memberGetPassword(id);
	}
	
}
