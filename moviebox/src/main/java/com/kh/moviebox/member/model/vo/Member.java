package com.kh.moviebox.member.model.vo;

import java.sql.Date;
import java.util.List;

import com.kh.moviebox.common.model.vo.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Lombok(롬복)
 * 
 * - 자동 코드 생성 라이브러리 => 코드 다이어트
 * 
 * Lombok
 * 1. 라이브러리 다운로드
 * 2. 다운로드 된 jar파일을 찾아서 설치(작업할 IDE체크)
 * 3. IDE 재실행
 * 
 * @Getter
 * @Setter
 * @ToString
 * @NoArgsConstructor
 * 
 * ------------------
 * @Builder
 * @AllArgsConstructor
 * -------------------
 * @Data
 * -------------------
 *  - Lombok 사용 시 주의 사항
 *  - pName이라는 필드를 선언했을 경우
 *  Lombok의 명명 규칙 == setPName() / getPName()
 *  
 *  => EL표기법을 이용한 내부적 getter메소드 호출 식
 *  
 *  ${ pName } == getpName()
 * 
 */
//@Data
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String birthday;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private Date enrollDate;
	private String status;
	private String privilege;
	private String localCode;
	private String localName;
	private List<Genre> genreList;
	
	
	
	
}
