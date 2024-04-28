package com.kh.moviebox.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Answer {
	private int answerNo;
	private String answerContent;
	private String createDate;
	private String status;
	private int boardNo;
	private int answerWriter;
}
