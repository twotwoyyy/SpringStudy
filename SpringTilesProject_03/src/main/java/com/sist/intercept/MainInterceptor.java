package com.sist.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// => main.do => login (자동 로그인)
/*
 *			Front Controller : 요청 받기, 결과값 전송
 *          => 기능 처리에 대한 위임 => @Controller 
 *    main.do ======= DispatcherServlet ======== HandlerMapping(Model 찾기)
 *                                                | Annotation 
 *                                          ======| Model 찾기 전
 *                                          preHandle() => 처리할 수 있는 인터셉트 
 *                                               @GetMapping("main.do")
 *                                               @PostMapping
 *                                               @RequestMapping
 *                                                |
 *                                               return "main/main"
 *                                                | ==> postHandle() => 자동 로그인 (쿠키 읽기)
 *                                               ViewResolver(JSP 찾기 => request)
 *                                                | request
 *                                                | ==> afterCompletion() => 권한별 처리 
 *                                               JSP
 */
public class MainInterceptor extends HandlerInterceptorAdapter{
	
    // GetMapping,PostMapping,RequestMapping 찾기 전에 수행 문장이 있는 경우 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("======= preHandle() Call =======");
		return super.preHandle(request, response, handler);
	}
	
	// 수행 후에 return "main/main" => viewResolver 로 전송하기 전 (가장 많이 쓰임) : 권한 처리, 자동 로그인 (보안), ID 저장 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("======= postHandle() Call =======");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// ViewResolver => JSP로 request를 넘기기 전 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("======= afterCompletion() Call =======");
		super.afterCompletion(request, response, handler, ex);
	}

}
