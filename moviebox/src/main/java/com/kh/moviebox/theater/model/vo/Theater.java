package com.kh.moviebox.theater.model.vo;

import java.util.List;

import com.kh.moviebox.movie.model.vo.Movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Theater {
	private int theaterNo;
	private String theaterName;
	private String theaterAddr;
	private String mapLink;
	private String localCode;
	private String updateDate;
	private String locationName;
	
	private int screenNo;
	private int movieNo;
	private String movieTitle;
	private String movieRt;
	private String filePath;
	private String changeName;
	
	private List<Movie> movies;
	private List<Screen> screenList;

}
