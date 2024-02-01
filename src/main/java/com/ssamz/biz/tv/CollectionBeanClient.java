package com.ssamz.biz.tv;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너를 구동한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 사용할 개체를 Lookup한다.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		
		// 3. Lookup한 객체를 사용한다.
		Properties data = bean.getAddressList();
		System.out.println("[주소 목록]");
		Collection<Object> addressList = data.values();
		
		for(Object address : addressList) {
			System.out.println("---> " + address.toString());
		}
		
		// 4. 스프링 컨테이너를 종료한다.
		container.close();

	}

}
