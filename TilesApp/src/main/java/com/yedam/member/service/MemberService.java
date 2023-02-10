package com.yedam.member.service;

import java.util.List;

import com.yedam.member.vo.MemberVO;
	// mapper의 작은 기능들을 조합하는 곳.
public interface MemberService {
	public MemberVO login(MemberVO member); 
	public int addMember(MemberVO member);
	public List<MemberVO> memberList();  //list형식으로 자료를 뱉겠다. 목록출력.
	public MemberVO getMember(String id); // 회원정보조회용.
	public int modifyMember(MemberVO member); // 회원정보수정.
	public int removeMember(String mid); // 회원삭제.
}
