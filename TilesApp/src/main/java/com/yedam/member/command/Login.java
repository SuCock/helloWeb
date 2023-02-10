package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;
import com.yedam.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 로그인 성공하면 myPage로 이동.
		// 로그인 실패하면 다시 로그인화면으로 이동할때 "아이디와패스워트를 확인"하도록.
		String id = req.getParameter("mid");
		String pw = req.getParameter("mpw");

		MemberVO member = new MemberVO();
		member.setMemberId(id);
		member.setMemberPw(pw);

		MemberService service = new MemberServiceMybatis();
		MemberVO vo = service.login(member);
		String page = "";
		if (vo != null) {
			// session에 로그인 정보 담기.
			HttpSession session = req.getSession();  
			MemberVO mvo = service.getMember(id);
			session.setAttribute("id", mvo.getMemberId());  // session에 정보를 담는다.
			session.setAttribute("name", mvo.getMemberName());
			session.setAttribute("Auth", mvo.getResponsibility());
			
			MemberVO member2 = service.getMember(id);
			
			req.setAttribute("vo", member2);  // id를 요청.
			
			page = "mypage";
			
			//return "member/mypage.tiles";
		} else {
			req.setAttribute("result", "회원정보를 확인하세요.");
			page = "login";
		}
		return "member/"+page+".tiles"; // session없이 return을 하면 값을 들고 가지않고 그냥 페이지만 이동을 한다.
		//return "member/login.tiles";
	}
}
