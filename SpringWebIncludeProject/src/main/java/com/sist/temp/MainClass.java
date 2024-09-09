package com.sist.temp;

public class MainClass {
	public static void main(String[] args) {
		InputVO ivo=new InputVO();
		ivo.setNo(2);
		ivo.setGno(20);
		ivo.setPrice(20000);
		
		StoreVO svo=new StoreVO();
		svo.setNo(1);
		svo.setGno(10);
		svo.setPrice(10000);
		
		GoodsDAO dao=new GoodsDAO();
		dao.insert(svo, ivo);
		System.out.println("정상 수행!!");
	}
}
