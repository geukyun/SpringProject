package com.ssamz.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	// ������ = ��� + Overriding + ����ȯ
	public static void main(String[] args) {
		
		// 1. ������ �����̳ʸ� ����(����)�Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ������ �����̳ʷκ��� �׽�Ʈ�� ��ü�� �˻�(Lookup)�Ѵ�.
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumnDown();
		tv.volumnUp();
		tv.powerOff();
		
		// 3. ������ �����̳ʸ� �����Ѵ�. (�����̳ʴ� ���� ������ �ڽ��� ������ ��ü���� �����Ѵ�.)
		container.close();
		
	}

}
