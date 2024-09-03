package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	// 구현된 클래스 읽기 
	@Autowired
	private EmpMapper mapper;
	public List<EmpVO> empListData(){
		
		return mapper.empListData();
	}
}
