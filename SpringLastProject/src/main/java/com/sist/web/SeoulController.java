package com.sist.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
@Controller
public class SeoulController {
	@GetMapping("seoul/location.do")
	public String seoul_location() {
		return "seoul/location";
	}
	@GetMapping("seoul/nature.do")
	public String seoul_nature() {
		return "seoul/nature";
	}
	@GetMapping("seoul/shop.do")
	public String seoul_shop() {
		return "seoul/shop";
	}
}
