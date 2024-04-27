package com.kh.moviebox.board.model.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String createDate;
	private int count;
	private String status;
	private String boardWriter;
	private String boardCategory;
	
	private int categoryNo;
	private int userNo;
}
