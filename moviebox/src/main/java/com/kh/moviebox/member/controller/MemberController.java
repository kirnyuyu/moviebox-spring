package com.kh.moviebox.member.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.moviebox.common.model.vo.Genre;
import com.kh.moviebox.member.model.service.MemberService;
import com.kh.moviebox.member.model.vo.Member;
import com.kh.moviebox.reservation.model.vo.Reservation;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder; 
	
	@RequestMapping("loginForm.member")
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping("login.member")
	public ModelAndView login(Member member, HttpSession session,ModelAndView mv) {


		
		Member loginUser = memberService.login(member);
		

		if(loginUser != null && bcryptPasswordEncoder.matches(member.getMemberPwd(), loginUser.getMemberPwd())) {
			
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "로그인성공");
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("errorMsg","로그인 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping("logout.member")
	public ModelAndView logout(HttpSession session,ModelAndView mv) {
		
		session.removeAttribute("loginUser");
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	

	@RequestMapping("enrollForm.member")
	public String enrollForm() {
		return "member/memberInsert";
	}
	
	@RequestMapping("insert.member")
	public ModelAndView insertMember(Member member,@RequestParam(required = false) String[] genres, ModelAndView mv,HttpSession session) {
		
		List<Genre> genreList = new ArrayList<>();
		if (genres != null) {
		    for (int i = 0; i < genres.length; i++) {
		        Genre g = new Genre();
		        g.setGenreName(genres[i]);
		        genreList.add(g);
		    }
		}
		member.setGenreList(genreList);
		String encPwd = bcryptPasswordEncoder.encode(member.getMemberPwd());

		member.setMemberPwd(encPwd);
		
		if(memberService.insert(member) > 0) {
			session.setAttribute("alertMsg", "가입성공");
			mv.setViewName("redirect:/");
		}else {
			mv.addObject("errorMsg","회원가입 실패").setViewName("common/errorPage");
		}
		return mv;
		
	}
	
	@RequestMapping("myPage.member")
	public ModelAndView myPage(ModelAndView mv,HttpSession session) {
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mv.setViewName("redirect:/");
			return mv;
		} else {
			mv.addObject("list",memberService.myPagePrint(loginUser)).setViewName("member/myPage");;
			return mv;
		}
		
		
		
	}
	
	@RequestMapping("resList.member")
	public ModelAndView myReservation(ModelAndView mv,HttpSession session) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd, HH:mm");
		
		Date current = new Date();
		
		boolean isBeforeCurrent = true;
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		
		if(loginUser == null) {
			mv.setViewName("redirect:/");
			return mv;
		} else {
			List<Reservation> list = memberService.myPagePrint(loginUser);
			if(list.isEmpty()) {
				mv.setViewName("member/myReservation");
				return mv;
			} else {
				for(int i = 0; i < list.size(); i++) {
					try {
						Date watchDate = dateFormat.parse(list.get(i).getWatchDate());
						
						isBeforeCurrent = watchDate.before(current);
						
						list.get(i).setBeforeCurrent(isBeforeCurrent);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				mv.addObject("list",list).setViewName("member/myReservation");
				return mv;
			}
		}
		
		
	}
	
}
