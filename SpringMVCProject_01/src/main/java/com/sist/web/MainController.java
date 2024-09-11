package com.sist.web;
/*          .do                     매개변수
 *	브라우저 ====== DispatcherSevlet ======= Model ======> Model 관리자 
 *                  Controller              처리
 *                                        =======
 *                                           |
 *                                        =======
 *                                        JSP 관리 => JSP 찾아서 request 전송 => ViewResolver
 *                                        =======
 *                                           |
 *                                     JSP로 전송 (View)
 *                                     
 *	1. DispatcherServlet : 사용자의 요청을 받아서 처리할 데이터를 넘겨주는 역할 
 *  2. HandlerMapping : DispatcherServlet으로부터 받은 데이터를 받아서 처리 => 
 *                      request에 담아서 전송 => Model, @Controller : DispatcherServlet => 의임 받아 처리 
 *                      => 기능 수행하는 메소드를 찾기
 *                      구분자 : @GetMapping / @PostMapping / @RequestMapping
 *  3. ViewResolver : request를 받아서 JSP를 찾고 전송 
 *                    => JSP의 경로명 지정 : prefix=""
 *                    => 확장자 : suffix="확장자" => 스프링은 자바 전용이 아니다
 *                       ASPX 
 *  4. View(JSP) : 화면 출력 (개발자 담당) 
 *  
 *  ======================================================================
 *   개발자 담당 
 *    = Model(@Controller) => Model : DAO, Service, VO, Manager ...
 *    = JSP 
 *    = 웹 = 지능형 웹 (AI) ***
 *          ============
 *          | 화면 출력에 대한 속도 (Front) => AngularJS / Vue / React => Ajax를 대체하는 Front
 *   스프링 
 *    = DI
 *      => 개발자가 만든 클래스 / 라이브러리 클래스를 제어
 *         1. 클래스 : 멤버변수에 대한 초기화
 *                   명시적 초기화 : 개발자
 *                   class A{
 *                   	int a=10;
 *                   }
 *                   = 생성자 => c:
 *                   = setter => p:
 *                반복 / => AOP를 이용해서 자동 호출
 *                핵심 / => 코딩을 한다 
 *    = AOP : 공통적으로 사용하는 기능을 자동으로 호출이 가능 => 공통 모듈 
 *            메소드 위치 
 *            public void dbInsert(){
 *            	try{
 *            		getConnection() => BEFORE	
 *            		conn.setAutoCommit(false); => Around
 *            		insert
 *            		insert
 *            		conn.commit() => Around
 *            	}catch(Exception ex){
 *					ex.printStackTrace() => after-
 *					conn.rollback()            	
 *            	}finally{
 *            		conn.setAutoCommit(true) => after
 *            		disConnection()
 *            	}
 *            	return => 정상 수행 했을 때 처리 
 *            }
 *    = MVC : 분리해서 작업 
 *            Front = Back 
 *                    Model = DAO
 *              |       |      |
 *             view   server  db
 *    = Interceptor 
 *    
 *    사용 요청 ========= DispatcherServlet ========== HandlerMapping 
 *                                                        | ===> 인터셉트 ===> 자동 로그인 
 *                                                  ===============
 *                                                   개발자 : Model
 *                                                  ===============
 *                                                        | ===> 인터셉트 
 *                                                    ViewResolver
 *                                                        | ===> 인터셉트 
 *                                                  ===============
 *                                                     개발자 JSP
 *                                                  ===============
 *   ======================= SrpingFrameWork
 *   = security
 *   = batch : 스케줄러 
 *   = data : 분석 
 *   
 *   1. 라이브러리 추가 : pom.xml / gradle : boot에서 주로 사용 
 *                             properties 
 *                      | maven 
 *   2. 버전 변경 : 기본 1.6 ==> 1.8 이상
 *   3. web.xml 변경 
 *   4. 패키지 => 클래스 
 *   5. 메모리 할당 요청 
 *      => application.xml
 *   6. 클래스마다 어노테이션 올리기
 *   7. DB연동 
 *   8. JSP에서 화면 출력 
 *   
 *   => 4,6,7,8
 *      휴먼 컨설팅 / 드림씨아이에스 / 웨이버스 / 엠노 / 교보정보통신
 *      
 *   
 */
public class MainController {

}
