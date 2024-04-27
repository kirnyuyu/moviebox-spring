package com.kh.moviebox.board.model.service;

import java.util.List;

import com.kh.moviebox.board.model.vo.Answer;
import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.board.model.vo.Category;
import com.kh.moviebox.common.model.vo.PageInfo;

public interface BoardService {

	int selectListCount();
	List<Board> selectList(PageInfo pi);
	
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	
	List<Answer> selectAnswer(int boardNo);
	int insertAnswer(Answer answer);
	
	List<Category> selectCategoryList(Category category);
	int insert(Board board);
	
	int updateBoard(Board board);
	
	int deleteBoard(int boardNo);

}
