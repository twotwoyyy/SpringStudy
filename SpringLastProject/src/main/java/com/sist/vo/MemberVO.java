package com.sist.vo;
/*
 *   USERID                                    NOT NULL VARCHAR2(20)
 USERNAME                                  NOT NULL VARCHAR2(50)
 USERPWD                                   NOT NULL VARCHAR2(20)
 ENABLED                                            NUMBER(1)
 SEX                                                VARCHAR2(6)
 BIRTHDAY                                  NOT NULL VARCHAR2(20)
 EMAIL                                              VARCHAR2(100)
 POST                                      NOT NULL VARCHAR2(10)
 ADDR1                                     NOT NULL VARCHAR2(500)
 ADDR2                                              VARCHAR2(500)
 PHONE                                              VARCHAR2(20)
 CONTENT                                            CLOB
 REGDATE                                            DATE
 MODIFYDATE                                         DATE
 LASTLOGIN                                          DATE
 */
import java.util.*;

import lombok.Data;
/*
 *    보안 : userName,userPwd 
 *          ======== id
 */
@Data
public class MemberVO {
  private String userId,userPwd,userName,sex,post,addr1,addr2,email,
          phone1,phone2,phone,content,birthday;
  private int enabled;
  private Date regdate,modifydate,lastlogin;
  private String msg,authority;
  
}