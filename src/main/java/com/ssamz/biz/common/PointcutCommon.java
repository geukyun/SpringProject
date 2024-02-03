package com.ssamz.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	// body�� ����ִ� �޼��� : ������ �޼���
	// �������� Pointcut�� �������� �� � Pointcut�� ������ �� �𸣱� ������ ������ �޼��带 ����� �ű⿡ Pointcut�� �����Ѵ�
	@Pointcut("execution(* com.ssamz.biz.board..*Impl.*(..))")
	public void boardPointCut() {}

	@Pointcut("execution(* com.ssamz.biz.user..*Impl.*(..))")
	public void userPointCut() {}
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.get*(..))")
	public void getPointCut() {}
}
