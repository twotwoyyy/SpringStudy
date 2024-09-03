package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;
public interface EmpMapper {
	@Select("SELECT empno,ename,sal,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
			+"FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
}
