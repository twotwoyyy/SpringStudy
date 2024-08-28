package com.sist.main;
/*
 *    Maven => ant
 *      |
 *    1) ���̺귯�� ����   : pom.xml
 *    2) ������Ʈ ����   : ���� ����
 *    3) ���� ����   : �ڵ����� war(��)
 *               ============ war => ���� AWS � ü���� ���� => TOMCAT
 *       AWS : � ü���� ������ ���
 *            ====== ������ ��ġ : ���� IP�� ���� ������
 * 
 *       Spring : DI / AOP (���� �ľ�) / MVC / MyBatis (ORM) => security / websocket
 *                              |        | Transaction
 *                              | Intercept
 *                            ====================
 *             =====================================================================
 *             Base : DI
 * 
 *    => DI
 *       1) Ŭ���� ���
 *          = <bean id="" class=""> �� ���� Ŭ���� ���
 *          = *** <context:component-scan basepackage=""> ���� ���� Ŭ������ ���ÿ� �޸� �Ҵ�
 *                �ݵ�� �޸� �Ҵ��� Ŭ������ ����
 *                class ���� Annotation�� �̿��ؼ� ����
 *             => Ŭ���� ���� ���� ����
 *                �Ϲ� Ŭ���� : @Component => MainClass ... ~Manager
 *                �����ͺ��̽� ���� : @Repository => ~DAO
 *                ���õ� DAO�� ����   : @Service
 *                Model Class : @Controller / @ResController
 *                                            | ȭ�� ��� �ƴ϶� => �ڹ� ��ũ��Ʈ, ��Ʋ�� ����
 *                                              => JSON
 *                                              => RestFul
 *                                                 ========
 *                                                 �ٸ� ���� ���� : CRUD 
 *                                                 => GET : SELECT
 *                                                 => POST : INSERT
 *                                                 => PUT : UPDATE
 *                                                 => DELETE : DELETE
 *                                                 ====================
 *                               | �Ϲ� JSP ����   
 *                               => forward / redirect 
 *               ���� ����ó�� : @ControllerAdvice
 *          = XML ���� ��� 
 *            => @Bean => �ڹٷθ� �ڵ��ϴ� ��� 
 *            
 *            ** Spring�� �����̳ʴ� (Ŭ���� ������) => MVC�� �������� �Ϻ� ���̺귯�� (�ַ�) 
 *                       ======= Ŭ������ ��Ƽ� ���� 
 *                                          ==== ��ü ���� ~ ��ü �Ҹ� (��ü�� ���� �ֱ� ���) 
 *                                               =======
 *                                               = ��� ���� �ʱ�ȭ => DI 
 *                                                 ===========
 *                                                 1. setter : setXxx(����)
 *                                                    p:name => setName()
 *                                                 2. ������ �̿� 
 *                                                    c:name => ������(String name)
 *                                               ==================================
 *                                                => ����� ���� Ŭ���������� ��� �󵵰� ���� ���� 
 *                                                => �����ͺ��̽� ���� : ����Ŭ ������ ���۰� ���ÿ� ���� 
 *            ** �����ڰ� ���� ����
 *               =============
 *               1) �� ���� : �� ���� ���� ��� (XML,Java)
 *               2) ���� ������ ��ƴ� (XML�� ������ ���ϴ�)
 *               ================== ������ 5���� ����
 *             => Java�θ� ����, Java�� ������ .class�� �ٲ�� ���� �پ
 *             ================================================
 *             => ���� ���α׷��� ���� : ȣȯ��
 *              
 *    => MyBatis : @Select ....
 *                 �Ű������� �ݵ�� 1��
 *                 ================ ���� �� ��뵵 ���� (����)
 *                 ������ SQL ���� => ���� ����
 *                 ======================
 *                 => XML => Annotation���� ���� 
 *                 => PROCEDURE / TRIGGER => ��� SQL 
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
