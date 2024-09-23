package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 화면만 변경
@Controller
public class DataBoardController {
	@GetMapping("databoard/list.do")
	public String databoard_list() {
		return "databoard/list";
	}
}	
