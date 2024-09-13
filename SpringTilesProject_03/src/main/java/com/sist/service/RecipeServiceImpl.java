package com.sist.service;

import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO rDao;
	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(start, end);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}

	@Override
	public RecipeVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return rDao.recipeDetailData(no);
	}

}
