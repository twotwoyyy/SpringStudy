package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface ChefMapper {
	@Select("SELECT chef,poster "
			+ "FROM chef "
			+ "WHERE chef=(SELECT chef FROM recipe WHERE hit=(SELECT MAX(hit) FROM recipe))")
	public ChefVO chefToday();
	
	// 목록 출력
	@Select("SELECT chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7,num "
			+"FROM (SELECT chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7,rownum as num "
			+"FROM (SELECT /*+INDEX_ASC(chef chef_chef_pk)*/chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7 "
			+"FROM chef)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
	public int chefTotalPage();
}
