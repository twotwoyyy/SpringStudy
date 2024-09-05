package com.sist.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   JSP = Controller = Service = Repository = 오라클 
 *   = 오라클 = Repository = Service = Controller = JSP 
 */
@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO dao;

	@Override
	public List<RecipeVO> recipeListData(Map map) {
		return dao.recipeListData(map);
	}

	@Override
	public int recipeRowCount() {
		return dao.recipeRowCount();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		return dao.recipeDetailData(no);
	}

	@Override
	public List<ChefVO> chefListData(Map map) {
		return dao.chefListData(map);
	}

	@Override
	public int chefTotalPage() {
		return dao.chefTotalPage();
	}

	@Override
	public List<RecipeVO> chefMakeRecipeData(Map map) {
		return dao.chefMakeRecipeData(map);
	}

	@Override
	public int chefMakeRecipeTotalPage(String chef) {
		return dao.chefMakeRecipeTotalPage(chef);
	}

	@Override
	public RecipeVO recipeCookieInfoData(int no) {
		return dao.recipeCookieInfoData(no);
	}
}
