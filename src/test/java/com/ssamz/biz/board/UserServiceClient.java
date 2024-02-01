package com.ssamz.biz.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssamz.biz.user.UserService;
import com.ssamz.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너를 구현한다
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		// 2. 테스트할 객체를 Lookup 한다
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. Lookup한 객체를 테스트 한다.
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		UserVO user = userService.getUser(vo);
		if(user!=null) {
			System.out.println("---> user : " + user.toString()); 
		}
		// 4. container를 close 한다
		container.close();

	}

}
