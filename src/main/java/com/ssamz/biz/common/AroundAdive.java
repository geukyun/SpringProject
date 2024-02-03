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
		System.out.println("---[ " + method + "() ����Ͻ� �޼ҵ� ���� ���� ]---" + args[0].toString());
		
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		// ���������� Ŭ���̾�ũ�� ȣ���� ����Ͻ� �޼ҵ� ����
		obj = jp.proceed();
		
		watch.stop();
		System.out.println(method + "() ����Ͻ� �޼ҵ� ���࿡ �ҿ�� �ð� : " + watch.getTotalTimeSeconds());
		System.out.println("---[ " + method + "() ����Ͻ� �޼ҵ� ���� ���� ]---");
		return obj;
	}
	
}
