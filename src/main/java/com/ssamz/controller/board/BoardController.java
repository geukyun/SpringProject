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
		System.out.println("�۵�� ó��_1");
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		System.out.println("�۵�� ó��_2");
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		System.out.println("�۵�� ó��");
		System.out.println("������ �Խñ� ���� vo : " + vo.toString());
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�۵�� ó��");
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�۸�� ó��");
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("�۸�� ����Ʈ ó��");
		System.out.println("�˻� ���� : " + vo);
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		// ModelAndView ��ü�� �˻� ����� View �̸��� �����Ѵ�.
		// ModelAndView�� ����� �˻� ����� �ڵ����� request�� ��ϵȴ�.
		// Model�� ����� �˻� ����� �ڵ����� request�� ��ϵȴ�.
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}
	
	
}
