package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodListData(int start,int end){
		return mapper.foodListData(start, end);
	}
	// 총페이지
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	// 상세보기
	public FoodVO foodDetailData(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	
	//// 로그인 처리
	public MemberVO memberLogin(String id,String pwd) {
		MemberVO vo=new MemberVO();
		int count=mapper.memberIdCheck(id);
		if(count==0) { // ID가 없는 상태
			vo.setMsg("NOID");
		}else { // ID가 존재하는 상태
			MemberVO dbvo=mapper.memberGetInfoData(id);
			if(pwd.equals(dbvo.getPwd())) { // 로그인
				vo.setMsg("OK");
				// session을 저장 => 사용자의 일부 정보를 서버에 저장 => 필요시마다 사용이 가능 
				vo.setId(dbvo.getId());
				vo.setName(dbvo.getName());
				vo.setSex(dbvo.getSex());
				
			}else { // 로그인 x (비밀번호 틀림)
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}
	
	public MemberVO memberGetInfoData(String id) {
		return mapper.memberGetInfoData(id);
	}
}
