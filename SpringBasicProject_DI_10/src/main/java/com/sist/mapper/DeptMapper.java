package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;
public interface DeptMapper {
	@Select("SELECT deptno,dname,loc "
			+"FROM dept ORDER BY deptno ASC")
	public List<DeptVO> deptListData();
	// 메소드 자동 구현
	
	
	/*	리턴형 : resultType
	 * 	매개변수 : parameterType
	 * 	메소드명 : id
	 * 
	 * 
	 *  <select if="" resultType="" parameterType="">
	 *   SELECT deptno,dname,loc 
		 FROM dept ORDER BY deptno ASC
	 *  </select>
	 */
}
