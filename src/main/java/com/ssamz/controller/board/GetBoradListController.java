package com.ssamz.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.board.impl.BoardDAO;

public class GetBoradListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글목록 리스트 처리");

		// 1. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 2. Model(DAO)을 이용해서 검색한 데이터를 View(JSP) 화면에서 사용할 수 있도록 세션에 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);

		// 3. 화면 네비게이션(이동할 화면 정보를 ModelAndView에 등록하여 리턴한다.)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}
