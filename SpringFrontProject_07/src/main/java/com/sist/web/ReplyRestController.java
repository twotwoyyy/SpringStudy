package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class ReplyRestController {
	@Autowired
	private ReplyDAO rDao;
	
	public String commonsListData(int fno) throws Exception{
		List<ReplyVO> list=rDao.replyListData(fno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value="food/reply_list_vue.do", produces = "text/plain;charset=UTF-8")
	public String reply_list(int fno) throws Exception{
		return commonsListData(fno);
	}
	
	@PostMapping(value="food/reply_insert_vue.do", produces = "text/plain;charset=UTF-8")
	public String reply_insert(ReplyVO vo, HttpSession session) throws Exception {
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		vo.setId(id);
		vo.setName(name);
		rDao.replyInsert(vo);
		return commonsListData(vo.getFno());
	}
	@GetMapping(value="food/reply_delete_vue.do", produces = "text/plain;charset=UTF-8")
	public String reply_delete(int rno, int fno) throws Exception {
		rDao.replyDelete(rno);
		return commonsListData(fno);
	}
	@PostMapping(value="food/reply_update_vue.do", produces = "text/plain;charset=UTF-8")
	public String reply_update(ReplyVO vo) throws Exception {
		rDao.replyUpdate(vo);
		return commonsListData(vo.getFno());
	}
}
