package com.sist.dao;

public class MyDAO {
	// getConnection / disConnection 
	// �������� ���Ǵ� �κ� 
	// ================================
	public void getConnection() {
		System.out.println("����Ŭ ����");
	}
	public void disConnection() {
		System.out.println("����Ŭ ����");
	}
	// ====================== AOP ��� 
	// AOP�� OOP���� ���� ���ϴ� �ڵ� ȣ���� �����ϰ� ����� �ش� : OOP�� ���� 
	public void select() {
		//getConnection(); // before
		System.out.println("SELECT ���� ó��..");
		//disConnection(); // after
	}
	public void insert() {
		//getConnection();
		System.out.println("INSERT ���� ó��..");
		//disConnection();
	}
	public void update() {
		//getConnection();
		System.out.println("UPDATE ���� ó��..");
		//disConnection();
	}
	public void delete() {
		//getConnection();
		int a=10/0;
		System.out.println("a="+a);
		System.out.println("DELETE ���� ó��..");
		//disConnection();
	}
	public String find(String fd) {
		
		return fd+"ã�� �Ϸ�~~";
	}
	

}
