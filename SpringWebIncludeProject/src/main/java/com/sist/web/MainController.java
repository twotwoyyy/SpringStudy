package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// HandlerMapping => @Controller : DispatcherServlet 연결
// 요청을 받아서 => 데이터베이스 연동 => JSP 결과값 전송 ==> Model
// 전체 프로그램의 조립기 (main)
/*
 *	요청 => 요청 분리 (구분)
 *        @RequestMapping ======> POST/GET 동시 처리시 => 검색 (PostMapping) <form>, 검색 안 페이지 나누기 (GetMapping) <a>  
 *            | Spring 6에서 제거 
 *          = @GetMapping
 *          = @PostMapping
 *     ----------------------------------------------------------------------
 *      => 요청하는 데이터 
 *         사용자가 보내준 데이터 
 *          ex) 상세보기 => (번호)
 *              로그인 => (id,pwd)
 *              검색 => (검색어)
 *              목록 => (페이지)
 *              ======================= getParameter() ===> 매개변수
 *      => 요청 결과 전송 : Model (전송 객체를 이용)
 *    ------------------------------------------------------------------------
 *    < 동작 순서, 코딩 순서>
 *    JSP => 요청 
 *           === <a>, <form> => .do 
 *    Controller 
 *    => @GetMapping(".do")
 *    Mapper 
 *    => SQL 문장
 *    DAO
 *    => SQL 구현
 *    Controller
 *    => DAO 호출 
 *    => Model에 담아준다 
 *    JSP 
 *    => 출력
 */
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.service.*;
import com.sist.vo.*;
@Controller
// Mapper = DAO = Service = Model => 결합성이 낮게 => 유지 보수 편리
// Controller 집중
public class MainController {
	@Autowired
	private RecipeService rService; // DAO 동시 처리 => BI (관련된 기능 통합)
	
	@GetMapping("main/main.do")
	public String main_main(String page, Model model, HttpServletRequest request) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<RecipeVO> list=rService.recipeListData(map);
		
		int count=rService.recipeRowCount();
		int totalpage=(int)(Math.ceil(count/20.0));
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		// cookie 출력 (request 받아야함)
		Cookie[] cookies=request.getCookies();
		List<RecipeVO> cList=new ArrayList<RecipeVO>(); // 쿠키 담는 List
		if(cookies!=null) {
			// 최신부터 담기
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("recipe_")) {
					String no=cookies[i].getValue();
					RecipeVO vo=rService.recipeCookieInfoData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		model.addAttribute("cList",cList);
		model.addAttribute("size",cList.size());
		// include할 JSP 지정 
		model.addAttribute("main_jsp","../main/home.jsp");
		return "main/main";
	}
	
}
