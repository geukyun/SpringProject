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

		// 2. 추출된 path에 따라
		if (path.equals("/login.do")) {
			System.out.println("로그인 인증 처리");

			// 1. 사용자 입력정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. 화면 네비게이션
			if (user != null) {
				// 로그인 성공한 경우
				response.sendRedirect("getBoardList.do");
			} else {
				// 로그인 실패한 경우
				response.sendRedirect("login.jsp");
			}

		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			// 로그아웃을 요청한 브라우저와 매핑된 세션 객체를 획득한다.
			HttpSession session = request.getSession();
			
			// 획득한 세션을 강제종료하고 메인 페이지로 이동한다.
			session.invalidate();

			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글등록 처리");

			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글수정 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글삭제 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글상세 조회 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			// 2. Model(DAO)을 이용해서 검색한 데이터를 View(JSP) 화면에서 사용할 수 있도록 세션에 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);

			// 3. 화면 네비게이션
			response.sendRedirect("getBoard.jsp");
			
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("글목록 리스트 처리");

			// 1. DB 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);

			// 2. Model(DAO)을 이용해서 검색한 데이터를 View(JSP) 화면에서 사용할 수 있도록 세션에 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);

			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.jsp");

		} else {
			System.out.println("URL 요청을 다시 확인해주세요.");
		}

	}

}
