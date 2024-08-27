package com.sist.vo;
// 메모리 할당 대상이 아니다
import java.util.*;

import lombok.Data;

@Data
public class EmpVO {
	private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
}
