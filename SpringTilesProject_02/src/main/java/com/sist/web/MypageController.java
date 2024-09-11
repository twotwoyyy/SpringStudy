package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MypageController {
	@GetMapping("mypage/mypage_main.do")
	public String mypage_main() {
		return "mypage";
	}
	
	@GetMapping("mypage/mypage_joinupdate.do")
	public String mypage_update() {
		return "mypage/mypage_joinupdate";
	}
	@GetMapping("mypage/mypage_jjim.do")
	public String mypage_jjim() {
		return "mypage/mypage_jjim";
	}

}
