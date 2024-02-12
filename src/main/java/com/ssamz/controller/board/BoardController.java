package com.ssamz.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssamz.biz.board.BoardService;
import com.ssamz.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		System.out.println("글등록 처리_1");
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		System.out.println("글등록 처리_2");
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		System.out.println("글등록 처리");
		System.out.println("수정할 게시글 정보 vo : " + vo.toString());
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글등록 처리");
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글목록 처리");
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글목록 리스트 처리");
		System.out.println("검색 조건 : " + vo);
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		// ModelAndView 객체에 검색 결과와 View 이름을 저장한다.
		// ModelAndView에 저장된 검색 결과는 자동으로 request에 등록된다.
		// Model에 저장된 검색 결과는 자동으로 request에 등록된다.
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}
	
	
}
