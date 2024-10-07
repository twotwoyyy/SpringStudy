package com.sist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sist.service.MemberService;
import com.sist.vo.*;
import lombok.Setter;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Setter
    private String defaultUrl;
    
    @Autowired 
    private MemberService mService;
    
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		MemberVO vo=mService.memberSessionData(authentication.getName());
		HttpSession session=request.getSession();
		session.setAttribute("userId", vo.getUserId());
		session.setAttribute("userName", vo.getUserName());
		session.setAttribute("sex", vo.getSex());
		session.setAttribute("address", vo.getAddr1()+" "+vo.getAddr2());
		session.setAttribute("phone", vo.getPhone());
		session.setAttribute("email", vo.getEmail());
		
		response.sendRedirect("../main/main.do");
	}

}