package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface RecipeMapper {
	// 가장 HIT가 높은 RECIPE
	@Select("SELECT no,title,poster,chef,hit,(SELECT content FROM recipedetail WHERE no=recipe.no) as content "
			+ "FROM recipe "
			+ "WHERE hit=(SELECT MAX(hit) FROM recipe)")
	public RecipeVO recipeMaxHitData();
	
//	@Select("SELECT no,title,poster,chef,hit,content,rownum "
//			+"FROM (SELECT no,title,poster,chef,hit,"
//			+"(SELECT content FROM recipedetail WHERE no=recipe.no) as content "
//			+"FROM recipe ORDER BY hit DESC) "
//			+"WHERE rownum<=8")
//	public List<RecipeVO> recipeHitTop8();
	   
	@Select("SELECT no, title, poster, chef, hit, content "
			+ "FROM (SELECT r.no, r.title, r.poster, r.chef, r.hit, rd.content "
			+ "FROM recipe r "
			+ "JOIN recipedetail rd ON r.no = rd.no "
			+ "ORDER BY r.hit DESC)"
			+ "WHERE ROWNUM<=8 AND hit!=(SELECT MAX(hit) FROM recipe)")
	public List<RecipeVO> recipeHitTop8();
}
