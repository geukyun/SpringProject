package com.ssamz.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssamz.biz.user.UserVO;
import com.ssamz.biz.user.impl.UserDAO;

@Controller
public class LoginController{

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		vo.setId("test");
		vo.setPassword("test123");
		System.out.println("---> 로그인 화면으로 이동");
		return "login";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("---> 로그인 인증 처리");
		if (userDAO.getUser(vo) != null) {
			// 로그인 성공한 경우
			return "forward:getBoardList.do";
		} else {
			// 로그인 실패한 경우
			return "login";
		}
		
	}

}
