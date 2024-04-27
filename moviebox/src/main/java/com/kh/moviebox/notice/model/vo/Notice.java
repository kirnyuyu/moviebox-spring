package com.kh.moviebox.notice.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter;
	private String createDate;
	private int count;
	private String status;
	
	private String noticeCategory;
	
	private int categoryNo;
	
	private int userNo;

}
