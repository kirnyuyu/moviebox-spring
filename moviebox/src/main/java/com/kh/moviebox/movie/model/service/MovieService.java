package com.kh.moviebox.movie.model.service;

import java.util.List;

import com.kh.moviebox.common.model.vo.Attachment;
import com.kh.moviebox.movie.model.vo.Cast;
import com.kh.moviebox.movie.model.vo.Movie;

public interface MovieService {

	List<Movie> selectList();

	List<Movie> genreMovie(String genre);

	List<Movie> detailMovie(int movieNo);

	List<Attachment> stilCut(int movieNo);

	String movieCast(int movieNo);

	

}
