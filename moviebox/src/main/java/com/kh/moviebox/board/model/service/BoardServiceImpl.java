package com.kh.moviebox.board.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moviebox.board.model.dao.BoardRepository;
import com.kh.moviebox.board.model.vo.Board;
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
	

}
