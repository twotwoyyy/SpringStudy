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
	
	/*
	 * 	@Select("SELECT no,title,chef,poster,num "
			+"FROM (SELECT no,title,chef,poster,rownum as num "
			+"FROM (SELECT no,title,chef,poster "
			+"FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail))) "
			+"WHERE no BETWEEN #{start} AND #{end}")
		public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)")
		public int recipeTotalPage();
	 */
	public List<RecipeVO> recipeListData(int start,int end){
		return mapper.recipeListData(start, end);
	}
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	/*
	 * 	@Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
		public void recipeHitIncrement(int no);
		@Select("SELECT * FROM recipeDetail WHERE no=#{no}")
		public RecipeVO recipeDetailData(int no);
	 */
	public RecipeVO recipeDetailData(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
	
}
