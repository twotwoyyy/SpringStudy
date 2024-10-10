package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freeboard/")
/*
 *	화면 변경 : request를 전송 => forward => "경로/파일명"
 *           request를 초기화 후 화면 변경 => redirect => .do
 *           ==> _ok.do : INSERT / UPDATE / DELETE
 *                       => 서버에서 지정
 */
public class FreeBoardController {
	@GetMapping("list.do")
	public String freeboard_list() {
		return "freeboard/list";
	}
	
	@GetMapping("insert.do")
	public String freeboard_insert() {
		return "freeboard/insert";
	}
	
	@GetMapping("detail.do")
	public String freeboard_detail(int no,Model model,HttpSession session) {
		String sessionId=(String)session.getAttribute("userId");
		// sessionId로 게시글 구분하여 해당 사용자만 자신의 글을 삭제할 수 있도록
		model.addAttribute("no",no);
		model.addAttribute("sessionId",sessionId);
		return "freeboard/detail";
	}
	@GetMapping("update.do")
	public String freeboard_update(int no,Model model) {
		model.addAttribute("no",no);
		return "freeboard/update";
	}
}
