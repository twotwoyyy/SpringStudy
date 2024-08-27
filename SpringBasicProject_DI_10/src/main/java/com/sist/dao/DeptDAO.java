package com.sist.dao;

import org.springframework.stereotype.Repository;

import com.sist.mapper.DeptMapper;
import java.util.*;
import com.sist.vo.*;
@Repository
public class DeptDAO {
	private DeptMapper mapper;
	
	public List<DeptVO> deptListData(){
		return mapper.deptListData();
	}
}
