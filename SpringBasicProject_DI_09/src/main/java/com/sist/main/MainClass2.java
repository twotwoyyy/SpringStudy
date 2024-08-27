package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.MyDAO;
/*
 * 	@Component => @Target(value={TYPE})
 *                ===================== class ������ (TYPE�� �� ���) => Ŭ���� ������ �ø� �� �ִ� 
 *  @Repository => @Target(value={TYPE}) Ŭ������ ���� 
 *  
 *  @Autowired => @Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 *                 
 *                Class A{
 *                	@Autowired 
 *                	private B b; => FIELD (��� ����)
 *                	@Autowired
 *                	public A(B b){ => CONSTRUCTOR (������)
 *                		this.b=b
 *                	}
 *                	@Autowired => ANNOTATION_TYPE
 *                	@Qualifier 
 *                
 *                	@Autowired => METHOD (�޼ҵ�)
 *                	public void setB(@Autowired B b){ 
 *                                   | PARAMETER
 *                		this.b=b
 *                	}
 *                }
 *    => ������̼�
 *       1. ������ (�ε���) @Target
 *          = Ŭ���� : TYPE
 *          = �Ű����� : PARAMETER
 *          = ������ : CONSTRUCTOR
 *  		= �޼ҵ� : METHOD
 *    => Ŭ���� ��� 
 *       ========
 *       XML�� �̿�
 *       ANNOTATION�� �̿�
 *       XML + ANNOTATION �̿� (���� ���� ���Ǵ� ����)
 *         |       |
 *             ����� ���� Ŭ���� ���
 *             @Component : MainClass, ~Manager
 *             @Repository : DAO
 *             @Service : DAO ���� �� 
 *                        �Խ��� + ��� 
 *                        Emp + Dept  
 *             ==================
 *             @Controller
 *             @RestController
 *             @ControllerAdvice
 */
@Component("mc")
public class MainClass2 {
	@Autowired // �ڵ����� ���������� ���� ��ü�� ã�Ƽ� �ּҰ��� ���� 
	@Qualifier("mysql") // ���� => ��ü ���� (���� �� �ִ� ��� �� �� ����)  
	// @Resource(name="mysql") => @Autowired + @Qualifier 
	private MyDAO dao;
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		MainClass2 mc=(MainClass2)app.getBean("mc");
		mc.dao.connection();
	}
}
