package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface RecipeMapper {
  /*
   *   <select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
	     SELECT no,title,poster,chef,num
	     FROM (SELECT no,title,poster,chef,rownum as num 
	     FROM (SELECT no,title,poster,chef 
	     FROM recipe ORDER BY no ASC))
	     WHERE num BETWEEN #{start} AND #{end}
	   </select>
	   
	   = 조인 
   */
	public List<RecipeVO> recipeListData(Map map);
	
	/*
	 *   <select id="recipeFindData" resultType="RecipeVO" parameterType="hashmap">
	 */
	public List<RecipeVO> recipeFindData(Map map);
	
	/* 
	 *  <select id="chefListData" resultType="ChefVO" parameterType="hashmap">
	 */
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
	public int chefTotalPage();
	
	public List<RecipeVO> chefMakeData(Map map);
	
	/*
	 * <select id="chefMakeTotalPage" resultType="int" parameterType="hashmap">
	 */
	public int chefMakeTotalPage(Map map);
	
	/*
	 *   XML혼합 
	 *   => id명 => 메소드명 
	 *    resultType => 리턴형 
	 *    parameterType => 매개변수 
	 *    
	 *   => SQL문장이 복잡한 경우 
	 *      1. 페이지 나누기 
	 *      2. 조인 
	 *      3. 서브쿼리 
	 *      4. 컬럼명이 많은 경우 => NVL
	 */
	
	@Update("UPDATE recipe SET "
		   +"hit=hit+1 "
		   +"WHERE no=#{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT * FROM recipeDetail WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe "
		   +"WHERE no IN(SELECT no FROM recipe INTERSECT (SELECT no FROM recipeDetail))")
	public int recipeTotalPage();
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe "
		   +"WHERE no IN(SELECT no FROM recipe INTERSECT (SELECT no FROM recipeDetail)) "
		   +"AND title LIKE '%'||#{fd}||'%'")
    public int recipeFindTotalPage(Map map);
}