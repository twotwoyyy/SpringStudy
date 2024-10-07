package com.sist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Setter;

public class LoginFailureHandler implements AuthenticationFailureHandler{
	@Setter
	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	        AuthenticationException exception) throws IOException, ServletException {
		
		
	    String errorMsg = "로그인 실패";

	    if (exception instanceof BadCredentialsException) {
	        errorMsg = "아이디 또는 비밀번호가 잘못되었습니다.";
	    } else if (exception instanceof DisabledException) {
	        errorMsg = "계정이 비활성화되었습니다.";
	    }

	    request.setAttribute("message", errorMsg);
	    request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}
}
