package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodService fService;
	
	@GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list(int page) throws Exception{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<FoodVO> list=fService.foodListData(start, end);
		int totalpage=fService.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 데이터를 모아서 JSON => VueJS로 전송
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	
	// 검색
	@GetMapping(value="food/find_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_find(int page, String fd) throws Exception{
		// Service 연동
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		
		List<FoodVO> list=fService.foodFindListData(map);
		int totalpage=fService.foodFindTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		// JSON으로 변환 후 전송
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
