package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 화면만 변경
@Controller
public class DataBoardController {
	// Vue / React => 자체 처리 => Route
	// Spring-Boot : ThymeLeaf:Html
	// ================== 순수하게 서버 
	// CDN => 브라우저에서 제어 => 서버
	@GetMapping("databoard/list.do")
	public String databoard_list() {
		return "databoard/list";
	}
	
	@GetMapping("databoard/insert.do")
	public String databoard_insert() {
		return "databoard/insert";
	}
	
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no, Model model) {
		model.addAttribute("no",no); //${no}
		return "databoard/detail";
	}
	
	@GetMapping("databoard/update.do")
	public String databoard_update(int no, Model model) {
		model.addAttribute("no",no);
		return "databoard/update";
	}
}	
