package com.company.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.company.biz.board.BoardDto;
import com.company.biz.board.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@PostMapping("/insertBoard.do")
	public ModelAndView insertBoard(BoardDto dto, ModelAndView mav) {
		System.out.println("글 등록 처리");
		boardService.insertBoard(dto);
		mav.setViewName("redirect:getBoardList.do?page=1");
		return mav;
	}
	
	@GetMapping("/insertBoard.do")
	public ModelAndView insertBoardView(ModelAndView mav) {
		System.out.println("글 등록 페이지 이동");
		mav.setViewName("insertBoard");
		return mav;
	}
	

	@PostMapping("/updateBoard.do")
	public ModelAndView updateBoard(BoardDto dto, ModelAndView mav) {
		System.out.println("글 수정 처리");
		boardService.updateBoard(dto);
		mav.setViewName("redirect:getBoardList.do?page=1");
		return mav;
	}

	@PostMapping("/deleteBoard.do")
	public ModelAndView deleteBoard(BoardDto dto, ModelAndView mav) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(dto);
		mav.setViewName("redirect:getBoardList.do?page=1");
		return mav;
	}

	@GetMapping("/getBoard.do")
	public ModelAndView getBoard(BoardDto dto, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		
		mav.addObject("board", boardService.getBoard(dto));
		mav.setViewName("getBoard");
		return mav;
	}

	@GetMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardDto dto, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");

		// Null값이 들어올 때 기본값으로 대체.. Null Check
		if (dto.getSearchCondition() == null)
			dto.setSearchCondition("TITLE");
		if (dto.getSearchKeyword() == null)
			dto.setSearchKeyword("");
		if (dto.getPage()==0)
			dto.setPage(1);

		mav.addObject("totalCount", boardService.getTotalCount(dto));
		mav.addObject("boardList", boardService.getBoardList(dto));// Model 정보 저장
		mav.setViewName("getBoardList");
		boardService.getBoardList(dto);
		return mav;
	}

	public void updateBoardCnt(BoardDto dto) {
		boardService.updateBoard(dto);
	}

	public int getTotalCount(BoardDto dto) {
		return boardService.getTotalCount(dto);
	}
}
