package com.kh.moviebox.movie.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moviebox.movie.model.dao.MovieRepository;
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

}
