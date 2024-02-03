package com.ssamz.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. �׽�Ʈ�� ��ü�� Lookup�Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");
		if(boardService!=null) {
			System.out.println(boardService+"��ü �˻� ����!!!");
		}
		// 3. Lookup�� ��ü�� �׽�Ʈ�Ѵ�.
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("�ӽ� ����");
		vo.setWriter("�׽���");
		vo.setContent("�ӽ� ����...........");
//		boardService.insertBoard(vo);
		
//		vo.setTitle("--- ���� ����");
//		vo.setContent("-- ���� ���� .......");
//		vo.setSeq(1);
//		boardService.updateBoard(vo);
//		boardService.deleteBoard(vo);
		
		List<BoardVO> boardLIst = boardService.getBoardList(vo);
		for(BoardVO boardVo : boardLIst) {
			System.out.println("---> " + boardVo.toString());
		}
		
		// 4. ������ �����̳ʸ� �����Ѵ�.
		container.close();
	}

}
