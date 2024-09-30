package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("food/")
public class FoodController {
	@GetMapping("login.do")
	public String food_login() {
		return "food/list";
	}
	
	@GetMapping("list.do")
	public String food_list() {
		return "food/list";
	}
}
