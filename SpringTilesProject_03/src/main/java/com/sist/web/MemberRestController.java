package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.MemberService;
import com.sist.vo.MemberVO;
/*
 *   Controller ===== Service ==== DAO (유지보수) ===> 결합성 낮게 
 *              =====         ====         
 */
// => 경우의 수가 많을 때 (ID,PWD,OK) 자바스크립트 사용 
@RestController
@CrossOrigin(origins = "*") // vue => 3000 => 8080 
public class MemberRestController {
	@Autowired
	private MemberService mService;
	// 핵심 => HttpSession => 매개변수로 받아서 처리 
	/*
	 *	Interceptor : 구현 
	 */
	@Async // 비동기화 프로그램 (속도 개선)
	@PostMapping(value="member/login_ok.do",produces="text/html;charset=UTF-8")
	public String member_login_ok(String id,String pwd,HttpSession session) {
		String result="";
		MemberVO vo=mService.isLogin(id, pwd);
		if(vo.getMsg().equals("NOID")) {
			result="<script>"
					+"alert(\"아이디가 존재하지 않습니다!!\");"
					+"history.back();"
					+"</script>";
		}else if(vo.getMsg().equals("NOPWD")) {
			result="<script>"
					+"alert(\"비밀번호가 틀립니다!!\");"
					+"history.back();"
					+"</script>";
		}else {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
			result="<script>"
					+"location.href=\"../main/main.do\";"
					+"</script>";
			/*
			 * 스프링을 통해서 내장 객체를 매개변수로 받는다 
			 * HttpSession
			 * HttpServletRequest => Cookie
			 * HttpServletResponse => Cookie, 업로드
			 * Model => 데이터 전송 : forward = request값 JSP로 전송 
			 * RedirectAttributes : sendRedirect()
			 */
		}
		return result;
	}
}
