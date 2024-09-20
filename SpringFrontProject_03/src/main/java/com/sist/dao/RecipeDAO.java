package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.google.auto.service.AutoService;
import com.sist.mapper.RecipeMapper;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
	@Autowired
	public RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map){
		return mapper.recipeListData(map);
	}
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	
	public RecipeDetailVO recipeDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.recipeDetailData(no);
	}
}
