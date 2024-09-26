package com.sist.vo;

import lombok.Data;

/*
 *  이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 USERID                                             VARCHAR2(20)
 AUTHORITY                                 NOT NULL VARCHAR2(20)
 
 *  권한은 1개가 아니라 여러 개 가질 수 있기에 따로 테이블로 구성
 */
@Data
public class AuthorityVO {
	private String userId,authority;
}
