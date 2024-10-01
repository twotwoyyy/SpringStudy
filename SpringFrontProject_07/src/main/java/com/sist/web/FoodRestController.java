package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
@RequestMapping("food/")
public class FoodRestController {
	@Autowired
	private FoodDAO fDao;
	
	@PostMapping(value="login_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_login(String id,String pwd, HttpSession session) {
		MemberVO vo=fDao.memberLogin(id, pwd);
		if(vo.getMsg().equals("OK")) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("sex", vo.getSex());
		}
		return vo.getMsg();
	}
	
	@GetMapping(value="list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_list(int page) throws Exception {
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1); //rownum=1부터 시작이기에 
		int end=rowSize*page;

		List<FoodVO> list=fDao.foodListData(start, end);
		for(FoodVO vo:list) {
			vo.setPoster("http://www.menupan.com"+vo.getPoster());
		}
		int totalpage=fDao.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		Map map=new HashMap();
		map.put("list", list); // list:[]
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		// 자바스크립트가 인식하는 언어로 변경 
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	@GetMapping(value="detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_detail(int fno) throws Exception {
		FoodVO vo=fDao.foodDetailData(fno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	

}
