package com.ssamz.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.ssamz.biz.user.UserVO;

@Service
@Aspect
public class AfterReturingLogAdvice {
	
	@AfterReturning(pointcut = "PointcutCommon.getPointCut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] " + method + "() �޼ҵ� ���ϰ� :" + returnObj.toString());
		
		// ����Ͻ� �޼ҵ尡 ������ �����Ͱ� UserVO Ÿ���� ���������� Ȯ���Ѵ�.
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			// ���ϵ� UserVO ��ü�� role ���� ���� ADMIN���� Ȯ���Ѵ�.
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "�����ڴ� ȯ���մϴ�.");
			}
		}
	}
	
}
