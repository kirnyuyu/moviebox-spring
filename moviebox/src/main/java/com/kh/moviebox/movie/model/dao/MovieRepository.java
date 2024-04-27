package com.kh.moviebox.movie.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.moviebox.common.model.vo.Attachment;
import com.kh.moviebox.movie.model.vo.Cast;
import com.kh.moviebox.movie.model.vo.Movie;

@Repository
public class MovieRepository {

	public List<Movie> selectList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("movieMapper.selectList");
	}

	public List<Movie> genreMovie(SqlSessionTemplate sqlSession, String genre) {
		return sqlSession.selectList("movieMapper.genreMovie", genre);
	}

//////////////////////////////////

	public List<Movie> detailMovie(SqlSessionTemplate sqlSession, int movieNo) {
		return sqlSession.selectList("movieMapper.detailMovie", movieNo);
		
	}

	public List<Attachment> stilCut(SqlSessionTemplate sqlSession, int movieNo) {
		return sqlSession.selectList("movieMapper.stilCut", movieNo);
	}

	public String movieCast(SqlSessionTemplate sqlSession, int movieNo) {
		return sqlSession.selectOne("movieMapper.movieCast", movieNo);
	}





}
