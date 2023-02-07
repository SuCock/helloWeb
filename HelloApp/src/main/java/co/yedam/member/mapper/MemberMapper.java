package co.yedam.member.mapper;

import java.util.List;

import co.yedam.member.vo.MemberVO;
	// 데이터 처리하는 곳
public interface MemberMapper {
	public MemberVO login(MemberVO member);
	public int addMember (MemberVO member); // 등록.
	public List<MemberVO> memberList(); // 회원전체목록. 
	//조회 업데이트 입력 3개의 기능을 써야할 때
	//조회 업데이트 2개의 기능
	//조회 입력.. 중복이 많아진다
	//조회에 입력하고 업데이트하는 처리를 해야할떄 기능은 같지만 다르다.
	
	//최대한 작은 기능으로 나눈다 
	}
