package com.kh.moviebox.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.moviebox.member.model.vo.Member;
import com.kh.moviebox.reservation.model.vo.Reservation;

@Repository // 저장소 관련된 작업(영성속)을 처리하겠다는 뜻
public class MemberRepository {
	
	
	public Member login(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}
	public int insert(SqlSessionTemplate sqlSession,Member member) {
		return sqlSession.insert("memberMapper.memberInsert",member);
	}
	public List<Reservation> myPagePrint(SqlSessionTemplate sqlSession,Member member) {
		return sqlSession.selectList("memberMapper.myPagePrint", member);
	}
}
