package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 다른 언어와 연동 => 자바스크립트로 데이터 전송 / Kotlin => JSON 전송
/*
 * @GetMapping
 * @PostMapping
 * @PutMapping
 * @DeleteMapping
 * ================ @RequestMapping (가급적이면 사용하지 않는다)
 * 					=> Spring6에서 사라짐
 * 					=> Spring5 => 보안
 * 						=> XML을 자바로 변환
 */
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class ChefRestController {
	@Autowired // 스프링에서 생성된 rService의 주소값을 주입 => 반드시 스프링에서 생성된 객체만 
	private RecipeService rService;
	
	@GetMapping(value = "chef/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String chef_list(int page) throws Exception {
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<ChefVO> list=rService.chefListData(map);
		int totalpage=rService.chefTotalPage();
		
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
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	@GetMapping(value = "chef/recipe_make.do", produces = "text/plain;charset=UTF-8")
	public String recipe_make(String chef) throws Exception {
		List<RecipeVO> list=rService.recipeMakeData(chef);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		
		return json;
	}
	
}
