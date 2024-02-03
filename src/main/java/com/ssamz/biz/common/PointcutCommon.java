package com.ssamz.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	// body가 비어있는 메서드 : 참조용 메서드
	// 여러개의 Pointcut을 설정했을 때 어떤 Pointcut을 실행할 지 모르기 때문에 참조용 메서드를 만들고 거기에 Pointcut을 설정한다
	@Pointcut("execution(* com.ssamz.biz.board..*Impl.*(..))")
	public void boardPointCut() {}

	@Pointcut("execution(* com.ssamz.biz.user..*Impl.*(..))")
	public void userPointCut() {}
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.get*(..))")
	public void getPointCut() {}
}
