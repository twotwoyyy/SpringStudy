package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
 *  이름         널?       유형           
	---------- -------- ------------ 
	CNO        NOT NULL NUMBER       
	RNO                 NUMBER       
	ID                  VARCHAR2(20) 
	NAME       NOT NULL VARCHAR2(50) 
	SEX                 VARCHAR2(20) 
	MSG        NOT NULL CLOB         
	REGDATE             DATE         
	LIKECOUNT           NUMBER       
	GROUP_ID            NUMBER       
	GROUP_STEP          NUMBER       
	GROUP_TAB           NUMBER       
	DEPTH               NUMBER       
	ROOT                NUMBER       
	MODIFYDATE          DATE       
 */
// recipe(1) / seoul(2) / goods(3) ===> 프로시저
@Data
public class CommentVO {
	private int cno,rno,likecount,group_id,group_step,group_tab,depth,root,type;
	private String id,name,sex,msg,dbday;
	private Date regdate,modifydate;
}
