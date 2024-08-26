package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DeptMapper;
import com.sist.vo.DeptVO;

@Repository
public class DeptDAO {
	@Autowired
	private DeptMapper mapper;
	
	public List<DeptVO> deptListData(){
		return mapper.deptListData();
	}
}
