package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {
	@Autowired
	RecipeMapper mapper;
	public RecipeVO recipeMaxHitData() {
		return mapper.recipeMaxHitData();
	}
	public List<RecipeVO> recipeHitTop8(){
		
		return mapper.recipeHitTop8();
	}
	
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
	public List<RecipeVO> recipeMakeData(String chef){
		return mapper.recipeMakeData(chef);
	}
}
