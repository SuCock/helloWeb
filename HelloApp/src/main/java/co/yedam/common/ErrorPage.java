package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceMybatis;
import co.yedam.member.vo.MemberVO;

public class ErrorPage implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		// 새로고침하면 데이터베이스 수정작업이 반복됨으로 =>sendRidirect();로 처리하도록
		MemberVO vo = new MemberVO();
		vo.setMemberId("user1");
		vo.setMemberName("Hong");
		vo.setMemberPhone("010-1111");
		vo.setMemberAddr("대구 중구 100번지");
		
		req.setAttribute("obj", vo);
		
		EmpService service = new EmpServiceMybatis();
		req.setAttribute("empList", service.empList());
		
		try {
			req.getRequestDispatcher("WEB-INF/result/errorResult.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
