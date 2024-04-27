package com.kh.moviebox.movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.moviebox.movie.model.service.MovieService;
import com.kh.moviebox.movie.model.vo.Movie;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping("list.movie")
	public String movieList(Model model) {
		model.addAttribute("movieList", movieService.selectList());
		
		
		return "movie/movieList";
	}
}
