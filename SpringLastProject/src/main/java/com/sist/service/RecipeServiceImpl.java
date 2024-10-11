package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	RecipeDAO rDao;
	@Autowired
	ChefDAO cDao;
	
	@Override
	public RecipeVO recipeMaxHitData() {
		return rDao.recipeMaxHitData();
	}

	@Override
	public List<RecipeVO> recipeHitTop8() {
		return rDao.recipeHitTop8();
	}

	@Override
	public ChefVO chefToday() {
		return cDao.chefToday();
	}

	@Override
	public List<RecipeVO> recipeListData(Map map) {
		return rDao.recipeListData(map);
	}

	@Override
	public int recipeTotalPage() {
		return rDao.recipeTotalPage();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		return rDao.recipeDetailData(no);
	}

	@Override
	public List<ChefVO> chefListData(Map map) {
		return cDao.chefListData(map);
	}

	@Override
	public int chefTotalPage() {
		return cDao.chefTotalPage();
	}

	@Override
	public List<RecipeVO> recipeMakeData(String chef) {
		return rDao.recipeMakeData(chef);
	}
	
}
