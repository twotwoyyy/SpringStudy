package com.sist.dao;

import org.springframework.stereotype.Repository;
// <bean id="dao" class="com.sist.dao.BoardDAO">
// ���� => DI�� ��ƴ� 
@Repository("dao")
public class BoardDAO {
	public void list() {
		System.out.println("SELECT ���� ����");
	}
}
