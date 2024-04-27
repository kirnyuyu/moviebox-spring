package com.kh.moviebox.common.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Attachment {
	
	private int fileNo;
	private int movieNo;
	private String orginName;
	private String changeName;
	private String filePath;
	private int fileLevel;
	private String uploadDate;
	private String stilCut;
}
