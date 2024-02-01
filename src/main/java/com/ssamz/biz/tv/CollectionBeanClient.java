package com.ssamz.biz.tv;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		// 1. ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ����� ��ü�� Lookup�Ѵ�.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		
		// 3. Lookup�� ��ü�� ����Ѵ�.
		Properties data = bean.getAddressList();
		System.out.println("[�ּ� ���]");
		Collection<Object> addressList = data.values();
		
		for(Object address : addressList) {
			System.out.println("---> " + address.toString());
		}
		
		// 4. ������ �����̳ʸ� �����Ѵ�.
		container.close();

	}

}
