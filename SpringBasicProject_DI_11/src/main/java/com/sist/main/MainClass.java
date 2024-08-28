package com.sist.main;
/*
 *    Maven => ant
 *      |
 *    1) 라이브러리 관리   : pom.xml
 *    2) 프로젝트 관리   : 버전 관리
 *    3) 배포 관리   : 자동으로 war(웹)
 *               ============ war => 원격 AWS 운영 체제로 전송 => TOMCAT
 *       AWS : 운영 체제를 빌려서 사용
 *            ====== 리눅스 설치 : 각자 IP가 따로 생성됨
 * 
 *       Spring : DI / AOP (개념 파악) / MVC / MyBatis (ORM) => security / websocket
 *                              |        | Transaction
 *                              | Intercept
 *                            ====================
 *             =====================================================================
 *             Base : DI
 * 
 *    => DI
 *       1) 클래스 등록
 *          = <bean id="" class=""> 한 개의 클래스 등록
 *          = *** <context:component-scan basepackage=""> 여러 개의 클래스를 동시에 메모리 할당
 *                반드시 메모리 할당할 클래스는 구분
 *                class 위에 Annotation을 이용해서 구분
 *             => 클래스 유형 별로 구분
 *                일반 클래스 : @Component => MainClass ... ~Manager
 *                데이터베이스 연동 : @Repository => ~DAO
 *                관련된 DAO를 통합   : @Service
 *                Model Class : @Controller / @ResController
 *                                            | 화면 제어가 아니라 => 자바 스크립트, 코틀린 연동
 *                                              => JSON
 *                                              => RestFul
 *                                                 ========
 *                                                 다른 언어와 연동 : CRUD 
 *                                                 => GET : SELECT
 *                                                 => POST : INSERT
 *                                                 => PUT : UPDATE
 *                                                 => DELETE : DELETE
 *                                                 ====================
 *                               | 일반 JSP 제어   
 *                               => forward / redirect 
 *               통합 예외처리 : @ControllerAdvice
 *          = XML 없이 사용 
 *            => @Bean => 자바로만 코딩하는 방식 
 *            
 *            ** Spring은 컨테이너다 (클래스 관리자) => MVC는 스프링의 일부 라이브러리 (주력) 
 *                       ======= 클래스를 모아서 관리 
 *                                          ==== 객체 생성 ~ 객체 소멸 (객체의 생명 주기 담당) 
 *                                               =======
 *                                               = 멤버 변수 초기화 => DI 
 *                                                 ===========
 *                                                 1. setter : setXxx(주입)
 *                                                    p:name => setName()
 *                                                 2. 생성자 이용 
 *                                                    c:name => 생성자(String name)
 *                                               ==================================
 *                                                => 사용자 정의 클래스에서는 사용 빈도가 거의 없다 
 *                                                => 데이터베이스 연동 : 오라클 정보를 시작과 동시에 전송 
 *            ** 개발자가 문제 제기
 *               =============
 *               1) 언어를 통합 : 한 가지 언어로 사용 (XML,Java)
 *               2) 보안 유지가 어렵다 (XML은 노출이 심하다)
 *               ================== 스프링 5에서 변경
 *             => Java로만 통일, Java는 컴파일 .class로 바뀌면 보안 뛰어남
 *             ================================================
 *             => 이전 프로그램이 존재 : 호환성
 *              
 *    => MyBatis : @Select ....
 *                 매개변수는 반드시 1개
 *                 ================ 여러 개 사용도 가능 (사용법)
 *                 복잡한 SQL 문장 => 동적 쿼리
 *                 ======================
 *                 => XML => Annotation으로 변경 
 *                 => PROCEDURE / TRIGGER => 고급 SQL 
 *                                                 
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.vo.*;
import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal());
		}
	}
}
