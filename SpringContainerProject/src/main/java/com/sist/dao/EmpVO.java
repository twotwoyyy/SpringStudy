package com.sist.dao;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private int empno,sal;
	private String ename,job;
	private Date hiredate;
}
