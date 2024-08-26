package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.DeptVO;
public interface DeptMapper {
	@Select("SELECT * FROM dept ORDER BY deptno ASC")
	public List<DeptVO> deptListData();
}
