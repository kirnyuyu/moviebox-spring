package com.kh.moviebox.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.moviebox.board.model.service.BoardService;
import com.kh.moviebox.board.model.vo.Answer;
import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.board.model.vo.Category;
import com.kh.moviebox.common.model.vo.PageInfo;
import com.kh.moviebox.common.template.Pagination;
import com.kh.moviebox.notice.model.vo.Notice;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 전체목록
	@RequestMapping("list.board")
	public String selectAl(@RequestParam(value="page", defaultValue="1") int page, Model model) {
		PageInfo pi = Pagination.getPageInfo(boardService.selectListCount(), page, 5, 10);
		
		model.addAttribute("list", boardService.selectList(pi));
		model.addAttribute("pageInfo", pi);
		return "board/boardList";
	}
	
	// 상세보기
	@RequestMapping("detail.board")
	public ModelAndView findByNoticeNo(int boardNo, ModelAndView mv) {
		if(boardService.increaseCount(boardNo) > 0) {
			mv.addObject("board", boardService.selectBoard(boardNo)).setViewName("board/boardDetail");
		} else {
			mv.addObject("errorMsg", "문의사항 상세 조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 글쓰기
	@RequestMapping("enrollForm.board")
	public String enrollForm(Model model, Category category) {
		List<Category> list = boardService.selectCategoryList(category);
		model.addAttribute("category", list);
		
		return "board/boardInsertForm";
	}
	
	@RequestMapping("insert.board")
	public String insert(Board board, HttpSession session, Model model) {
		if(boardService.insert(board) > 0) {
			session.setAttribute("alertMsg", "문의사항 작성 완료");
			return "redirect:list.board";
		} else {
			model.addAttribute("alertMsg", "문의사항 작성 실패");
			return "board/boardInsertForm";
		}
	}
	
	// 글 수정
	@RequestMapping("updateForm.board")
	public String updateForm(int boardNo, Model model, Category category, Board board) {
		List<Category> list = boardService.selectCategoryList(category);
		Board boardList = boardService.selectBoard(boardNo);
		
		model.addAttribute("category", list);
		model.addAttribute("board", boardList);
		
		return "board/boardUpdateForm";
	}
	
	@RequestMapping("update.board")
	public String update(@ModelAttribute Board board, HttpSession session) {
		if(boardService.updateBoard(board) > 0) {
			session.setAttribute("alertMsg", "문의사항 수정 완료");
			return "redirect:detail.board?boardNo=" + board.getBoardNo();
		} else {
			session.setAttribute("errorMsg", "문의사항 수정 실패");
			return "common/errorPage";
		}
	}
	
	
	// 글 삭제
	@RequestMapping("delete.board")
	public String deleteBoard(int boardNo, HttpSession session) {
		if(boardService.deleteBoard(boardNo) > 0) {
			session.setAttribute("alertMsg", "문의사항 삭제 완료");
			return "redirect:list.board";
		} else {
			session.setAttribute("alertMsg", "문의사항 삭제 실패");
			return "redirect:list.board";
		}
	}
	
	
	@ResponseBody
	@GetMapping(value="answer", produces="application/json; charset=UTF-8")
	public String selectAnswer(int boardNo) {
		return new Gson().toJson(boardService.selectAnswer(boardNo));
	}
	
	@ResponseBody
	@PostMapping("answer")
	public String ajaxInsertReply(Answer answer) {
		return boardService.insertAnswer(answer) > 0 ? "success" : "fail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
