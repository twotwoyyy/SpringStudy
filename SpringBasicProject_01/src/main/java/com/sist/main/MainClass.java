package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*   *** 스프링 특징
 *    관계도 => 1개만 가지고 사용할 수 있다.
 *    기존의 프로그램은 한 개의 클래스가 에러가 나면 연결된 나머지 클래스도 에러가 발생하는데
 *    Spring은 기능만 수행하고 연결이 되어있지 않아 한 군데에서 에러가 발생하면 다른 부분은 영향이 가지 않음.
 */

/*
 *    라이브러리 VS 프레임워크
 * 
 *    => 라이브러리 (자바, Jsoup...)
 *       : 자주 사용되는 기능을 모아서 미리 구현해둔 클래스의 집합
 *         자유롭게 사용할 수 있다.
 *    => 프레임워크
 *       : 개발에 필요한 기능을 미리 구현해둔 클래스의 집합
 *          => 기본 틀이 만들어져있다 (틀 안에서만 사용이 가능)
 *             ============= XML / Annotation
 *    => 대표적인 프레임워크
 *       1. MyBatis
 *       2. Ajax, Vue, React => 이미 사용법이 만들어져있다.
 *       3. Spring / Spring-Boot
 * 
 *    => 장점
 *       = 기본 틀(형식)이 만들어져있기 때문에 표준화가 되어있다
 *          => 같은 형식으로 제작 : 한 번 익숙해지면 사용이 편리하다.
 *                       ====================
 *                       유지 보수 시에 교육 없이 투입이 바로 가능.
 *       = 개발 기간이 단축
 *       = 연결 관계가 단순하다.
 *         =============
 *    => 단점
 *       = 기능이 많다. (전체를 사용하기 어렵다.)
 *          Spring-Boot
 *          Spring Framework
 *          Spring Security
 *          Spring Betch
 *          Spring Data
 *          Spring Cloud
 *          ================
 *       = 무겁다 (실행 속도가 느리다)
 *       = 학습해야 되는 라이브러리가 많이 존재
 *    ============================== 통합 (자바, JSP, DB)
 *    Spring에서 사용되는 기능 준비
 *    1) Database
 *       JDBC / ORM
 *             === 관계형 데이터베이스 : MyBatis / JPA / Hibernate
 *                          ==============
 *    2) Web : MVC => Controller가 이미 제작
 *    3) Core
 *    	 스프링은 클래스 관리자 (컨테이너)
 *                  ====
 *                  생성 / 소멸 => 객체의 생명주기 관리
 *       => Container : 클래스를 모아서 관리
 *          개발자 등록 (클래스) : VO 클래스는 데이터형 (사용자 정의 데이터형) => 관리 대상에서 제외 
 *          ========
 *          1) 스프링은 형식에 맞게 사용 (지정 형식)
 *             = 클래스 등록
 *               = XML을 이용 => Spring 4 / Spring => 자바 이용
 *                 <bean id="aa" class="com.sist.main.AA">
 *                    map.put("aa",new AA())
 *                    AA map.get("aa")
 *                 ========================== 실무에서 많이 사용 
 *               = @Bean("aa")
 *                 public AA aa(){
 *                 	  return new AA()
 *                 }
 *               = 어노테이션 이용 
 *                 @Component("a") 
 *                            === id
 *                 class A{
 *                 }
 *          XML/Annotation을 읽어서 container에 저장 
 *          ====================================
 *                          | => Spring 
 *                    사용자 클래스에서 연결
 *          1. Container의 종류
 *          ================= 클래스의 메모리 할당 (객체 생성)
 *                            객체 찾기 => getBean("id명칭")
 *                            객체 소멸 
 *                      		 BeanFactory : Core => DI (객체 생성 / 소멸 / 초기화)
 *                           		 |
 *                    		 ApplicationContext : Core / AOP
 *                           		 | =========== WebApplicationContext : : Core / AOP / MVC
 *            		  --------------------------------
 *             		  |                              |
 *  AnnotationConfigApplicationContext     GenericXmlApplicationContext
 *   : Core / AOP / Annotation               : Core / AOP / CLOSE 
 *          1. 일반 스프링 => ApplicationContext
 *          2. 웹 => WebApplicationContext
 *          3. Annotation => AnnotationConfigApplicationContext
 *          ===================================================
 *           => 클래스 등록 => 필요시마다 등록된 클래스를 찾아서 사용 => 필요가 없는 경우에는 소멸
 *                                                        System.gc() 
 *       => DI => Setter / Constructor / Method
 *          스프링을 통해서 => 멤버 변수의 초기화
 *       => AOP => 공통 모듈 (공통적으로 사용하는 기능을 모아서 자동 호출)
 *         
 *       classA{
 *       }
 *       classB{
 *       }
 *       classC{
 *       }
 *                              ================
 *                                 id    class
 *                              ================
 *      <bean id="a" class="A">     a   new A()
 *      <bean id="b" class="B">     b   new B()
 *      <bean id="d" class="D">     c   new C()
 *      
 *      생명주기
 *      1. class 읽기
 *      2. 클래스 메모리 할당
 *      3. setter를 이용해서 초기화
 *      ============================ Spring
 *      4. 개발자 사용 : 등록 클래스 찾기
 *      ============================ 개발자 담당
 *      5. 사용 후 클래스 메모리 해제
 *      ============================ Spring
 *      
 *      class A{
 *      	public void d(){}
 *          ..
 *      }
 *      
 *      DI : 모든 클래스에 적용
 *           초기화
 *           = setter DI
 *           = 생성자 DI
 *           = method DI   => 객체 생성시 / 객체 소멸시
 *                          init-method destory-method
 *     AOP : Transaction / Security
 *     ORM : 데이터베이스 연동 => MyBatis
 *     MVC : WEB 
 *       
 */
public class MainClass {

   public static void main(String[] args) {
	   // 1. 컨테이너에 XML 파싱 요청
	   ApplicationContext app=
			   new ClassPathXmlApplicationContext("app1.xml");
	   // 2. 필요한 객체를 요청 
	   Board b=(Board)app.getBean("board"); // 두 가지 사용 가능 1. 형변환 
	   System.out.println("b="+b);
	   b.list();
	   b.insert();
	   Board b1=app.getBean("board",Board.class); // 2. (제네릭) => 자동 형변환
	   System.out.println("b1="+b1);
	   // 3. 필요에 따라 메소드를 호출 후에 사용 : 싱글턴 사용 (default) = 한 개의 메모리 주소를 이용해서 재사용
	   b1.list();
	   b1.insert();
   }
}
