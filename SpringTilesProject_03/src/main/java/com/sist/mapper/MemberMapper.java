package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MemberMapper {
	// ID 존재 여부 확인 
	@Select("SELECT COUNT(*) FROM project_member "
			+"WHERE id=#{id}")
	public int memberIdCount(String id);
	
	// PWD를 검색 
	@Select("SELECT pwd,id,name,admin FROM project_member "
			+"WHERE id=#{id}")
	public MemberVO memberGetPassword(String id);
}
