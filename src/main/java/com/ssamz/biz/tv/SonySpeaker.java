package com.ssamz.biz.tv;

//@Component
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 积己");
	}
	public void volumnUp() {
		System.out.println("SonySpeaker---家府 棵赴促.");
	}
	public void volumnDown() {
		System.out.println("SonySpeaker---家府 郴赴促.");
	}
	
}
