package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;


@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	// public List<EmpVO> empListData(); // 목록
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
	// public EmpVO empDetailData(int empno); // 상세보기
	public EmpVO empDetailData(int empno) {
		return mapper.empDetailData(empno);
	}
}
