package com.sist.main2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// @Configration => ȯ�� ���� => XML ���
@Configuration
public class MemberConfig {
	/*
	 * <bean id="mem" class="com.sist.main2.Member"
	 * 		p:mno="1"
	 * 		p:name="ȫ�浿"
	 * 		p:sex="����"
	 *	/>
	 *
	 *	=> �� ���� ���� ��� (�ڹٷ� �ڵ�)
	 *	   XML => ������̼����� ���� 
	 */
	@Bean("mem")
	//     === id 
	public Member member() {
		Member m=new Member(); // class ���, �޸� �Ҵ� 
		m.setMno(1);
		m.setName("ȫ�浿");
		m.setSex("����");
		return m;
	}
}
