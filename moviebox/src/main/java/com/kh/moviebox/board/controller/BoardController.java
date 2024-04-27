package com.kh.moviebox.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.moviebox.board.model.service.BoardService;
import com.kh.moviebox.common.model.vo.PageInfo;
import com.kh.moviebox.common.template.Pagination;

import lombok.extern.slf4j.Slf4j;

@Controller
//@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("list.board")
	public String selectAl(@RequestParam(value="page", defaultValue="1") int page, Model model) {
		PageInfo pi = Pagination.getPageInfo(boardService.selectListCount(), page, 5, 10);
		
		model.addAttribute("list", boardService.selectList(pi));
		model.addAttribute("pageInfo", pi);
		return "board/boardList";
	}
}
