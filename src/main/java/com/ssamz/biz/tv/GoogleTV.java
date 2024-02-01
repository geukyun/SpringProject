package com.ssamz.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class GoogleTV implements TV {
	
	@Autowired
	private Speaker speaker;
	
	public GoogleTV() {
		System.out.println("===> GoogleTV ����");
	}
	
//	public void setSpeaker(Speaker speaker) {
//		System.out.println("---> setSpeaker()");
//		this.speaker = speaker;
//	}
//
//	public void setPrice(int price) {
//		System.out.println("---> setPrice()");
//		this.price = price;
//	}

	public void powerOn() {
		System.out.println("GoogleTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("GoogleTV---���� ����.");
	}
	public void volumnUp() {
		speaker.volumnUp();
	}
	public void volumnDown() {
		speaker.volumnDown();
	}
}
