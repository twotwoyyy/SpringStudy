package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.MyDAO;
/*
 * 	@Component => @Target(value={TYPE})
 *                ===================== class 구분자 (TYPE이 들어간 경우) => 클래스 위에만 올릴 수 있다 
 *  @Repository => @Target(value={TYPE}) 클래스만 구분 
 *  
 *  @Autowired => @Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 *                 
 *                Class A{
 *                	@Autowired 
 *                	private B b; => FIELD (멤버 변수)
 *                	@Autowired
 *                	public A(B b){ => CONSTRUCTOR (생성자)
 *                		this.b=b
 *                	}
 *                	@Autowired => ANNOTATION_TYPE
 *                	@Qualifier 
 *                
 *                	@Autowired => METHOD (메소드)
 *                	public void setB(@Autowired B b){ 
 *                                   | PARAMETER
 *                		this.b=b
 *                	}
 *                }
 *    => 어노테이션
 *       1. 구분자 (인덱스) @Target
 *          = 클래스 : TYPE
 *          = 매개변수 : PARAMETER
 *          = 생성자 : CONSTRUCTOR
 *  		= 메소드 : METHOD
 *    => 클래스 등록 
 *       ========
 *       XML만 이용
 *       ANNOTATION만 이용
 *       XML + ANNOTATION 이용 (가장 많이 사용되는 형식)
 *         |       |
 *             사용자 정의 클래스 등록
 *             @Component : MainClass, ~Manager
 *             @Repository : DAO
 *             @Service : DAO 여러 개 
 *                        게시판 + 댓글 
 *                        Emp + Dept  
 *             ==================
 *             @Controller
 *             @RestController
 *             @ControllerAdvice
 */
@Component("mc")
public class MainClass2 {
	@Autowired // 자동으로 스프링에서 같은 객체를 찾아서 주소값을 대입 
	@Qualifier("mysql") // 선택 => 객체 지정 (여러 개 있는 경우 한 개 선택)  
	// @Resource(name="mysql") => @Autowired + @Qualifier 
	private MyDAO dao;
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		MainClass2 mc=(MainClass2)app.getBean("mc");
		mc.dao.connection();
	}
}
