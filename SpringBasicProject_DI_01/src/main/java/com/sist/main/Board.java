package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor // �Ű����� �ִ� ������ 
@NoArgsConstructor // �Ű����� ���� ������
public class Board {
	private int bno;
	private String name;
	private String subject;
	
	public void print() {
		System.out.println("��ȣ:"+bno);
		System.out.println("�̸�:"+name);
		System.out.println("����:"+subject);
	}
}
