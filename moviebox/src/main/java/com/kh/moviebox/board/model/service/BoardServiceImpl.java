package com.kh.moviebox.board.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moviebox.board.model.dao.BoardRepository;
import com.kh.moviebox.board.model.vo.Answer;
import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.board.model.vo.Category;
import com.kh.moviebox.common.model.vo.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public int selectListCount() {
		return boardRepository.selectListCount(sqlSession);
	}

	@Override
	public List<Board> selectList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return boardRepository.selectList(sqlSession, rowBounds);
	}

	@Override
	public int increaseCount(int boardNo) {
		return boardRepository.increaseCount(sqlSession, boardNo);
	}

	@Override
	public Board selectBoard(int boardNo) {
		return boardRepository.selectBoard(sqlSession, boardNo);
	}

	@Override
	public List<Answer> selectAnswer(int boardNo) {
		return boardRepository.selectAnswer(sqlSession, boardNo);
	}

	@Override
	public int insertAnswer(Answer answer) {
		return boardRepository.insertAnswer(sqlSession, answer);
	}

	@Override
	public List<Category> selectCategoryList(Category category) {
		return boardRepository.selectCategoryList(sqlSession, category);
	}

	@Override
	public int insert(Board board) {
		return boardRepository.insert(sqlSession, board);
	}

	@Override
	public int updateBoard(Board board) {
		return boardRepository.updateBoard(sqlSession, board);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return boardRepository.deleteBoard(sqlSession, boardNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
