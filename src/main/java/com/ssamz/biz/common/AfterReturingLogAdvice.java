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
		
		System.out.println("[사후 처리] " + method + "() 메소드 리턴값 :" + returnObj.toString());
		
		// 비즈니스 메소드가 리턴한 데이터가 UserVO 타입의 데이터인지 확인한다.
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			// 리턴된 UserVO 객체의 role 변수 값이 ADMIN인지 확인한다.
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "관리자님 환영합니다.");
			}
		}
	}
	
}
