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

		// 2. ����� path�� ����
		if (path.equals("/login.do")) {
			System.out.println("�α��� ���� ó��");

			// 1. ����� �Է����� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB ���� ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. ȭ�� �׺���̼�
			if (user != null) {
				// �α��� ������ ���
				response.sendRedirect("getBoardList.do");
			} else {
				// �α��� ������ ���
				response.sendRedirect("login.jsp");
			}

		} else if (path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			// �α׾ƿ��� ��û�� �������� ���ε� ���� ��ü�� ȹ���Ѵ�.
			HttpSession session = request.getSession();
			
			// ȹ���� ������ ���������ϰ� ���� �������� �̵��Ѵ�.
			session.invalidate();

			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("�۵�� ó��");

			// 1. ����� �Է����� ����
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");

			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/updateBoard.do")) {
			System.out.println("�ۼ��� ó��");
			
			// 1. ����� �Է����� ����
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("�ۻ��� ó��");
			
			// 1. ����� �Է����� ����
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("�ۻ� ��ȸ ó��");
			
			// 1. ����� �Է����� ����
			String seq = request.getParameter("seq");

			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			// 2. Model(DAO)�� �̿��ؼ� �˻��� �����͸� View(JSP) ȭ�鿡�� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);

			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoard.jsp");
			
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("�۸�� ����Ʈ ó��");

			// 1. DB ���� ó��
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);

			// 2. Model(DAO)�� �̿��ؼ� �˻��� �����͸� View(JSP) ȭ�鿡�� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);

			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.jsp");

		} else {
			System.out.println("URL ��û�� �ٽ� Ȯ�����ּ���.");
		}

	}

}
