package com.ssamz.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect // Aspect = Pointcut + Advice
public class AroundAdive {
	
	@Around("PointcutCommon.allPointCut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("---[ " + method + "() 비즈니스 메소드 수행 시작 ]---" + args[0].toString());
		
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		// 실질적으로 클라이언크가 호출한 비즈니스 메소드 실행
		obj = jp.proceed();
		
		watch.stop();
		System.out.println(method + "() 비즈니스 메소드 수행에 소요된 시간 : " + watch.getTotalTimeSeconds());
		System.out.println("---[ " + method + "() 비즈니스 메소드 수행 종료 ]---");
		return obj;
	}
	
}
