package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 *   1. 스프링 Annotation
 *       = 메모리 할당 => 스프링의 클래스 관리
 *                            ========== 생성부터 소멸까지 담당 => 필요시에는 주소값을 얻어서 사용
 *         구분 
 *         DAO ========> @Repository : 저장소, 데이터베이스와 연결 
 *         Service ====> @Service : BI (DAO 여러 개를 통합)
 *         Model ======> @Controller : 화면 제어 
 *                       @RestController : 다른 언어와 연결(자바 스크립트, 코틀린) => JSON
 *         Exception ==> @ControllerAdvice / RestControllerAdvice : 공통 예외 처리 => 모든 모델 클래스의 예외처리를 한번에 처리
 *         일반클래스  ==> @Component : OpenAPI
 *         
 *       = 모든 클래스를 메모리 할당 요청하지는 않는다 
 *         ~VO : 사용자 정의 데이터형 
 *         인터페이스는 메모리 할당하지 않는다 
 *       = 공통으로 사용되는 기능을 모아서 관리 => 공통 모듈 : @Aspact => AOP
 *       = 자바로 환경 설정시 : @Bean 
 *       = React 연결 : 포트 번호가 다르기 때문에 (서버 연결 어려움) => 포트 허용해야 한다
 *       = 보안 / 스케줄러 
 */
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper; // 스프링에서 구현된 객체 주소를 받는다 => 자동 주입 
	
	/*
	 * 	@Select("SELECT fno,name,poster,num "
			+"FROM (SELECT fno,name,poster,rownum as num "
			+"FROM (SELECT fno,name,poster "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodListData(@Param("start")int start, @Param("end")int end);
		
		@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
		public int foodTotalPage();
	 */
	public List<FoodVO> foodListData(int start,int end){
		return mapper.foodListData(start, end);
	}
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	// 검색
	/*	@Select("SELECT fno,name,poster,num "
			+"FROM (SELECT fno,name,poster,rownum as num "
			+"FROM (SELECT fno,name,poster "
			+"FROM project_food_house WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodFindListData(Map map);
		
		// 여러 개의 매개 변수 => @Param, Map, VO
		@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house WHERE address LIKE '%'||#{address}||'%'")
		public int foodFindTotalPage(Map map);
	 * 
	 */
	public List<FoodVO> foodFindListData(Map map){
		return mapper.foodFindListData(map);
	}
	public int foodFindTotalPage(Map map) {
		return mapper.foodFindTotalPage(map);
	}
}
