package com.ssamz.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.Controller;

import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		return "getBoard.jsp";
	}

}
