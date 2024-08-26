package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
// 관계도를 설정 => 스프링은 설정한 내용으로 설치
// xml => 메뉴얼 
public class EmpDAO {
	private EmpMapper mapper; // Spring으로부터 구현된 클래스를 받아 온다 

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}
