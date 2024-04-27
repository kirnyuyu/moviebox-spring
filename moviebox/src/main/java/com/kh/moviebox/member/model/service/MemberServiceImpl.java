package com.kh.moviebox.member.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moviebox.member.model.dao.MemberRepository;
import com.kh.moviebox.member.model.vo.Member;
import com.kh.moviebox.reservation.model.vo.Reservation;
// @Component == Bean으로 등록하겠다
@Service // Component보다 더 구체적으로 ServiceBean으로 등록하겠다.
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member login(Member member) {

		return memberRepository.login(sqlSession, member);
	}

	@Override
	public int insert(Member member) {

		return memberRepository.insert(sqlSession, member);
	}




	@Override
	public List<Reservation> myPagePrint(Member member) {
		return memberRepository.myPagePrint(sqlSession,member);
	}
	
	
	
	@Override
	public int update(Member member) {
		return 0;
	}
	
	@Override
	public int delete(Member member) {
		return 0;
	}
	
}
