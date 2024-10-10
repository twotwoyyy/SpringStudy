package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
 *  이름      널?       유형             
	------- -------- -------------- 
	NO      NOT NULL NUMBER         
	ID               VARCHAR2(20)   
	NAME    NOT NULL VARCHAR2(50)   
	SUBJECT NOT NULL VARCHAR2(2000) 
	CONTENT NOT NULL CLOB           
	HIT              NUMBER         
 */
@Data
public class FreeBoardVO {
	private int no,hit;
	private String id,name,subject,content,dbday;
	private Date regdate;
}
