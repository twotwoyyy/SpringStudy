package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.CommentService;
import com.sist.vo.CommentVO;

import java.util.*;
@RestController
public class CommentRestController {
	@Autowired
	private CommentService cService;
	
	// 공통으로 사용되는 메소드, 호출 
	public String commonsListData(int page,int rno,int type) throws Exception{
		Map map=new HashMap();
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		map.put("start", start);
		map.put("end", end);
		map.put("rno", rno);
		map.put("type", type);
		
		List<CommentVO> list=cService.commentListData(map);
		int totalpage=cService.commentTotalPage(map);
		
		final int BLOCK=5;
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
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value = "comment/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String comment_list(int page, int rno, int type) throws Exception{
		return commonsListData(page, rno, type);
	}
}
