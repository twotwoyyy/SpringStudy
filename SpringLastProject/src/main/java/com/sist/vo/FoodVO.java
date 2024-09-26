package com.sist.vo;

import lombok.Data;

/*
 *  이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 FNO                                       NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(500)
 TYPE                                      NOT NULL VARCHAR2(100)
 PHONE                                     NOT NULL VARCHAR2(50)
 ADDRESS                                   NOT NULL VARCHAR2(300)
 SCORE                                              NUMBER(2,1)
 THEME                                              CLOB
 POSTER                                    NOT NULL VARCHAR2(500)
 IMAGES                                             CLOB
 TIME                                               VARCHAR2(50)
 PARKING                                            VARCHAR2(500)
 CONTENT                                            CLOB
 RDAYS                                              VARCHAR2(300)
 JJIMCOUNT                                          NUMBER
 LIKECOUNT                                          NUMBER
 HIT                                                NUMBER
 */
@Data
public class FoodVO {
	private int fno,jjimcount,likecount,hit;
	private String name,type,phone,address,theme,poster,images,time,parking,content,rdays;
	private Double score;
}
