package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import java.util.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	/*  <리스트>
	 * 	@Select("SELECT no,title,poster,chef,num "
			+"FROM (SELECT no,title,poster,chef,rownum as num "
			+"FROM (SELECT no,title,poster,chef "
			+"FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<RecipeVO> recipeListData(Map map);
		
		@Select("SELECT COUNT(*) FROM recipe "
				+"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
		public int recipeRowCount();
	 */
	public List<RecipeVO> recipeListData(Map map){
		return mapper.recipeListData(map);
	}
	public int recipeRowCount() {
		return mapper.recipeRowCount();
	}
	
	/*  <상세보기>
	 * 	@Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
		public void recipeHitIncrement(int no);
		
		@Select("SELECT * FROM recipedetail WHERE no=#{no}")
		public RecipeDetailVO recipeDetailData(int no);
	 */
	public RecipeDetailVO recipeDetailData(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
	/* <chef 목록>
	 * 	@Select("SELECT chef,poster,mem_cont1,meme_cont2,mem_cont3,mem_cont7,num "
			+"FROM (SELECT chef,poster,mem_cont1,meme_cont2,mem_cont3,mem_cont7,rownum as num "
			+"FROM (SELECT chef,poster,mem_cont1,meme_cont2,mem_cont3,mem_cont7 "
			+"FROM chef)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<ChefVO> chefListData(Map map);
		

	 */
	public List<ChefVO> chefListData(Map map){
		
		return mapper.chefListData(map);
	}
	/*
	 * 	@Select("SELECT CEIL(COUNT(*)/50.0) FROM chef")
		public int chefTotalPage();
	 */
	public int chefTotalPage() {
		return mapper.chefTotalPage();
	}
	
	// <chef 상세> 
	/*
	 * 	@Select("SELECT no,title,poster,chef,num "
			+"FROM (SELECT no,title,poster,chef,rownum as num "
			+"FROM (SELECT no,title,poster,chef "
			+"FROM recipe WHERE chef=#{chef} ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
		public List<RecipeVO> chefMakeRecipeData(Map map);
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe WHERE chef=#{chef}")
		public int chefMakeRecipeTotalPage(String chef);
	 */
	public List<RecipeVO> chefMakeRecipeData(Map map){
		return mapper.chefMakeRecipeData(map);
	}
	public int chefMakeRecipeTotalPage(String chef) {
		return mapper.chefMakeRecipeTotalPage(chef);
	}
	
	// cookie 출력 데이터
	/*
	 * 	@Select("SELECT no,title,poster FROM recipe WHERE no=#{no}")
		public RecipeVO recipeCookieInfoData(int no);
	 */
	public RecipeVO recipeCookieInfoData(int no) {
		return mapper.recipeCookieInfoData(no);
	}
	
}
