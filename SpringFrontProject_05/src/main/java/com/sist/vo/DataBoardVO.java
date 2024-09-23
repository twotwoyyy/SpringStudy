package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class DataBoardVO {
	private int no,hit,filecount;
	private String name,subject,content,pwd,filename,filesize,dbday;
	private Date regdate;
	// Upload 파일을 저장하는 List
	// files[0], files[1] .. 인덱스 번호 이용 
	private List<MultipartFile> files;
}
