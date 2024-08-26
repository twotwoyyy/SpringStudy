package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
//@Repository
public class EmpDAO {
	//@Autowired // 자동 주입 => 구현된 객체의 주소를 대입 
	private EmpMapper mapper;
	// Repository와 Autowired를 쓰지 않으려면 우클릭 => setter ~
	
	public List<EmpVO> empListData(){
		
		return mapper.empListData();
	}

	public EmpMapper getMapper() {
		return mapper;
	}

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
}
