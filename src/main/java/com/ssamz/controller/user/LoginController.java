package com.ssamz.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.user.UserVO;
import com.ssamz.biz.user.impl.UserDAO;

@Controller
public class LoginController{

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 인증 처리");
				
		if (userDAO.getUser(vo) != null) {
			System.out.println("cccccc");
			// 로그인 성공한 경우
			return "forward:getBoardList.do";
		} else {
			System.out.println("ddddd");
			// 로그인 실패한 경우
			return "redirect:login.jsp";
		}
		
	}

}
