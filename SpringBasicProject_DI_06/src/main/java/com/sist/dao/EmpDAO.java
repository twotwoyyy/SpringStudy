package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
// ���赵�� ���� => �������� ������ �������� ��ġ
// xml => �޴��� 
public class EmpDAO {
	private EmpMapper mapper; // Spring���κ��� ������ Ŭ������ �޾� �´� 

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}
