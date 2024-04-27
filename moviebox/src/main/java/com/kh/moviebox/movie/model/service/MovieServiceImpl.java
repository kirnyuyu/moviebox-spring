package com.kh.moviebox.movie.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moviebox.common.model.vo.Attachment;
import com.kh.moviebox.movie.model.dao.MovieRepository;
import com.kh.moviebox.movie.model.vo.Cast;
import com.kh.moviebox.movie.model.vo.Movie;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> selectList() {
		return movieRepository.selectList(sqlSession);
	}

	@Override
	public List<Movie> genreMovie(String genre) {
		return movieRepository.genreMovie(sqlSession, genre);
	}

	//////////////////////////////////////////////////
	
	@Override
	public List<Movie> detailMovie(int movieNo) {
		return movieRepository.detailMovie(sqlSession, movieNo);
	}

	@Override
	public List<Attachment> stilCut(int movieNo) {
		return movieRepository.stilCut(sqlSession, movieNo);
	}

	@Override
	public String movieCast(int movieNo) {
		return movieRepository.movieCast(sqlSession, movieNo);
	}
	



}
