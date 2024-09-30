package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;

@RestController
@RequestMapping("food/")
public class ReplyRestController {
	@Autowired
	private FoodDAO fDao;
	
	@PostMapping(value="list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_login(String id,String pwd, HttpSession session) {
		MemberVO vo=fDao.memberLogin(id, pwd);
		if(vo.getMsg().equals("OK")) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("sex", vo.getSex());
		}
		return vo.getMsg();
	}
}
