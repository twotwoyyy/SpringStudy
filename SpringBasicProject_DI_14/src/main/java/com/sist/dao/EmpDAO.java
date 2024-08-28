package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	/*
	 * 	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc,grade "
			+"FROM emp,dept,salgrade "
			+"WHERE emp.deptno=dept.deptno "
			+"AND sal BETWEEN losal AND hisal")
		public List<EmpVO> empListData();
	 */
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
	
}
