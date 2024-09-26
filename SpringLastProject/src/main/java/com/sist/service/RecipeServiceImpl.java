package com.sist.service;

import java.util.List;

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
	
}
