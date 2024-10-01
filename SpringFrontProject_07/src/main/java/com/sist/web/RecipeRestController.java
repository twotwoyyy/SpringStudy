package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
@RequestMapping("recipe/")
public class RecipeRestController {
	@Autowired
	private RecipeDAO rDao;
	
	@GetMapping(value= "list_vue.do", produces = "text/plain;charset=UTF-8")
	public String reciep_list(int page) throws Exception {
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1); //rownum=1부터 시작이기에 
		int end=rowSize*page;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<RecipeVO> list=rDao.recipeListData(map);
		int totalpage=rDao.recipeTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
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
	public String recipe_detail(int no) throws Exception {
		RecipeDetailVO vo=rDao.recipeDetailData(no);
		String s=vo.getData();
		s=s.replace("구매", "");
		vo.setData(s.trim());
		String[] makes=vo.getFoodmake().split("\n");
		List<String> mList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		
		for(String m:makes) {
			StringTokenizer st=new StringTokenizer(m,"^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		Map map=new HashMap();
		map.put("vo", vo);
		map.put("mList", mList);
		map.put("iList", iList);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	
}
