package com.sist.web;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@Async // 비동기적 처리 (속도 개선) 
	@GetMapping("main/main.do")
	public String main_main() {
		return "main";
	}
}
