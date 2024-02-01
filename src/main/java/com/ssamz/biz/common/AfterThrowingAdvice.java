package com.ssamz.biz.common;

import java.sql.SQLException;

public class AfterThrowingAdvice {
	
	public void exceptionLog(Exception exceptionObj) {
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ���� �߻�");
		
		// �߻��� ������ Ÿ�Կ� ���� �б�ó��
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("0�� ���� ����� ���� �����ϴ�."); 
		}else if(exceptionObj instanceof ArithmeticException) {
			System.out.println("0���� ���ڸ� ���� ���� �����ϴ�.");
		}else if(exceptionObj instanceof SQLException) {
			System.out.println("SQL ������ ������ �ֽ��ϴ�.");
		}else{
			System.out.println("���� �̻��� ���� �߻�");
		}
	}
	
}
