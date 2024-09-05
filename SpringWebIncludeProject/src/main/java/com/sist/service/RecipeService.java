package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

// 모아주기 
public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeRowCount();
	public RecipeDetailVO recipeDetailData(int no);
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage();
	public List<RecipeVO> chefMakeRecipeData(Map map);
	public int chefMakeRecipeTotalPage(String chef);
	public RecipeVO recipeCookieInfoData(int no);
}
