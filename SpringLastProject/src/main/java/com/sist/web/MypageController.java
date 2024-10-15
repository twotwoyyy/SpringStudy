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
	public String mypage_reserve() {
		return "mypage/mypage_reserve";
	}
	@GetMapping("mypage/mypage_cart.do")
	public String mypage_cart() {
		return "mypage/mypage_cart";
	}
	@GetMapping("mypage/mypage_buy.do")
	public String mypage_buy() {
		return "mypage/mypage_buy";
	}
}
