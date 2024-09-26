package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
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
}
