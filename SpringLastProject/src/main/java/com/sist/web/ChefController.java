package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChefController {
	/*
	 * 리턴형 
	 *  = String : 화면 변경 => forward/redirect
	 *  = void : download 처리
	 * 매개변수
	 *  = 일반 데이터형, VO, List, 배열, 내장 객체
	 *    ==============
	 *    | 전송되는 데이터명이 일치
	 *    
	 *    ?fno=1 => (int fno)
	 *     ===           ===
	 *    
	 *    ?no=1&name=..&... => (VO) 
	 *    대신 VO안에 이 모든 변수가 존재해야만 값을 받을 수 있다
	 *    
	 *    file[0]..배열 형식 => (List) 
	 *    checkbox => String[]
	 *     
	 *     내장 객체 
	 *       HttpServletRequest  => Cookie 읽기
	 *       HttpServletResponse => Cookie 전송 
	 *       HttpSession         => Login 처리
	 *       RedirectAttributes  => sendRedirect에 데이터를 전송
	 *       Model               => forward에서 전송 시에 사용 (전송 객체)
	 *       
	 *       ? => GET 
	 *       <form>, params:{}
	 */
	@GetMapping("chef/list.do")
	public String chef_list() {
		return "chef/make";
	}
}
