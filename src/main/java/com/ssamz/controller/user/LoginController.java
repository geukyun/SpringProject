package com.ssamz.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.user.UserVO;
import com.ssamz.biz.user.impl.UserDAO;

@Controller
public class LoginController{

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ���� ó��");
				
		if (userDAO.getUser(vo) != null) {
			System.out.println("cccccc");
			// �α��� ������ ���
			return "forward:getBoardList.do";
		} else {
			System.out.println("ddddd");
			// �α��� ������ ���
			return "redirect:login.jsp";
		}
		
	}

}
