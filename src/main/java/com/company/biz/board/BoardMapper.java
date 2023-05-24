package com.company.biz.board;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {

	@Select("SELECT * FROM (SELECT ROWNUM AS RNUM,B.* FROM (SELECT SEQ,TITLE,WRITER,CONTENT,TO_CHAR(REGDATE,'YYYY-MM-DD HH:MI:SS') AS REGDATE,CNT FROM SPRINGBOARD WHERE ${searchCondition} LIKE '%'||#{searchKeyword}||'%' ORDER BY SEQ DESC) B) WHERE RNUM BETWEEN #{page}*10-9 AND #{page}*10")
	List<BoardDto> getBoardList(BoardDto dto);
	
	@Select("SELECT * FROM SPRINGBOARD WHERE SEQ=#{seq}")
	BoardDto getBoard(BoardDto dto);

	@Insert("INSERT INTO SPRINGBOARD(SEQ,TITLE,WRITER,CONTENT) VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM SPRINGBOARD),#{title},#{writer},#{content})")
	void insertBoard(BoardDto dto);
	
	@Update("UPDATE SPRINGBOARD SET TITLE=#{title}, CONTENT=#{content} WHERE SEQ=#{seq}")
	void updateBoard(BoardDto dto);
	
	@Delete("DELETE SPRINGBOARD WHERE SEQ=#{seq}")
	void deleteBoard(BoardDto dto);
	
	@Update("UPDATE SPRINGBOARD SET CNT=CNT+1 WHERE SEQ=#{seq}")
	void updateBoardCnt(BoardDto dto);	
	
	@Select("SELECT COUNT(*) FROM SPRINGBOARD WHERE ${searchCondition} LIKE '%'||#{searchKeyword}||'%'")
	int getTotalCount(BoardDto dto);

}