package com.sist.dao;

import lombok.Data;

@Data
public class MyDataSource {
	private String driver;
	private String url,username,password;
}
