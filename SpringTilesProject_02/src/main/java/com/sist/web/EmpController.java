package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Controller
public class EmpController {
	// 스프링에서 객체 주소를 받을 경우 (스프링 => 클래스 관리자) => 메소드 안에서는 받을 수 없다
	// 필요한 객체는 멤버로 받는다 => Service, DAO, Manager
	@Autowired // 스프링에서 객체에 맞는 주소를 자동으로 주입 => 스프링은 싱글턴을 사용 = 재사용
	private EmpDAO eDao;
	
	// 사용자 요청별로 처리 => @GetMapping / @PostMapping / @RequestMapping 
	
	// 웹 (사용자 요청값 => 요청 처리(데이터베이스 연결) => 보내주는 값
	//     매개변수        MyBatis                   addAttribute() 
	// 장바구니 => id, 상품번호, 수량
	// 펀딩    => id, 펀딩번호, 기부 
	@GetMapping("emp/list.do")
	// <form>, ajax만 @PostMapping => 보안 필요 (로그인, 회원가입, 데이터를 많이 전송하는 경우)
	public String emp_list(Model model) {
		// 데이터베이스 연동 => Mapper (선언/자동구현)=> DAO
		List<EmpVO> list=eDao.empListData();
		model.addAttribute("list",list);
		return "emp/list";
	}
	
	@GetMapping("emp/detail.do")
	public String emp_detail(int empno, Model model) {
		EmpVO vo=eDao.empDetailData(empno);
		model.addAttribute("vo",vo);
		return "emp/detail";
	}
}
