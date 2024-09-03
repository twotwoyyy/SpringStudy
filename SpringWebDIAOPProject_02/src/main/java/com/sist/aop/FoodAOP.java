package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // 공통 모듈 => 메모리 할당은 할 수 없다 => 자동 호출 (Callback)
@Component
public class FoodAOP {
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object log(ProceedingJoinPoint jp) {
		Object obj=null;
		try {
			long start=System.currentTimeMillis();
			obj=jp.proceed(); // 사용자 요청 메서드 호출
			long end=System.currentTimeMillis();
			System.out.println("요청한 메서드: "+jp.getSignature().getName());
			System.out.println("소요시간: "+(end-start));
		}catch(Throwable ex) {}
		return obj;
	}
}
