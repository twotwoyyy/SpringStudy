package com.sist.web;

import javax.servlet.http.Cookie;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;
import com.sist.service.*;
@Controller
@RequestMapping("food/")
public class FoodController {
	@Autowired // 데이터베이스 연동
	private FoodService fService;
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
		FoodVO vo=fService.foodDetailData(fno);
		
		model.addAttribute("vo",vo);
//		model.addAttribute("fno",fno); vo 안에 들어있기 때문에 생략 
		return "food/detail";
	}
	
	@GetMapping("find.do")
	public String food_find() {
		return "food/find";
	}

}
