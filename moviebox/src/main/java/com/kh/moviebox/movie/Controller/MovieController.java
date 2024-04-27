package com.kh.moviebox.movie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.moviebox.common.model.vo.Attachment;
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
	
	@RequestMapping("selectGenre.movie")
	public String genre(String genre, String type, Model model) {
		List<Movie> list = movieService.selectList();
		
		if(genre != null) {
			if(!genre.equals("전체")) {
				list = movieService.genreMovie(genre);
			}
		}
		
		model.addAttribute("genre", genre);
		model.addAttribute("type", type);
		model.addAttribute("movieList", list);
		
		return "movie/movieList";
	}
	
	
	@RequestMapping("detail.movie")
	public String detailMovie(Model model, int movieNo) {
		
		List<Movie> list = movieService.detailMovie(movieNo);
		List<Attachment> stilCut = movieService.stilCut(movieNo);
		
		String cast = movieService.movieCast(movieNo);
		
		model.addAttribute("cast", cast);
		model.addAttribute("stilCut", stilCut);
		model.addAttribute("movieList", list);
		
		return "movie/movieDetail";
		
	}
	
	
	
	
}
