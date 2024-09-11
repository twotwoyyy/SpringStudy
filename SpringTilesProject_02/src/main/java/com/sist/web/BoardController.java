package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 브라우저와 연결 => JSP (DAO에서 데이터를 얻어서 JSP로 전송)
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board/list.do")
	public String board_list() {
		
		return "board/list";
	}
}
