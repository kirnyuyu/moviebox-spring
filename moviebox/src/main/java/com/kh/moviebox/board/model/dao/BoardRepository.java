package com.kh.moviebox.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.moviebox.board.model.vo.Answer;
import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.board.model.vo.Category;
import com.kh.moviebox.common.model.vo.PageInfo;

@Repository
public class BoardRepository {

	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	public List<Board> selectList(SqlSessionTemplate sqlSession, RowBounds rowBounds) {
		return sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}

	public int increaseCount(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}

	public Board selectBoard(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}

	public List<Answer> selectAnswer(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectList("boardMapper.selectAnswer", boardNo);
	}

	public int insertAnswer(SqlSessionTemplate sqlSession, Answer answer) {
		return sqlSession.insert("boardMapper.insertAnswer", answer);
	}

	public List<Category> selectCategoryList(SqlSessionTemplate sqlSession, Category category) {
		return sqlSession.selectList("boardMapper.selectCategoryList", category);
	}

	public int insert(SqlSessionTemplate sqlSession, Board board) {
		return sqlSession.insert("boardMapper.insert", board);
	}

	public int updateBoard(SqlSessionTemplate sqlSession, Board board) {
		return sqlSession.update("boardMapper.updateBoard", board);
	}

	public int deleteBoard(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.deleteBoard", boardNo);
	}


}
