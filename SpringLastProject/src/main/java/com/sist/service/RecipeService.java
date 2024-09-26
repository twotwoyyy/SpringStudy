package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.dao.*;
import com.sist.vo.*;

public interface RecipeService {
	public RecipeVO recipeMaxHitData();
	public List<RecipeVO> recipeHitTop8();
	public ChefVO chefToday();
}
