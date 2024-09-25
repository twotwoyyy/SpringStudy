package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 화면만 변경
@Controller
public class FoodController {
	@GetMapping("food/list.do")
	public String food_list() {
		return "food/list";
	}
	
	@GetMapping("food/detail.do")
	public String food_detail(int fno, int page, Model model) {
		model.addAttribute("fno",fno);
		model.addAttribute("page",page);
		return "food/detail";
	}
}
