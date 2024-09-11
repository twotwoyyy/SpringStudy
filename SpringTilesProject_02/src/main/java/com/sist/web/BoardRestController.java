package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO bDao;
	
	@GetMapping(value = "board/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String board_list(int page) throws Exception{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=bDao.boardListData(map);
		int totalpage=bDao.boardTotalPage();
		
		Map sendMap=new HashMap();
		sendMap.put("curpage", page);
		sendMap.put("totalpage", totalpage);
		sendMap.put("list", list);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(sendMap);
		return json;
	}
}
