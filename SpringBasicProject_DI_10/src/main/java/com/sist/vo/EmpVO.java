package com.sist.vo;
// �޸� �Ҵ� ����� �ƴϴ�
import java.util.*;

import lombok.Data;

@Data
public class EmpVO {
	private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
}
