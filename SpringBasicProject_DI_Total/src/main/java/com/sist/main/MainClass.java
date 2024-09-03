package com.sist.main;

import com.sist.dao.MyDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *	1. DI => Ŭ������ Ŭ���� ���� ���� : �޴��� (����) => Ŭ���� ������ ���� ����
 *		1) XML ��� : Spring4 => �������� �����ӿ�ũ (�ǹ�)
 *		2) Annotation ��� => ���̺귯���� Ŭ���� ��� �ÿ� ����� �޾Ƽ� ó�� 
 *                           =======
 *                           ������̼� ������ �ȵ�
 *      3) XML + Annotation 
 *         ================ XML : ���̺귯�� ��Ͻ� (MyBatis, ����) 
 *         		  ����� ���Ǵ� ������̼����� ���� 
 *         		  => ������Ʈ���� ���� ��� => XML 
 *                => �����ڸ��� ���� => ������̼����� ������ 
 *      ==================================================
 *      4) ���� �ڹٸ� �̿� 
 *         ============
 *         XML : �������� Ŭ���� ������ (����~�Ҹ�) 
 *          = �� ���� Ŭ������ ��� 
 *            <bean id="" class="" scope="">
 *                  ==    ======   =====
 *                                 | �̱��� (�� ���� ��ü�� �̿��ϴ� ���)
 *                                   prototype
 *                        | �޸� �Ҵ��� Ŭ���� ���� (�ݵ�� ��Ű������)
 *                  | ������ (�ߺ��� �� ����, Ŭ���� ��ü�� ã�� ��쿡 ���)
 *               => �ڹ� ����
 *                @Bean("id")
 *          = ��Ű�� ������ ��� 
 *            <context:component-scan base-package="��Ű����">
 *             => �ڹ� ���� : @ComponentScan(basePackage={""})
 *             => <myBatis-spring base-package="">
 *               => �ڹ� ���� : @MapperScan(basePackage={""})
 *             => Spring-Boot:FrameWork�� ���� 
 *                ===========
 *                   => application.properties
 *                      server.port=80
 *                   => application.yml
 *                      sever:
 *                      	port:80
 *             => �������� �޸� �Ҵ�
 *                Ŭ���� ����
 *                @Component : �Ϲ� Ŭ����
 *                @Repository : DAO
 *                @Service : DAO ���� �� ���� : BI
 *                @Controller : Model => Ŭ���� ������ �����Ǹ� �� ó���� �ȵȴ� 
 *                              forward
 *                              redirect
 *                              ȭ�� ���� ����
 *                @RestController : Model => ȭ�� ������ �ƴϴ�
 *                                           JSON ���� => �ڹٽ�ũ��Ʈ ����
 *                                  GET => SELECT 
 *                                  POST => UPDATE
 *                                  PUT => INSERT 
 *                                  DELETE => DELETE
 *                @ContollerAdvice : ���������� ����ó�� 
 *                =================================
 *                *** �������� ��ϵ� ��ü ã�� => getBean("id��")
 *                *** ���������� ��ϵ� Ŭ������ ���� : �����̳�
 *                            BeanFactory
 *                                 |
 *                         ApplicationContext
 *                                 | 
 *                -------------------------------------
 *                |                                   |
 *         AnnotaitonConfigApplicationContext    WebApplicationContext(MVC)
 *         
 *  2. AOP => �������� ���Ǵ� Ŭ������ ����� ��Ƽ� ó�� => �ڵ� ȣ��
 *     --- Aspect : �������� ���Ǵ� ����� ��Ƽ� ���� : ���� ��� 
 *         ------
 *         1) PointCut : � �޼ҵ忡 ������ ������  
 *         2) JoinPoint : � ��ġ���� ������ ������
 *            public void display(){
 *            	***** Before : driver ���
 *            	try{
 *            		****** setAutocommit(false)
 *            		ó�� �κ� : - Around
 *            		****** commit() : Ʈ����� ó��, �α� ����
 *            	}catch(Exception e){
 *            		****** after-throwing : catch ���� 
 *            	}finally{
 *            		****** after	
 *            	}
 *            	***** after-returning
 *            }
 *         3) Advice : PointCut + JoinPoint 
 *         4) Weaving : �ҽ��� �����ϴ� ���� 
 *     --- ���ͼ�Ʈ : �ڵ� �α��� / ���� 
 *  3. MVC => ��
 *  4. ORM => MyBatis 
 *  	*** DI, AOP, MVC ���� 
 *  ================================ Basic
 *  5. ���ͼ�Ʈ 
 *  6. ���� ���� ó�� 
 *  7. ����
 *  8. �� ä��
 *  ===============
 * 
 */
import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		String s=dao.find("Hello");
		//System.out.println(s);
	}
}