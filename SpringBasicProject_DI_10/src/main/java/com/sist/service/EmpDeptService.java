package com.sist.service;

import java.util.List;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;
// 결합성이 낮은 프로그램 => 유지 보수시 영향을 미치지 않는다 
public interface EmpDeptService {
	public List<EmpVO> empListData();
	public List<DeptVO> deptListData();
}
