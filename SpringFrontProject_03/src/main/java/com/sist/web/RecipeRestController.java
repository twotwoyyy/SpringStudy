package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
@RestController
public class RecipeRestController {
    @Autowired
    private RecipeDAO dao;
    
    @GetMapping(value = "recipe/list_vue.do",produces = "text/plain;charset=UTF-8")
    public String recipe_list(int page) throws Exception
    {
       int rowSize=20;
      int start=(rowSize*page)-(rowSize-1);
      int end=rowSize*page;      
      
      Map map=new HashMap();
      map.put("start", start);
      map.put("end", end);
      
      List<RecipeVO> list=dao.recipeListData(map);
      int totalpage=dao.recipeTotalPage();
      
      final int BLOCK=10;
      int startPage=((page-1)/BLOCK*BLOCK)+1; // 1,11,21...
      int endPage=((page-1)/BLOCK*BLOCK)+BLOCK; // 10 20 30...
      
      if(endPage>totalpage)
         endPage=totalpage;
      
      map=new HashMap();
      map.put("list", list);
      map.put("curpage", page);
      map.put("totalpage", totalpage);
      map.put("startPage", startPage);
      map.put("endPage", endPage);
      
      // JSON변경 => Boot에서는 자동 처리
      ObjectMapper mapper=new ObjectMapper();
      String json=mapper.writeValueAsString(map);
      
       return json;
    }
    
    @GetMapping(value="recipe/detail_vue.do",produces = "text/plain;charset=UTF-8")
    public String recipe_detail(int no) throws Exception{
    	RecipeDetailVO vo=dao.recipeDetailData(no);
    	List<String> mList=new ArrayList<String>();
    	List<String> iList=new ArrayList<String>();
    	String foodmake=vo.getFoodmake();
    	String[] fm=foodmake.split("\n");
    	
    	for(String s:fm) {
    		StringTokenizer st=new StringTokenizer(s,"^");
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
