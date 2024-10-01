package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.*;

@Repository
public class RecipeDAO {
	/*
	 * ~VO : 데이터형 => class
	 *                 ====== 관련된 데이터를 모아서 관리 (다른 데이터형을 모아서 처리)
	 *                 = 데이터형 클래스
	 *                 = 액션 클래스 (기능 => 메소드)
	 *                   ~DAO : @Repository, AOP
	 *                   ~Manager : @Component 
	 *                   ~Service : @Service : DAO 여러 개 통합해서 사용 (BI)
	 *                   ~Controller : @Controller
	 *                   ~RestController : @RestController

	 * ===================== 메모리 할당에서 제외 
	 */
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map){
		return mapper.recipeListData(map);
	}
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	public RecipeDetailVO recipeDetailData(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
}
