package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class MypageRestController {
	@Autowired
	private ReserveService rService;
	
	@Autowired
	private GoodsService gService;
	
	@GetMapping(value = "mypage/reserve_info_vue.do", produces = "text/plain;charset=UTF-8")
	public String reserve_info(int fno, int rno) throws Exception {
		ReserverVO vo=rService.reserveInfoData(rno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	@GetMapping(value = "mypage/mypage_cart_vue.do", produces = "text/plain;charset=UTF-8")
	public String mypage_cart(HttpSession session) throws Exception {
		String id=(String)session.getAttribute("userId");
		List<CartVO> list=gService.goodsCartListData(id);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value = "mypage/mypage_buy_vue.do", produces = "text/plain;charset=UTF-8")
	public String mypage_buy(HttpSession session) throws Exception {
		String id=(String)session.getAttribute("userId");
		List<CartVO> list=gService.goodsBuyListData(id);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value = "mypage/goods_buy_vue.do", produces = "text/plain;charset=UTF-8")
	public String mypage_buy(int cno,int gno,HttpSession session) throws Exception {
		gService.goodsBuy(cno);
		GoodsVO gvo=gService.goodsDetailData(gno);
		String temp=gvo.getGoods_price();
	    temp = temp.replaceAll("[^0-9]", ""); // 모든 숫자가 아닌 문자를 제거
	    gvo.setPrice(Integer.parseInt(temp.trim())); // 공백이 없는 문자열을 Integer로 변환
	    String id=(String)session.getAttribute("userId");
	    
	    MemberVO mvo=gService.memberInfoData(id);
	    
	    Map map=new HashMap();
	    map.put("gvo", gvo);
	    map.put("mvo", mvo);
	    
	    ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
