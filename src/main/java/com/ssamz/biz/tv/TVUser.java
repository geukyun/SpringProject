package com.ssamz.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	// 다형성 = 상속 + Overriding + 형변환
	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너를 생성(구동)한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너로부터 테스트할 객체를 검색(Lookup)한다.
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumnDown();
		tv.volumnUp();
		tv.powerOff();
		
		// 3. 스프링 컨테이너를 종료한다. (컨테이너는 종료 직전에 자신이 생성한 객체들을 제거한다.)
		container.close();
		
	}

}
