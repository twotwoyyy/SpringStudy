package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("food/")
public class FoodController {
	@GetMapping("list.do")
	public String food_list() {
		return "food/list";
	}
	
	@GetMapping("detail_before.do")
	// 원래는 session에서 id를 가져와서 그 id가 방문한 cookie만 출력되게 해야한다 id+"food_"+fno...
	public String food_detail_before(int fno, HttpServletResponse response, RedirectAttributes ra) {
		// forward => Model 이용해서 데이터 전송
		// redirect => RedirectAttributes 이용해서 데이터 전송
		// cookie
		Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
		cookie.setMaxAge(60*60*24);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		ra.addAttribute("fno",fno); // ?fno=1
		return "redirect:../food/detail.do";
	}
	// response는 한 가지 일만 수행 
	// => HTML / Cookie 
	// 그래서 detail_before, detail 따로 작업하는 것임
	@GetMapping("detail.do")
	public String food_detail(int fno, Model model) {
		
		model.addAttribute("fno",fno);
		return "food/detail";
	}

}
