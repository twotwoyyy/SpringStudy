package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.net.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
// VueJS와 연결
@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao;
	
	@GetMapping(value = "databoard/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String databoard_list(int page) throws Exception {
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<DataBoardVO> list=dao.databoardListData(start, end);
		int count=dao.databoardCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((rowSize*page)-rowSize);
		
		// VueJS로 데이터 전송 
		Map map=new HashMap();
		map.put("list", list);
		map.put("count", count);
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		
		// 자바스크립트와 연결 => Map을 JSON으로 변경 
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	// C:\\SpringDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringFrontProject_05\
	@PostMapping(value = "databoard/insert_vue.do",produces = "text/plain;charset=UTF-8")
	public String databoard_insert(DataBoardVO vo,HttpServletRequest request) {
//		System.out.println(vo.getName());
//		System.out.println(vo.getSubject());
//		System.out.println(vo.getContent());
//		System.out.println(vo.getPwd());
//		System.out.println(vo.getFiles().size());
//		if(vo.getFiles().size()>0) {
//			for(int i=0;i<vo.getFiles().size();i++) {
//				System.out.println(vo.getFiles().get(i).getOriginalFilename());
//			}
//		}
		String result="";
		try {
			String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
			File dir=new File(path);
			if(!dir.exists()) { // 폴더가 존재하지 않으면
				dir.mkdir(); // 폴더를 만들어라 
			}
			path=path.replace("\\", File.separator); // 운영 체제에 따라 자동으로 변경, mac,리눅스: /, 윈도우:\\
			//System.out.println(path);
			List<MultipartFile> list=vo.getFiles();
			if(list==null) { // 업로드가 없는 경우
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
			}else { // 업로드가 있는 상태
				String filename="";
				String filesize="";
				for(MultipartFile mf:list) {
					String name=mf.getOriginalFilename(); // 실제 파일명 
					// 나중엔 DB에 따로 저장할 수 있도록 프로젝트 때 질문, 반영, 알아보기 
					// 현재는 ,로 묶어서 저장 
					File file=new File(path+name);
					mf.transferTo(file); // 업로드
					filename+=name+",";
					filesize+=file.length()+",";
				}
				filename=filename.substring(0,filename.lastIndexOf(","));
				filesize=filesize.substring(0,filesize.lastIndexOf(",")); // 마지막 콤마를 지우기
				vo.setFilecount(list.size());
				vo.setFilename(filename);
				vo.setFilesize(filesize);
			}
			dao.databoardInsert(vo);
			result="yes"; // 마지막에 배치 (중간 오류 있을 수 있기 때문)
		}catch(Exception ex) {
			result=ex.getMessage();
		}
		return result;
	}
	
	@GetMapping(value="databoard/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String databoard_detail(int no) throws Exception { // JSON 변경시 예외처리 필요
		DataBoardVO vo=dao.databoardDetailData(no);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	
	@GetMapping(value="databoard/download.do", produces = "text/plain;charset=UTF-8")
	public void databoard_download(String fn, HttpServletResponse response, HttpServletRequest request) {
		try {
			String path=request.getSession().getServletContext().getRealPath("/")+"upload\\"; // 루트 경로 + 폴더명\\
			path=path.replace("\\", File.separator);
			File file=new File(path+fn);
			// 다운로드창 띄우기
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn,"UTF-8"));
			response.setContentLength((int)file.length());
			// 실제 다운로드
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file)); // 서버에서 값읽기
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream()); // 사용자한테 데이터 전송
			
			int i=0; // 읽은 Byte 수
			byte[] buffer=new byte[1024];
			while((i=bis.read(buffer,0,1024))!=-1) {
				bos.write(buffer,0,i);
			}
			bis.close();
			bos.close();
			
		}catch(Exception ex) {
			
		}
	}
}
