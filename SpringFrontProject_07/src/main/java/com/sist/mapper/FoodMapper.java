package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;

public interface FoodMapper {
	@Select("SELECT fno,name,poster,phone,type,hit,score,num "
			+"FROM (SELECT fno,name,poster,phone,type,hit,score,rownum as num "
			+"FROM (SELECT fno,name,poster,phone,type,hit,score "
			+"FROM project_food_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start")int start,@Param("end")int end);
	// 총페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food_house")
	public int foodTotalPage();
	// 상세보기
	@Update("UPDATE project_food_house SET hit=hit+1 WHERE fno=#{fno}")
	public void foodHitIncrement(int fno);
	
	@Select("SELECT * FROM project_food_house WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	// 로그인 처리(MemberMapper)
	@Select("SELECT COUNT(*) FROM project_member WHERE id=#{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT id,name,sex,pwd FROM project_member WHERE id=#{id}")
	public MemberVO memberGetInfoData(String id);
}
