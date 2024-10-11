package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 *   정리
 *   스프링
 *    = DI => 스프링은 클래스를 관리하는 영역
 *                  ==========
 *                  1) 클래스 한 개 : Component 
 *                  2) 클래스 여러 개 : Container
 *                     "스프링은 컨테이너다" => 클래스로 제작됨 : 경량 컨테이너
 *      == 클래스를 관리하기 위해서는 객체 생성 / 객체 소멸 (객체 생명주기 관리)
 *      == 객체 생성시에 멤버 변수의 초기화 필요시 사용 
 *      == 변수의 초기화 
 *         ========== setterDI => p:
 *         ========== 생성자 DI => c: 
 *    = AOP : 공통 모듈 => 실행 시마다 호출하는 기능이 있는 경우에 자동 호출이 가능 
 *            => 사용자 정의보다는 트랜잭션 / 보안 / 로그 
 *    = MVC : 웹 => 라이브러리 
 *      ====================
 *    = 라이브러리 : 있는 그대로 사용 => 사용법 / 어떤 기능 / 찾기 
 *      ======= 수정하지 않고 사용 (ORM => 마이바티스)
 *      
 *    =============================================================
 *    MVC 
 *      Model : @Controller / @RestController 
 *              => 사용자의 요청을 받아서 처리 결과를 JSP로 전송하는 역할
 *                                            ==== @Controller
 *                                            ==== 자바스크립트 => @RestController
 *      => 관리 : HandlerMapping => 해당 메소드를 찾기
 *      View : JSP (HTML)
 *       ViewResolver => JSP를 찾아서 request를 전송
 *      Controller : 사용자 요청을 받는 클래스 => 이미 스프링에서 제공
 *                   => DispatcherServlet : 메뉴얼만 제작
 *                   => web.xml
 *      WebApplicationContext : 사용자정의 클래스 관리
 *                  => 클래스를 등록 
 *                     application-context.xml
 *                     application-datasource.xml
 *                     application-security.xml
 *                  => 넘겨주는 방법
 *                     <init-param>
 *                     	<param-name>contextConfigLocation</param-name>
 *                     	<param-value>/WEB-INF/config/application-*.xml</param-value>
 *                     </init-param>
 *                                                      요청 처리하는 메소드 찾기
 *                                                       => @GetMapping(URI)
 *                                                       => @PostMapping(URI)
 *                                                       => @RequestMapping(URI)
 *           사용자 요청 => DispatcherServlet => HandlerMapping => Model 처리
 *                                                                 |
 *                                                             ViewResolver
 *                                                              = p:prefix => 경로명
 *                                                              = p:suffix => 확장자
 *                                                                 | request
 *                                                                JSP
 *          .do
 *          요청에 대한 처리
 *          =============
 *          1) 데이터베이스 (myBatis) ===> DAO / Service 
 *                                    테이블 1개  관련된 DAO 여러 개 묶어 처리
 *          2) 외부 API 이용 (날씨,뉴스,메일..)  
 *          3) 전송 
 *             redirect : 기존에 있는 메소드를 재호출  _ok (DML => insert / update / delete)
 *               => return "redirect:list.do"
 *             forward : 해당 데이터 전송 (select)
 *               => return "경로/파일명"
 *          
 *          화면 출력
 *          =======
 *           1) JSP => EL/JSTL
 *           2) 자바스크립트 : Ajax / VueJS / ReactJS
 *                  |
 *                List => []
 *                VO   => {}
 *                =========== JSON (jackson)
 *                일반 데이터형 : 정수/실수/논리/문자
 *                
 *        => 기본 동작 
 *        => 설정 : xml 파일 
 *        => Model / DAO / Service / JSP
 *        => 기본 이론 : 면접 => 실무는 구현 
 *    
 */
// jsp연동 
import java.util.*;

import com.sist.service.*;
import com.sist.vo.*;
@Controller
public class MainController {
   // 필요한 클래스 => 스프링에서 가지고 온다 (객체 주소)
	@Autowired
	private RecipeService rService;
	@Autowired
	private FoodService fService;
	// 사용자에 요청 따라 => 처리 
   @GetMapping("main/main.do")
   public String main_main(Model model){
	   RecipeVO rvo=rService.recipeMaxHitData();
	   List<RecipeVO> rList=rService.recipeHitTop8();
	   List<FoodVO> fList=fService.foodHitTop5();
	   ChefVO cvo=rService.chefToday();
	   
	   model.addAttribute("cvo",cvo);
	   model.addAttribute("rvo",rvo);
	   model.addAttribute("rList",rList);
	   model.addAttribute("fList",fList);
	   return "main";
   }
   
   @GetMapping("chat/chat.do")
   public String chat_chat() {
	   return "site/chat/chat";
   }
   
}
