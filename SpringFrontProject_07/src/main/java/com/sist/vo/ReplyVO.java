package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
 * 이름      널?       유형           
------- -------- ------------ 
RNO     NOT NULL NUMBER       
FNO              NUMBER       
ID               VARCHAR2(20) 
NAME    NOT NULL VARCHAR2(50) 
MSG     NOT NULL CLOB         
REGDATE          DATE         

 */
@Data
public class ReplyVO {
	private int rno,fno;
	private String id,name,msg,dbday;
	private Date regdate;
}
