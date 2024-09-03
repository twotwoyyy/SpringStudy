package com.sist.config;
// Spring 5 

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// 코딩은 단순 : 스프링 라이브러리 연결 => xml,Annotation
// 환경설정, 클래스 등록 파일 
// application-context.xml (데이터베이스)
/*
 * 	기능 처리 클래스 : 데이터베이스 연동 (DAO), Jsoup(Component)
 *                Model
 *	@Component
 *	@Repository
 *	@Service
 *  ==============================
 *	@Controller
 *	@RestController
 *	@Controller
 *	@ControllerAdvice
 *  ============================== Web
 *	@Configuration
 *  ====> 클래스 위에 설정된 경우면 메모리 할당 (객체 생성)
 *        선택적인 메모리 할당
 *  일반 스프링
 *  ========
 *   1) DI : 클래스 설정 (등록)
 *   2) AOP : 공통 모듈 설정 ==> CommonsModel => 자동 호출 (콜백)
 *      AOP와 인터셉트의 차이점
 *   3) MVC => ORM (MyBatis)
 *   ----------------------------------------------------
 *   1) Security
 *   2) 
 */
@Configuration
// <context:component-scan base-pakage="com.sist.*"/>
@ComponentScan(basePackages= {"com.sist.*"})
public class MusicConfig {

}
