package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;

@Controller
public class RecipeController {
	@Autowired
	private RecipeService rService;
	
	@GetMapping("recipe/list.do")
	public String recipe_list(String page,Model model) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		List<RecipeVO> list=rService.recipeListData(start, end);
		int totalpage=rService.recipeTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("menu", "레시피 목록");
		return "recipe/list";
	}
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(Model model) {
		
		return "recipe/detail";
	}
}
