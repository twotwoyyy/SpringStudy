package com.sist.config;
// Spring 5 

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// �ڵ��� �ܼ� : ������ ���̺귯�� ���� => xml,Annotation
// ȯ�漳��, Ŭ���� ��� ���� 
// application-context.xml (�����ͺ��̽�)
/*
 * 	��� ó�� Ŭ���� : �����ͺ��̽� ���� (DAO), Jsoup(Component)
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
 *  ====> Ŭ���� ���� ������ ���� �޸� �Ҵ� (��ü ����)
 *        �������� �޸� �Ҵ�
 *  �Ϲ� ������
 *  ========
 *   1) DI : Ŭ���� ���� (���)
 *   2) AOP : ���� ��� ���� ==> CommonsModel => �ڵ� ȣ�� (�ݹ�)
 *      AOP�� ���ͼ�Ʈ�� ������
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
