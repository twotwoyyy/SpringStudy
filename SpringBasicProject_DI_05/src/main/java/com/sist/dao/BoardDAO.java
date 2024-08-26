package com.sist.dao;

import org.springframework.stereotype.Repository;
// <bean id="dao" class="com.sist.dao.BoardDAO">
// 단점 => DI가 어렵다 
@Repository("dao")
public class BoardDAO {
	public void list() {
		System.out.println("SELECT 문장 수행");
	}
}
