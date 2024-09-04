package com.sist.web;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.*;
/*  =====================
 * 	<화면 관련>
 *	@Controller : 화면 지정 => 어떤 화면을 띄울 것인지 선택
 *                ====== 출력할 데이터 전송 : Model
 *                       addAttribute()
 *	@RestController : 자바스크립트 전송, JSON 전송 => Ajax, Vue, React
 *                    => 화면과는 관련 없다 
 *  사용하는 형식 => 스프링에서 지정 
 *  메소드 관리 (메소드와 관련) 
 *           = 리턴형 
 *             String : forward
 *                      | 데이터 전송 
 *                      | return "경로명/파일명"
 *                      redirect 
 *                      | 이전에 등록된 화면 이동
 *                      | return "redirect:list.do" => _ok.do
 *             void : 다운로드 
 *           = 매개 변수 : DispatcherServlet에서 매개변수를 설정 (스프링 자체에서)
 *                      getParameter() => 매개변수로 처리 
 *                      => ~VO 단위로 값을 받는다 => insert, update, join ... 
 *                         ================= 커맨드 객체 
 *                      => 모든 데이터 : String => 해당 데이터형
 *                         =================
 *                         1. 값이 없는 경우 : String => page를 받는 경우 
 *                                                   검색어 
 *                                         ======================= 디폴트 설정 ex) page="1";
 *                      => String[] : checkbox를 이용해서 값을 받는 경우
 *                      => 내장 객체 
 *                         HttpServletRequest : 사용 금지를 권장 => 객체나 매개변수로 넘기는 것 권장
 *                           => 단점 : 사용자의 IP,PORT를 확인할 수 있어 보안 취약 
 *                           => 사용 : Cookie 값을 가져올 때 사용 (읽기) 
 *                         HttpServletResponse : 사용 금지를 권장
 *                           => 사용 : Cookie 저장 후 브라우저 전송, 다운로드 
 *                         HttpSession : 로그인 / session이 필요한 위치 
 *                         RedirectAttributes : redirect에서 값을 전송할 때 사용 
 *                            return "redirect:detail.do?no="+no
 *                              ra.addAttribute("no",no)
 *                            => return "redirect:detail.do";
 *                         Model : request를 대체하는 전송 객체 
 *                         => Cookie는 내장 객체가 아님, request를 이용해야 한다 
 *                         => 매개 변수는 순서없이 설정이 가능하다         
 *           = 메소드명 : 자유롭게 사용 가능 => URL 주소만 잘 매칭
 *  =====================
 *  <데이터베이스 연동과 관련>
 *  @Repository : 테이블 한 개만 연결 => 재사용
 *  @Service : DAO가 여러 개 있는 경우 한번에 모아준다
 *             emp / dept 
 *             board / reply
 *  =====================
 *  <오류 처리와 관련>
 *  @ControllerAdvice : 통합 예외 처리 => WEB에서만 가능
 *  
 *  => 스프링에서 주로 사용되는 패키지 
 *     com.sist.vo : 사용자 정의 데이터형 => 데이터베이스 컬럼명과 동일, 오라클로부터 데이터 저장 
 *     com.sist.dao : 데이터베이스 연동 
 *     com.sist.service : DAO를 여러 개 묶어서 사용
 *     com.sist.manager : 추천, 크롤링, 외부 데이터 가져올 때 사용 => OpenAPI
 *     com.sist.web : Model => 조립 => 결과값 전송 
 *     com.sist.intercept : 중간에 처리가 가능      | (intercept) => 자동 로그인
 *          사용자 요청(.do) == DispatcherServlet == HandlerMapping
 *                                                     |
 *          			                          com.sist.web
 *                                                @GetMapping
 *                                                @PostMapping
 *                                                @RequestMapping
 *                                                => URL 주소를 이용해서 메소드를 호출 
 *                                          (intercept)| 결과값 (Model)
 *                                                ViewResolver
 *                                          (intercept)| request로 변환
 *                                                    JSP
 *     com.sist.aop : 공통으로 사용 => 요청 처리 수행 시간 
 *                    => footer에 출력 : 자동화 처리 
 *     com.sist.commons : 예외 처리를 한 번에 처리
 *     com.sist.security : login (접근 거부), 권한 부여 => 메뉴 변경 
 *                         remember-me (자동 로그인)
 *                         비밀 번호 : 암호화 
 *     com.sist.chat : webchat (실시간 채팅)
 *                        | 접속자 전체 채팅 
 *                        | 상담사와 채팅 => 1:1 채팅
 *     =============================================================================
 *     패키지 안에서 사용하는 클래스 => 관리하는 영역이 Spring 
 *                               ==== 클래스 메모리 할당 ==== 소멸 (메모리 해제) 
 *     * DispatcherServlet
 *       =================
 *       1. @WebServlet("*.do") => 스프링에는 존재하지 않는다
 *          => web.xml에 등록 
 *             ======= 톰캣에서 읽어가는 파일 
 *             => 서블릿과 JSP는 톰캣에 의해 구동 
 *                =========== 찾는 방법 : URL 
 *             => request를 사용하지 않는다
 *                => 한글 변환 => 등록 
 *             => request는 post,get 동시에 사용 가능 
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.DataBoardDAO;
import com.sist.vo.DataBoardVO;

import oracle.jdbc.proxy.annotation.Post;
@Controller
@RequestMapping("databoard/") // 공통으로 사용되는 URL 주소를 모아서 적용 
public class DataBoardController {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private DataBoardDAO dao;
	
	// 사용자 요청에 대한 처리 
	@GetMapping("list.do")
	public String databoard_list(String page,Model model) {
		  //String en=encoder.encode("1234");
		  //System.out.println(en);
	      if(page==null)
	          page="1";
	       int curpage=Integer.parseInt(page);
	       int rowSize=10;
	       int start=(rowSize*curpage)-(rowSize-1);
	       int end=rowSize*curpage;
	       List<DataBoardVO> list=dao.databoardListData(start, end);
	       // 총페이지
	       int count=dao.databoardRowCount();
	       int totalpage=(int)(Math.ceil(count/(double)rowSize));
	       count=count-((rowSize*curpage)-rowSize);
	       // 사용자로부터 받는 값 => Model : 결과값 전송 객체
	       // 출력에 필요한 데이터를 list.jsp로 전송
	       model.addAttribute("curpage", curpage);
	       model.addAttribute("totalpage", totalpage);
	       model.addAttribute("count", count);
	       model.addAttribute("list",list);

	       return "databoard/list"; // .jsp를 붙이면 404
	}
	// 데이터 추가
	@GetMapping("insert.do")
	public String databoard_insert() {
		return "databoard/insert";
	}
	// 실제 데이터 첨부
	@PostMapping("insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo){
		String en=encoder.encode(vo.getPwd());
		vo.setPwd(en); // 암호화
		String path="c:\\spring_upload";
		List<MultipartFile> list=vo.getFiles();
		if(list==null) {
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}else { // 업로드 된 파일이 들어온 상태
			try {
				String filename="";
				String filesize="";
				for(MultipartFile mf:list) {
					String name=mf.getOriginalFilename(); // 사용자가 보내 준 파일명
					File file=new File(path+"\\"+name);
					mf.transferTo(file); // 파일 업로드
					filename+=file.getName()+",";
					filesize+=file.length()+",";
				}
				filename=filename.substring(0,filename.lastIndexOf(",")); // 맨 마지막 , 제거
				filesize=filesize.substring(0,filesize.lastIndexOf(","));
				
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
			}catch(Exception ex) {}
		}
		dao.databoardInsert(vo);
		return "redirect:list.do";
	}
	// 상세보기
	@GetMapping("detail.do")
	public String databoard_datail(int no, Model model) {
		DataBoardVO vo=dao.databoardDetailData(no);
		if(vo.getFilecount()!=0) {
			
		List<String> nList=new ArrayList<String>(); 
		List<String> cList=new ArrayList<String>();
		String[] names=vo.getFilename().split(",");
		String[] lens=vo.getFilesize().split(",");
		nList=Arrays.asList(names);
		cList=Arrays.asList(lens);
		// 배열을 List로 변경 
		model.addAttribute("nList",nList);
		model.addAttribute("cList",cList); // a.jpg(1000byte)
		}
		model.addAttribute("vo",vo);
		return "databoard/detail";
	}
	// 다운로드
	@GetMapping("download.do")
	public void databoard_download(String fn, HttpServletResponse response) {
		try {
			String path="c:\\spring_upload";
			// 서버에서 파일을 읽어서 한 개의 메모리에 저장 => 속도를 빠르게 만든다 
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(path+"\\"+fn));
			// 클라이언트 영역 : 다운로드 요청
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			
			// 1. 다운로드 창을 보여준다 
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn,"UTF-8"));
			File file=new File(path+"\\"+fn);
			response.setContentLength((int)file.length()); // 프로그래스바
			
			// 2. 실제 다운로드
			byte[] buffer=new byte[1024]; // TCP:1024, UDP:512
			int i=0; // 파일에서 읽은 byte 크기 
			while((i=bis.read(buffer,0,1024))!=-1) {
				// -1 : EOP
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
		}catch(Exception ex) {}
	}
	@GetMapping("delete.do")
	public String databoard_delete(int no, Model model) {
		model.addAttribute("no",no);
		return "databoard/delete";
	}
	
	@PostMapping("delete_ok.do")
	public String databoard_delete_ok(int no, String pwd, Model model) {
		DataBoardVO vo=dao.databoardFileInfoData(no);
		boolean bCheck=dao.databoardDelete(no, pwd);
		model.addAttribute("bCheck",bCheck);
		try {
			String files=vo.getFilename();
			if(vo.getFilecount()!=0) { //파일 삭제 부분 
				StringTokenizer st=new StringTokenizer(files,",");
				while(st.hasMoreTokens()) {
					File file=new File("c:\\spring_upload\\"+st.nextToken());
					file.delete();
				}
			}
		}catch(Exception ex) {}
		return "databoard/delete_ok";
	}
}
