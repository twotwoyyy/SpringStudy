package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.*;
public interface EmpMapper {
	// <select> = @Select 라는 Annotation으로 변경 
	@Select("SELECT empno,ename,job,hiredate,sal FROM emp")
	public List<EmpVO> empListData();
	//     =========== ========== ==
	//     resultType      id   parameterType
	//        리턴형      아이디 명칭    매개변수
	//@Results => <resultMap> join시 이용하는 Annotation
}
