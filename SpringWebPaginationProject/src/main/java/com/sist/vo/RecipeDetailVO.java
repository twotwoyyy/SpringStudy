package com.sist.vo;

import lombok.Data;

/*    
	------------ -------- -------------- 
	NO           NOT NULL NUMBER         
	POSTER                VARCHAR2(4000) 
	TITLE                 VARCHAR2(1000) 
	CHEF                  VARCHAR2(1000) 
	CHEF_POSTER           VARCHAR2(1000) 
	CHEF_PROFILE          VARCHAR2(1000) 
	INFO1                 VARCHAR2(100)  
	INFO2                 VARCHAR2(100)  
	INFO3                 VARCHAR2(100)  
	CONTENT               VARCHAR2(4000) 
	FOODMAKE     NOT NULL CLOB           
	DATA                  CLOB           

 */
@Data
public class RecipeDetailVO {
	private int no;
	private String poster,title,chef,chef_poster,chef_profile,inf01,inf02,inf03,content,foodmake,data;
}
