package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.mapper.EmpMapper;

@Repository("dao")
public class EmpDAO2 {
	@Autowired
	private EmpMapper mapper;
	   public List<EmpVO> empListData()
	   {
	      return mapper.empListData();
	   }
}
