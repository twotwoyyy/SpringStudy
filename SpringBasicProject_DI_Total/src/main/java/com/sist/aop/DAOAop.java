package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class DAOAop {
	public void before() {
		System.out.println("오라클 연결..");
	}
	public void after() {
		System.out.println("오라클 해제..");
	}
	
	// around 
	// 핵심 코딩
	// => 핵심 처리 / 공통 처리 
/*
 * 		getConnection(); ---
		System.out.println("UPDATE 문장 처리.."); -- 핵심
		disConnection(); --- 공통
		
		MyBatis 
		=> 라이브러리 => 공통 사용 부분 제거
		
		 around 
		 
		 ====== 공통 
		  00000 => 핵심 
		 ====== 공통 
		 
		 => 트랜잭션 처리 setAutoCommit(false)
		              처리
		              commit() 
		 => LOG 파일 
		 
		 처리 
		 ===============================
		 public void execution(){
		 	*before로 등록된 메소드 호출 영역 ==> 모든 메소드, 여러 개 메소드에 공통으로 적용이 되는 부분이 있는 경우 ex) footer 자동 호출 .. 
		 	try{
		 		*around 영역
		 		====> 핵심 코딩 들어가는 부분
				*around 영역
		 	}catch(Exception e){
		 		*after-throwing 영역 
		 	}finally{
		 		*after 영역
		 	}
		 	return; *after-returning 영역
		 }
 */
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출된 메소드:"+jp.getSignature().getName());
		obj=jp.proceed(); // 사용자가 요청한 메소드를 호출 
		long end=System.currentTimeMillis();
		System.out.println("소요시간:"+(end-start));
		return obj;
	}
	
	public void afterReturning(Object obj) {
		System.out.println("====== 결과값 자동 처리 =====");
		System.out.println("결과값: "+obj);
	}
	
	public void afterThowable(Throwable ex) {
		System.out.println("======== 예외 발생 ========");
		System.out.println(ex.getMessage());
	}
}
