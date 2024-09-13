package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mDao;
	// 서비스의 기본 
	@Override
	public MemberVO isLogin(String id, String pwd) {
		MemberVO vo=new MemberVO();
		int count=mDao.memberIdCount(id);
		if(count==0) {
			// 아이디가 없는 상태
			vo.setMsg("NOID");
		}else {
			// 아이디가 있는 상태
			MemberVO dvo=mDao.memberGetPassword(id);
			if(pwd.equals(dvo.getPwd())){
				vo.setId(dvo.getId());
				vo.setName(dvo.getName());
				vo.setAdmin(dvo.getAdmin());
				vo.setMsg("OK");
				// session에 저장 목적 
			}else { // Password가 틀린 상태 
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}


}
