package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	/*
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
}
