package com.sist.vo;
/*
 *	spring 
 *   1. MVC : 
 *   2. DI : 클래스 설계 => 메모리 할당, 자동 주입 (@Autowired, @Resource=> 1.8 이전)
 *                      @Component 
 *                      @Repository
 *                      @Service
 *                      @Controller
 *                      @RestController
 *                      
 *   3. AOP : Transaction / Security / Commons 
 *   4. ORM => MyBatis ==> JPA
 *   ==========================> 오라클 => MySQL
 *   <면접 질문>
 *   1) DI / AOP 
 *   2) Transaction
 *   3) MVC 구조
 *   4) Session VS Cookie
 *   5) DAO vs Service 
 *   
 *   JAVA
 *   1) 객체지향 (캡슐화 vs 은닉화, 상속 vs 포함, 오버라이딩 vs 오버로딩)
 *   2) Collection 
 *   3) 추상 클래스 vs 인터페이스
 *   4) 쓰레드 (동기화 / 비동기화)
 *   
 *   HTML / JSP / CSS
 *   1) GET / POST
 *   2) Session vs Cookie
 *   3) JSTL / EL
 *   4) MVC 구조
 *      model1 vs model2
 *   
 *   JavaScript
 *   1) 클로저
 *   2) ES6 장점, 변경된 점
 *   3) let, const, var 차이점
 *   
 *   Oracle 
 *   1) JOIN 종류 
 *   2) SUBQUERY
 *   3) 프로시저 VS 트리거 
 *   
 *   스프링
 *   객체 생성 ~ 객체 소멸 
 *   => 기본 모든 클래스를 관리
 *     	VO => 데이터형 (사용자)
 *      ===========
 *      Mapper 
 *      Service
 *      =========== 인터페이스 => 연결용
 *                  ======= 98%
 *   => 재사용 기법 : 싱글턴
 *   => @Autowired => 스프링에서 메모리 할당된 클래스 안에서만 찾아서 주소값 대입
 *                 => 오라클 : 
 *   
 *   @Component => 싱글턴
 *   @Scope("prototype") => 요청시마다 새롭게 메모리 할당
 *   class A 
 *   
 *   
 *  NO      NOT NULL NUMBER         
	TITLE   NOT NULL VARCHAR2(200)  
	POSTER  NOT NULL VARCHAR2(500)  
	MSG     NOT NULL VARCHAR2(4000) 
	ADDRESS NOT NULL VARCHAR2(300)  
	 *   
 */
import java.util.*;

import lombok.Data;

@Data
public class SeoulVO {
	private int no;
	private String title,poster,msg,address,addr;
}
