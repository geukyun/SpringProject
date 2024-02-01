package com.ssamz.biz.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssamz.biz.user.UserService;
import com.ssamz.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		
		// 1. ������ �����̳ʸ� �����Ѵ�
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		// 2. �׽�Ʈ�� ��ü�� Lookup �Ѵ�
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. Lookup�� ��ü�� �׽�Ʈ �Ѵ�.
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		UserVO user = userService.getUser(vo);
		if(user!=null) {
			System.out.println("---> user : " + user.toString()); 
		}
		// 4. container�� close �Ѵ�
		container.close();

	}

}
