package com.ssamz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.board.impl.BoardDAO;
import com.ssamz.biz.user.UserVO;
import com.ssamz.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		System.out.println("=====> DispatcherServlet 생성");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 사용자 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("PATH : " + path);

		request.setCharacterEncoding("EUC-KR");

		// 2. 추출된 path에 따른 Controller를 검색한다
		HandlerMapping mapper = new HandlerMapping();
		Controller ctrl = mapper.getContrller(path);

		// 3. 검색한 Controller를 실행한다.
		String viewPage = ctrl.handleRequest(request, response);

		// 4. Controller가 리턴한 화면으로 이동한다.
		response.sendRedirect(viewPage);

	}

}
