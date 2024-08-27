package com.sist.dao;
import java.util.*;
public class EmpDAO {
	private EmpMapper mapper;

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<EmpVO> empListData(){
		return mapper.empListData(); // session.close()
		//ssf.openSession(true)까지 자동 처리
	}
}
