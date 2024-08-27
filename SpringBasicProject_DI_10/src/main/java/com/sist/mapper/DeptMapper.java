package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;
public interface DeptMapper {
	@Select("SELECT deptno,dname,loc "
			+"FROM dept ORDER BY deptno ASC")
	public List<DeptVO> deptListData();
	// �޼ҵ� �ڵ� ����
	
	
	/*	������ : resultType
	 * 	�Ű����� : parameterType
	 * 	�޼ҵ�� : id
	 * 
	 * 
	 *  <select if="" resultType="" parameterType="">
	 *   SELECT deptno,dname,loc 
		 FROM dept ORDER BY deptno ASC
	 *  </select>
	 */
}
