package com.company.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardMapper{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardDto> getBoardList(BoardDto dto) {
		return boardDao.getBoardList(dto);
	}

	@Override
	public BoardDto getBoard(BoardDto dto) {
		return boardDao.getBoard(dto);
	}

	@Override
	public void insertBoard(BoardDto dto) {
		boardDao.insertBoard(dto);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		boardDao.updateBoard(dto);
	}

	@Override
	public void deleteBoard(BoardDto dto) {
		boardDao.deleteBoard(dto);
	}

	@Override
	public void updateBoardCnt(BoardDto dto) {
		boardDao.updateBoard(dto);
	}

	@Override
	public int getTotalCount(BoardDto dto) {
		return boardDao.getTotalCount(dto);
	}
	

}
