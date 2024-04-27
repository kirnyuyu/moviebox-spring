package com.kh.moviebox.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.moviebox.board.model.vo.Category;
import com.kh.moviebox.common.model.vo.PageInfo;
import com.kh.moviebox.common.template.Pagination;
import com.kh.moviebox.notice.model.service.NoticeService;
import com.kh.moviebox.notice.model.vo.Notice;


@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// 목록 출력
	@RequestMapping("list.notice")
	public String selectAl(@RequestParam(value="page", defaultValue="1") int page, Model model) {
		PageInfo pi = Pagination.getPageInfo(noticeService.selectListCount(), page, 5, 10);
		
		model.addAttribute("list", noticeService.selectList(pi));
		model.addAttribute("pageInfo", pi);
		return "notice/noticeList";
	}
	
	// 상세보기
	@RequestMapping("detail.notice")
	public ModelAndView findByNoticeNo(int noticeNo, ModelAndView mv) {
		if(noticeService.increaseCount(noticeNo) > 0) {
			mv.addObject("notice", noticeService.selectNotice(noticeNo)).setViewName("notice/noticeDetail");
		} else {
			mv.addObject("errorMsg", "게시글 상세 조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 글쓰기
	@RequestMapping("enrollForm.notice")
	public String enrollForm(Model model, Category category) {
		List<Category> list = noticeService.selectCategoryList(category);
		model.addAttribute("category", list);
		
		return "notice/noticeInsertForm";
	}
	
	@RequestMapping("insert.notice")
	public String insert(Notice notice, HttpSession session, Model model) {
		if(noticeService.insert(notice) > 0) {
			session.setAttribute("alertMsg", "공지사항 작성 완료");
			return "redirect:list.notice";
		} else {
			model.addAttribute("errorMsg", "공지사항 작성 실패");
			return "notice/noticeInsertForm";
		}
	}
	
	// 글 수정
	
	
	// 글 삭제
	@RequestMapping("delete.notice")
	public String deleteNotice(int noticeNo, HttpSession session) {
		if(noticeService.deleteNotice(noticeNo) > 0) {
			session.setAttribute("alertMsg", "공지사항 삭제 완료");
			return "redirect:list.notice";
		} else {
			session.setAttribute("alertMsg", "공지사항 삭제 실패");
			return "redirect:list.notice";
		}
		
	}

}
