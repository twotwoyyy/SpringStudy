package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.*;
public interface EmpMapper {
	// <select> = @Select ��� Annotation���� ���� 
	@Select("SELECT empno,ename,job,hiredate,sal FROM emp")
	public List<EmpVO> empListData();
	//     =========== ========== ==
	//     resultType      id   parameterType
	//        ������      ���̵� ��Ī    �Ű�����
	//@Results => <resultMap> join�� �̿��ϴ� Annotation
}
