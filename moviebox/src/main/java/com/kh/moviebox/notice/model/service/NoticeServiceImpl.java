package com.kh.moviebox.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.board.model.vo.Category;
import com.kh.moviebox.common.model.vo.PageInfo;
import com.kh.moviebox.notice.model.dao.NoticeRepository;
import com.kh.moviebox.notice.model.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public int selectListCount() {
		return noticeRepository.selectListCount(sqlSession);
	}

	@Override
	public List<Board> selectList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return noticeRepository.selectList(sqlSession, rowBounds);
	}

	@Override
	public int increaseCount(int noticeNo) {
		return noticeRepository.increaseCount(sqlSession, noticeNo);
	}

	@Override
	public Notice selectNotice(int noticeNo) {
		return noticeRepository.selectNotice(sqlSession, noticeNo);
	}

	@Override
	public int insert(Notice notice) {
		return noticeRepository.insert(sqlSession, notice);
	}
	
	@Override
	public List<Category> selectCategoryList(Category category) {
		return noticeRepository.selectCategoryList(sqlSession, category);
	}

	@Override
	public int deleteNotice(int noticeNo) {
		return noticeRepository.deleteNotice(sqlSession, noticeNo);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeRepository.updateNotice(sqlSession, notice);
	}
	

}
