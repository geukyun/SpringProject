package com.ssamz.biz.tv;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) ����");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) ����");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) ����");
		this.speaker = speaker;
		this.price = price;
	}

	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�." + price);
	}
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}
	public void volumnUp() {
		speaker.volumnUp();
	}
	public void volumnDown() {
		speaker.volumnDown();
	}
}
