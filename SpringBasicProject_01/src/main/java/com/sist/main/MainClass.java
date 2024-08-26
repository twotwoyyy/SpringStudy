package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*   *** ������ Ư¡
 *    ���赵 => 1���� ������ ����� �� �ִ�.
 *    ������ ���α׷��� �� ���� Ŭ������ ������ ���� ����� ������ Ŭ������ ������ �߻��ϴµ�
 *    Spring�� ��ɸ� �����ϰ� ������ �Ǿ����� �ʾ� �� �������� ������ �߻��ϸ� �ٸ� �κ��� ������ ���� ����.
 */

/*
 *    ���̺귯�� VS �����ӿ�ũ
 * 
 *    => ���̺귯�� (�ڹ�, Jsoup...)
 *       : ���� ���Ǵ� ����� ��Ƽ� �̸� �����ص� Ŭ������ ����
 *         �����Ӱ� ����� �� �ִ�.
 *    => �����ӿ�ũ
 *       : ���߿� �ʿ��� ����� �̸� �����ص� Ŭ������ ����
 *          => �⺻ Ʋ�� ��������ִ� (Ʋ �ȿ����� ����� ����)
 *             ============= XML / Annotation
 *    => ��ǥ���� �����ӿ�ũ
 *       1. MyBatis
 *       2. Ajax, Vue, React => �̹� ������ ��������ִ�.
 *       3. Spring / Spring-Boot
 * 
 *    => ����
 *       = �⺻ Ʋ(����)�� ��������ֱ� ������ ǥ��ȭ�� �Ǿ��ִ�
 *          => ���� �������� ���� : �� �� �ͼ������� ����� ���ϴ�.
 *                       ====================
 *                       ���� ���� �ÿ� ���� ���� ������ �ٷ� ����.
 *       = ���� �Ⱓ�� ����
 *       = ���� ���谡 �ܼ��ϴ�.
 *         =============
 *    => ����
 *       = ����� ����. (��ü�� ����ϱ� ��ƴ�.)
 *          Spring-Boot
 *          Spring Framework
 *          Spring Security
 *          Spring Betch
 *          Spring Data
 *          Spring Cloud
 *          ================
 *       = ���̴� (���� �ӵ��� ������)
 *       = �н��ؾ� �Ǵ� ���̺귯���� ���� ����
 *    ============================== ���� (�ڹ�, JSP, DB)
 *    Spring���� ���Ǵ� ��� �غ�
 *    1) Database
 *       JDBC / ORM
 *             === ������ �����ͺ��̽� : MyBatis / JPA / Hibernate
 *                          ==============
 *    2) Web : MVC => Controller�� �̹� ����
 *    3) Core
 *    	 �������� Ŭ���� ������ (�����̳�)
 *                  ====
 *                  ���� / �Ҹ� => ��ü�� �����ֱ� ����
 *       => Container : Ŭ������ ��Ƽ� ����
 *          ������ ��� (Ŭ����) : VO Ŭ������ �������� (����� ���� ��������) => ���� ��󿡼� ���� 
 *          ========
 *          1) �������� ���Ŀ� �°� ��� (���� ����)
 *             = Ŭ���� ���
 *               = XML�� �̿� => Spring 4 / Spring => �ڹ� �̿�
 *                 <bean id="aa" class="com.sist.main.AA">
 *                    map.put("aa",new AA())
 *                    AA map.get("aa")
 *                 ========================== �ǹ����� ���� ��� 
 *               = @Bean("aa")
 *                 public AA aa(){
 *                 	  return new AA()
 *                 }
 *               = ������̼� �̿� 
 *                 @Component("a") 
 *                            === id
 *                 class A{
 *                 }
 *          XML/Annotation�� �о container�� ���� 
 *          ====================================
 *                          | => Spring 
 *                    ����� Ŭ�������� ����
 *          1. Container�� ����
 *          ================= Ŭ������ �޸� �Ҵ� (��ü ����)
 *                            ��ü ã�� => getBean("id��Ī")
 *                            ��ü �Ҹ� 
 *                      		 BeanFactory : Core => DI (��ü ���� / �Ҹ� / �ʱ�ȭ)
 *                           		 |
 *                    		 ApplicationContext : Core / AOP
 *                           		 | =========== WebApplicationContext : : Core / AOP / MVC
 *            		  --------------------------------
 *             		  |                              |
 *  AnnotationConfigApplicationContext     GenericXmlApplicationContext
 *   : Core / AOP / Annotation               : Core / AOP / CLOSE 
 *          1. �Ϲ� ������ => ApplicationContext
 *          2. �� => WebApplicationContext
 *          3. Annotation => AnnotationConfigApplicationContext
 *          ===================================================
 *           => Ŭ���� ��� => �ʿ�ø��� ��ϵ� Ŭ������ ã�Ƽ� ��� => �ʿ䰡 ���� ��쿡�� �Ҹ�
 *                                                        System.gc() 
 *       => DI => Setter / Constructor / Method
 *          �������� ���ؼ� => ��� ������ �ʱ�ȭ
 *       => AOP => ���� ��� (���������� ����ϴ� ����� ��Ƽ� �ڵ� ȣ��)
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
 *      �����ֱ�
 *      1. class �б�
 *      2. Ŭ���� �޸� �Ҵ�
 *      3. setter�� �̿��ؼ� �ʱ�ȭ
 *      ============================ Spring
 *      4. ������ ��� : ��� Ŭ���� ã��
 *      ============================ ������ ���
 *      5. ��� �� Ŭ���� �޸� ����
 *      ============================ Spring
 *      
 *      class A{
 *      	public void d(){}
 *          ..
 *      }
 *      
 *      DI : ��� Ŭ������ ����
 *           �ʱ�ȭ
 *           = setter DI
 *           = ������ DI
 *           = method DI   => ��ü ������ / ��ü �Ҹ��
 *                          init-method destory-method
 *     AOP : Transaction / Security
 *     ORM : �����ͺ��̽� ���� => MyBatis
 *     MVC : WEB 
 *       
 */
public class MainClass {

   public static void main(String[] args) {
	   // 1. �����̳ʿ� XML �Ľ� ��û
	   ApplicationContext app=
			   new ClassPathXmlApplicationContext("app1.xml");
	   // 2. �ʿ��� ��ü�� ��û 
	   Board b=(Board)app.getBean("board"); // �� ���� ��� ���� 1. ����ȯ 
	   System.out.println("b="+b);
	   b.list();
	   b.insert();
	   Board b1=app.getBean("board",Board.class); // 2. (���׸�) => �ڵ� ����ȯ
	   System.out.println("b1="+b1);
	   // 3. �ʿ信 ���� �޼ҵ带 ȣ�� �Ŀ� ��� : �̱��� ��� (default) = �� ���� �޸� �ּҸ� �̿��ؼ� ����
	   b1.list();
	   b1.insert();
   }
}
