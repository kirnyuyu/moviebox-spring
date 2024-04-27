package com.kh.moviebox.notice.model.service;

import java.util.List;

import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.board.model.vo.Category;
import com.kh.moviebox.common.model.vo.PageInfo;
import com.kh.moviebox.notice.model.vo.Notice;

public interface NoticeService {
	
	// 전체 글 개수
	int selectListCount();
	
	// 전체 목록
	List<Board> selectList(PageInfo pi);

	// 디테일
	int increaseCount(int noticeNo);
	Notice selectNotice(int noticeNo);

	// 글쓰기
	int insert(Notice notice);
	
	List<Category> selectCategoryList(Category category);

	int deleteNotice(int noticeNo);





}
