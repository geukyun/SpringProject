package com.ssamz.biz.tv;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker ����");
	}
	public void volumnUp() {
		System.out.println("AppleSpeaker---�Ҹ� �ø���.");
	}
	public void volumnDown() {
		System.out.println("AppleSpeaker---�Ҹ� ������.");
	}
	
}
