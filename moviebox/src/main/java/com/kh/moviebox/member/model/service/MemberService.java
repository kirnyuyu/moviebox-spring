package com.kh.moviebox.member.model.service;

import java.util.List;

import com.kh.moviebox.member.model.vo.Member;
import com.kh.moviebox.reservation.model.vo.Reservation;

public interface MemberService {
	
	// 로그인(SELECT)
	Member login(Member member);
	// 회원가입(INSERT)
	int insert(Member member);
	// 회원정보수정(UPDATE)
	int update(Member member);
	// 회원탈퇴(UPDATE)
	int delete(Member member);
	// ---------------------------------
	List<Reservation> myPagePrint(Member member);
	// 아이디 중복체크

	// ---------------------------------

	// 메일 인증

	// ---------------------------------

	// 소셜로그인
}
