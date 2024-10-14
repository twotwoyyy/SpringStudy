package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	@GetMapping("mypage/mypage_main.do")
	public String mypage_main() {
		return "mypage";
	}
	@GetMapping("mypage/mypage_reserve.do")
	public String mupage_reserve() {
		return "mypage/mypage_reserve";
	}
}
