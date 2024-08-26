package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
//@Repository
public class EmpDAO {
	//@Autowired // �ڵ� ���� => ������ ��ü�� �ּҸ� ���� 
	private EmpMapper mapper;
	// Repository�� Autowired�� ���� �������� ��Ŭ�� => setter ~
	
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
