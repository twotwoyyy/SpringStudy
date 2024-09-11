package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;

	public List<RecipeVO> recipeListData(Map map)
	{
		return mapper.recipeListData(map);
	}

	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	/*
	 *    @Update("UPDATE recipe SET "
		   +"hit=hit+1 "
		   +"WHERE no=#{no}")
	      public void hitIncrement(int no);
	 *    @Select("SELECT * FROM recipeDetail WHERE no=#{no}")
	      public RecipeDetailVO recipeDetailData(int no);
	 */
	public RecipeDetailVO recipeDetailData(int no)
	{
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}

	public List<RecipeVO> recipeFindData(Map map)
	{
		return mapper.recipeFindData(map);//동적쿼리 
	}
	/*
	 *  @Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe "
		   +"WHERE no IN(SELECT no FROM recipe INTERSECT (SELECT no FROM recipeDetail)) "
		   +"AND title LIKE '%'||#{fd}||'%'")
         public int recipeFindTotalPage(Map map);
	 */
	public int recipeFindTotalPage(Map map)
	{
		return mapper.recipeFindTotalPage(map);
	}
	/*
	 * 	public List<ChefVO> chefListData(Map map);

	   @Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
	   public int chefTotalPage();
	 */
	public List<ChefVO> chefListData(Map map)
	{
		return mapper.chefListData(map);
	}
	public int chefTotalPage()
	{
		return mapper.chefTotalPage();
	}
	
	public List<RecipeVO> chefMakeData(Map map){
		return mapper.chefMakeData(map);
	}
	
	public int chefMakeTotalPage(Map map) {
		return mapper.chefMakeTotalPage(map);
	}
}