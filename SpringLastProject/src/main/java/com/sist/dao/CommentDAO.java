package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.CommentMapper;
import com.sist.vo.CommentVO;
/*
 *	스프링에서 메모리 할당 ==> @Autowired
 *          =======
 *          1. @Component : 일반 클래스 (추천 = 네이버 API, 뉴스 읽기, 다른 프로그램 연동)
 *          2. @Repository : DAO (데이터베이스 연결)
 *          3. @Service : DAO 여러 개 연동 
 *                => Food / Reply 
 *          4. @Controller : DispatcherServlet와 연결 => 사이트 페이지 이동 
 *               => 1) forward : request를 JSP로 전송 (return "경로명/jsp명칭")
 *                     => 최근엔 request 대신 Model(전송 객체)로 변경 
 *                  2) redirect : 이미 만들어진 메소드 호출시에 사용 (_ok) => return "redirect:~.do"
 *          5. @RestController : DispatcherServlet와 연결 => 다른 프로그램과 연동할 때 사용 
 *               => 모든 프로그램 언어 (파이썬, 자바스크립트, 코틀린) 
 *                  ==================================== XML, JSON
 *               => 데이터만 전송할 때 쓰인다 
 *          6. @ControllerAdvice, @RestControllerAdvide => 공통 예외 처리
 *                => 메모리 할당(X) => @CrossOrigin, @Aspect, @RequestMapping
 *                               ============  =======  ===============
 *                                    |          |           |
 *                                    |          |         공통 경로
 *                                    |        공통 모듈
 *                         포트 번호가 다른 경우 연결 허용 
 *                               @Async : 비동기
 *    
 *             => 메서드 위에 올라가는 애너테이션 : @GetMapping, @PostMapping
 *                ==========
 *                멤버 변수 : @Autowired
 *                   => 구분자 : 애너테이션에 따라 주소 대입, 메서드 호출
 * 
 *             => MVC
 *                클라이언트 : <a>, <form>, javascript
 *                          요청 => .do => 화면 보여달라 요청 / 저장 / 수정 /삭제 ..
 *                   |
 *               DispatcherServlet : .do 자동 호출 
 *                   | 요청 처리 => 사용자 정의 (Model) => Controller 
 *                     ======
 *                      찾기 => 구분 (GetMapping, PostMapping)
 *                      === HandlerMapping 
 *                      | Model, request 값을 전송
 *                      ViewResolver 
 *                      | 
 *                      JSP를 찾아서 요청 결과 출력
 *                   ====> Model(Controller, RestController)
 *                         | Controller, DAO, Service, VO
 *                         ===============================
 *                         | 기능별로 분리 (재사용,수정,에러처리)
 *                   ====> JSP 
 *                   
 */
@Repository
public class CommentDAO {
	@Autowired
	private CommentMapper mapper;
	public List<CommentVO> commentListData(Map map){
		return mapper.commentListData(map);
	}
	

	public int commentTotalPage(Map map) {
		return mapper.commentTotalPage(map);
	}

}
