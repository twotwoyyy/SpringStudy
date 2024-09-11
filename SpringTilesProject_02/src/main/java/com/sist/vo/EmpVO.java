package com.sist.vo;
import java.util.*;

import lombok.Data;
// JOIN => 포함 클래스
/*
 *	SELECT empno,ename,sal,job,TO_CHAR(hiredate,'') as dbday,dname,loc,grade
 *  FROM emp,dept,grade
 *  WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal
 *  
 *  => setEmpno() setEname() setSal() setDbday()
 *  => setDname() setLoc() setGrade() 
 *     dvo.setDname() 
 */
@Data
public class EmpVO {
	private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
	
	// 포함 has-a
	private DeptVO dvo=new DeptVO();
	private SalgradeVO svo=new SalgradeVO();
}
