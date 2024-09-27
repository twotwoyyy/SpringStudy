package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Dispatcher 
@RequestMapping("recipe/")
public class RecipeController {
	@GetMapping("list.do")
	// return은 반드시 => 파일명, .do => Router
	public String recipe_list() {
		
		return "recipe/list";
	}
	
	@GetMapping("detail.do")
	public String recipe_detail(int no, Model model) {
		model.addAttribute("no",no);
		return "recipe/detail";
	}
}
