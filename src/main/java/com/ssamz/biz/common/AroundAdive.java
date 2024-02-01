package com.ssamz.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.ssamz.biz.user.UserVO;

@Service("around")
public class AroundAdive {
	
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		
		String method = jp.getSignature().getName();
		UserVO user = (UserVO) jp.getArgs()[0];
		System.out.println("---[ " + method + "() ����Ͻ� �޼ҵ� ���� ���� ]---" + user.toString());
		
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
