package com.sist.main;
class Reply{
	private int rno;
	private String id;
	private String name;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Reply(int rno, String id, String name) {
		this.rno = rno;
		this.id = id;
		this.name = name;
	}
	public void print() {
		System.out.println("��ȣ:"+rno);
		System.out.println("���̵�:"+id);
		System.out.println("�̸�:"+name);
	}
}
public class MainClass4 {
	public static void main(String[] args) {
		// Ŭ������ �޸𸮿� ���� => ������ 
		/*
		 * 	c:bno="1"
			c:name="ȫ�浿"
			c:subject="�Խñ��Դϴ� 1"
			
			p:bno="2"
			p:name="�ڹ���"
			p:subject="�Խñ��Դϴ� 2"
		 */
		Reply r=new Reply(1, "hong", "ȫ�浿");
		r.print();
		///////////////////
		r.setRno(2);
		r.setId("shim");
		r.setName("��û��");
		///////////////////
		r.print(); // �ٲ� �����ͷ� ��� 
	}
}
