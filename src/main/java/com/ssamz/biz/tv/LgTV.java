package com.ssamz.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// <bean class="com.ssamz.biz.tv.LgTV"/>

@Component("tv")
public class LgTV implements TV {
	
	@Autowired	// Type Injection
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV ����");
	}
	
	public LgTV(Speaker speaker) {	// Construction Injection
		super();
		this.speaker = speaker;
	}

	public void setSpeaker(Speaker speaker) {	// Setter Injection
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void volumnUp() {
		speaker.volumnUp();
	}
	public void volumnDown() {
		speaker.volumnDown();
	}
}
