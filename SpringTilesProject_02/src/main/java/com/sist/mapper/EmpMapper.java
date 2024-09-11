package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {
	/*
	 *  <select id="empListData" resultMap="empMap">
	 		SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc,grade
	 		FROM emp,dept,salgrade
	 		WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal
 		</select>
	 */
	public List<EmpVO> empListData();
	
	// 상세보기 (조인)
	// @ResultMap("empMap") => XML(id) => xml에서 가져올 경우
	// 여기서 처리할 경우 아래 주석처럼
	/*@Results({
		@Result(property = "dvo.dname", column = "dname"),
		@Result(property = "dvo.loc", column = "loc"),
		@Result(property = "svo.grade", column = "grade")
	})*/
	@ResultMap("empMap")
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc,grade "
			+"FROM emp,dept,salgrade "
			+"WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal "
			+"AND empno=#{empno}")
	public EmpVO empDetailData(int empno);
}
