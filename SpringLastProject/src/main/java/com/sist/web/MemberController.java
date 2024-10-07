package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.MemberService;
import com.sist.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("member/join.do")
	public String member_join() {
		return "member/join";
	}
	
	@PostMapping("member/join_ok.do")
	public String member_join_ok(MemberVO vo) {
		System.out.println(vo);
		vo.setPhone(vo.getPhone1()+"-"+vo.getPhone2());
		// 비밀번호 암호화
		String enPwd=encoder.encode(vo.getUserPwd());
		vo.setUserPwd(enPwd);
		mService.memberInsert(vo);
		mService.memberAuthorityInsert(vo.getUserId());
		// insert / insert 
		return "redirect:../main/main.do";
	}
	
	@RequestMapping("member/login.do")
	public String member_login() {

		return "member/login";
	}
}
