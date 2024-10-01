package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface RecipeMapper {	
	@Select("SELECT no,poster,title,chef,hit,num "
			+"FROM (SELECT no,poster,title,chef,hit,rownum as num "
			+"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title,chef,hit "
			+"FROM recipe WHERE no IN(SELECT no FROM recipe "
			+"INTERSECT SELECT no FROM recipedetail))) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeTotalPage();
	
	// 상세 보기 
	@Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT * FROM recipedetail WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	
}
