package com.company.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<BoardDto> getBoardList(BoardDto dto) {
		System.out.println("getBoardList 실행");
		return mybatis.selectList("getBoardList", dto);
	}
	
	public BoardDto getBoard(BoardDto dto) {
		System.out.println("getBoard 실행");
		return (BoardDto)mybatis.selectOne("getBoard", dto);
	}
	
	public void insertBoard(BoardDto dto) {
		System.out.println("insertBoard 실행");
		mybatis.insert("insertBoard", dto);
	}
	
	public void updateBoard(BoardDto dto) {
		System.out.println("updateBoard 실행");
		mybatis.update("updateBoard", dto);
	}
	
	public void deleteBoard(BoardDto dto) {
		System.out.println("deleteBoard 실행");
		mybatis.delete("deleteBoard", dto);
	}
	
	public int getTotalCount(BoardDto dto) {
		return mybatis.selectOne("getTotalCount",dto);
	}
}
