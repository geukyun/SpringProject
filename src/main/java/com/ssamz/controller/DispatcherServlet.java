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
		System.out.println("=====> DispatcherServlet ����");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. ����� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("PATH : " + path);

		request.setCharacterEncoding("EUC-KR");

		// 2. ����� path�� ���� Controller�� �˻��Ѵ�
		HandlerMapping mapper = new HandlerMapping();
		Controller ctrl = mapper.getContrller(path);

		// 3. �˻��� Controller�� �����Ѵ�.
		String viewPage = ctrl.handleRequest(request, response);

		// 4. Controller�� ������ ȭ������ �̵��Ѵ�.
		response.sendRedirect(viewPage);

	}

}
