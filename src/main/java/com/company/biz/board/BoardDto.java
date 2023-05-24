package com.company.biz.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	private int page;
}
