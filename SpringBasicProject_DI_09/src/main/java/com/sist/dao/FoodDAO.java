package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
// �޸� �Ҵ�
@Repository // id�� ���ָ� foodDAO�� ã�ƾ� �Ѵ� (�ڵ�����) 
public class FoodDAO {
	@Autowired // �ڵ� �� ����, �������� ����� ��ü �ּҸ� ã�Ƽ� ���� => �ڵ� ���� 
	private FoodMapper mapper;
	
	public List<FoodVO> foodFindData(Map map){
		return mapper.foodFindData(map);
	}
}
