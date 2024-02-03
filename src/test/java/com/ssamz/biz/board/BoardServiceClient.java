package com.ssamz.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 구동한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. 테스트할 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		if(boardService!=null) {
			System.out.println(boardService+"객체 검색 성공!!!");
		}
		// 3. Lookup할 객체를 테스트한다.
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("테스터");
		vo.setContent("임시 내용...........");
//		boardService.insertBoard(vo);
		
//		vo.setTitle("--- 수정 제목");
//		vo.setContent("-- 수정 내용 .......");
//		vo.setSeq(1);
//		boardService.updateBoard(vo);
//		boardService.deleteBoard(vo);
		
		List<BoardVO> boardLIst = boardService.getBoardList(vo);
		for(BoardVO boardVo : boardLIst) {
			System.out.println("---> " + boardVo.toString());
		}
		
		// 4. 스프링 컨테이너를 종료한다.
		container.close();
	}

}
