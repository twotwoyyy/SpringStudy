package com.sist.service;

import java.util.List;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;
// ���ռ��� ���� ���α׷� => ���� ������ ������ ��ġ�� �ʴ´� 
public interface EmpDeptService {
	public List<EmpVO> empListData();
	public List<DeptVO> deptListData();
}
