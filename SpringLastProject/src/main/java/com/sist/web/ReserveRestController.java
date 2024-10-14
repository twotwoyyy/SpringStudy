package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
@RestController
public class ReserveRestController {
	@Autowired
	private ReserveService rService;
	
	@GetMapping(value = "reserve/reserve_main_vue.do", produces = "text/plain;charset=UTF-8")
	public String reserve_food_info(String type, int page) throws Exception {
		int rowSize=30;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("type", type);
		List<FoodVO> list=rService.reserveFoodInfoData(map);
		int totalpage=rService.reserveFoodTotalPage(map);
		
		map=new HashMap();
		map.put("curpage", page);
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("type", type);
		
		List<String> tList=new ArrayList<String>();
		tList.add("09:00");
		tList.add("11:00");
		tList.add("13:00");
		tList.add("15:00");
		tList.add("17:00");
		tList.add("19:00");
		tList.add("20:00");
		tList.add("21:00");
		tList.add("22:00");
		
		List<String> iList=new ArrayList<String>();
		for(int i=1;i<10;i++) {
			iList.add(String.valueOf(i));
		}
		iList.add("단체");
		
		map.put("tList", tList);
		map.put("iList", iList);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	@PostMapping(value = "reserve/reserve_ok_vue.do", produces = "text/plain;charset=UTF-8")
	public String reserve_ok(ReserverVO vo, HttpSession session) throws Exception {
		String result="";
		try {
			String id=(String)session.getAttribute("userId");
			vo.setId(id);
			rService.reserveInsert(vo);
			result="yes";
		}catch(Exception ex) {
			result=ex.getMessage();
		}
//		System.out.println("맛집 번호:"+vo.getRno());
//		System.out.println("에약일:"+vo.getRday());
//		System.out.println("예약 시간:"+vo.getRtime());
//		System.out.println("인원:"+vo.getRinwon());
		return result;
	}
	@GetMapping(value = "mypage/mypage_reserve_vue.do", produces = "text/plain;charset=UTF-8")
	public String mypage_reserve(HttpSession session) throws Exception {
		String id=(String)session.getAttribute("userId");
		List<ReserverVO> list=rService.reserveMypageListData(id);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value = "admin/admin_reserve_vue.do", produces = "text/plain;charset=UTF-8")
	public String admin_reserve() throws Exception {
		List<ReserverVO> list=rService.reserveAdminListData();
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}

	@GetMapping(value = "admin/admin_reserve_ok_vue.do", produces = "text/plain;charset=UTF-8")
	public String admin_reserve_ok(int rno) throws Exception {
		rService.reserveOk(rno);
		List<ReserverVO> list=rService.reserveAdminListData();
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
}
