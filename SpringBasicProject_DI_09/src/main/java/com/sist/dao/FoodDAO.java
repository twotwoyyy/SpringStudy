package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
// 메모리 할당
@Repository // id를 안주면 foodDAO로 찾아야 한다 (자동생성) 
public class FoodDAO {
	@Autowired // 자동 값 주입, 스프링에 저장된 객체 주소를 찾아서 주입 => 자동 주입 
	private FoodMapper mapper;
	
	public List<FoodVO> foodFindData(Map map){
		return mapper.foodFindData(map);
	}
}
