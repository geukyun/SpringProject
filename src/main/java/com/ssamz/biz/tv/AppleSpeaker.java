package com.ssamz.biz.tv;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 积己");
	}
	public void volumnUp() {
		System.out.println("AppleSpeaker---家府 棵赴促.");
	}
	public void volumnDown() {
		System.out.println("AppleSpeaker---家府 郴赴促.");
	}
	
}
