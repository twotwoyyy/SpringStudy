package com.sist.mapper;
import java.util.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface RecipeMapper {
	// 목록 출력
	@Select("SELECT no,title,poster,chef,num "
			+"FROM (SELECT no,title,poster,chef,rownum as num "
			+"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title,poster,chef "
			+"FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT COUNT(*) FROM recipe "
			+"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeRowCount();
	
	// 상세보기
	@Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT * FROM recipedetail WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	// chef 목록 출력 
	@Select("SELECT chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7,num "
			+"FROM (SELECT chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7,rownum as num "
			+"FROM (SELECT chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7 "
			+"FROM chef)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/50.0) FROM chef")
	public int chefTotalPage();

	// chef 상세 보기	
	@Select("SELECT no,title,poster,chef,num "
			+"FROM (SELECT no,title,poster,chef,rownum as num "
			+"FROM (SELECT no,title,poster,chef "
			+"FROM recipe WHERE chef=#{chef} ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> chefMakeRecipeData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe WHERE chef=#{chef}")
	public int chefMakeRecipeTotalPage(String chef);
	// recipe 찾기 (검색)
	@Select("SELECT no,title,poster,chef,num "
			+"FROM (SELECT no,title,poster,chef,rownum as num "
			+"FROM (SELECT no,title,poster,chef "
			+"FROM recipe WHERE title LIKE '%'||#{fd}||'%' "
			+"AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail) "
			+"ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeFindData(Map map);
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe "
			+"WHERE title LIKE '%'||#{fd}||'%' "
			+"AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeFindTotalPage(Map map);
	
	// cookie 정보 데이터
	@Select("SELECT no,title,poster FROM recipe WHERE no=#{no}")
	public RecipeVO recipeCookieInfoData(int no);
	// 1. 인기 맛집 
	@Select("SELECT fno,name,rownum "
			+"FROM (SELECT fno,name FROM project_food_house ORDER BY hit DESC) "
			+"WHERE rownum<=5")
	public List<FoodVO> foodTop5Data();
	// 2. 인기 레시피 
	@Select("SELECT no,title,rownum "
			+"FROM (SELECT no,title FROM recipe ORDER BY hit DESC) "
			+"WHERE rownum<=5")
	public List<RecipeVO> recipeTop5Data();
	// 3. 인기 게시물 
}
