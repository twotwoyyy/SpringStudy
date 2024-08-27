package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class OracleDAO implements MyDAO{

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("오라클 연결...");
	}

}
