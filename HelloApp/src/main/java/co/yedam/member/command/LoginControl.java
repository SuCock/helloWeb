package co.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceMybatis;
import co.yedam.member.vo.MemberVO;

public class LoginControl implements Command {
	
	

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//로그인이 되면 session객체 serAttribute('id')
		
		String method = req.getMethod();
		String id = req.getParameter("mid");  // form태그하위에 있는 input: name 속성.
		String pw = req.getParameter("mpw");
		
		MemberVO member = new MemberVO();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		MemberService service = new MemberServiceMybatis();
		MemberVO rvo = service.login(member);
		if(rvo != null) {
			try {
				resp.sendRedirect("empList.do");
				HttpSession session = req.getSession();
				
				session.setAttribute("id", rvo.getMemberId());  
				session.setAttribute("name", rvo.getMemberName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				req.setAttribute("result", "회원정보를 확인하세요."); // 다시 로그인의 메세지를 띄워주기 위해서 -> req.getRequestDispatcher("WEB-INF/member/login.jsp").forward(req, resp); 써야한다.
				req.getRequestDispatcher("WEB-INF/member/login.jsp").forward(req, resp);  //forward(req, resp);->resp응답이라고 
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
