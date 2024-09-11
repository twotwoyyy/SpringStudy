package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("admin/admin_main.do")
	public String admin_main() {
		return "admin";
	}
	
	@GetMapping("admin/admin_member.do")
	public String admin_member() {
		return "admin/admin_member";
	}
	@GetMapping("admin/admin_jjim.do")
	public String admin_jjim() {
		return "admin/admin_jjim";
	}
}
