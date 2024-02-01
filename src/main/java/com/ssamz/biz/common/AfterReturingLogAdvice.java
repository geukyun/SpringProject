package com.ssamz.biz.common;

import com.ssamz.biz.user.UserVO;

public class AfterReturingLogAdvice {
	
	public void afterLog(Object returnObj) {
		System.out.println("[���� ó��] ����Ͻ� �޼ҵ� ���ϰ� :" + returnObj.toString());
		
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
