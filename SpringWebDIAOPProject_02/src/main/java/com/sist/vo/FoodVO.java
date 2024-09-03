package com.sist.vo;

import lombok.Data;

/*
 *  �̸�                                      ��?      ����
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
	private int fno;
	private String name, type, address, time, parking, theme, phone, poster;
}
