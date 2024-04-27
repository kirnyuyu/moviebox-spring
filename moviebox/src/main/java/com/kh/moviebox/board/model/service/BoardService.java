package com.kh.moviebox.board.model.service;

import java.util.List;

import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.common.model.vo.PageInfo;

public interface BoardService {

	int selectListCount();

	List<Board> selectList(PageInfo pi);

}
