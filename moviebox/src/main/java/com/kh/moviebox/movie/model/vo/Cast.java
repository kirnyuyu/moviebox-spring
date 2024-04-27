package com.kh.moviebox.movie.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class Cast {
	
	private int movieNo;
	private int actorNo;
	private String actorName;
}
