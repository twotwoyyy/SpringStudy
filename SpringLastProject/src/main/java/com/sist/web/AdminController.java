package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("admin/admin_main.do")
	public String admin_main() {
		return "admin";
	}
	@GetMapping("admin/admin_reserve.do")
	public String admin_reserve() {
		return "admin/admin_reserve";
	}
}
