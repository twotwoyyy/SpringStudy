package com.sist.spring3;
// ���� ��� => ��� Ŭ������ ������ ��� ����
public interface Model {
	public String execute();
	default public void write() {
		// ������ �޼ҵ� => �߻� Ŭ���� ����� ���� ������� jdk1.8���� ����
		// �������̽� : �ڹٽ�ũ��Ʈ (���α׷� ��� ����)
	}
}
