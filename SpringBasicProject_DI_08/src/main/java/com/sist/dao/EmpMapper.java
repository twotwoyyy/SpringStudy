package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
	@Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			+"FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
}
