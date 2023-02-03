package co.yedam.emp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class LoginControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		String method = req.getMethod();
		System.out.println("요청방식: "+method);
		System.out.println("로그인 컨트롤");
		String id = req.getParameter("uid");  // form태그하위에 있는 input: name 속성.
		String pw = req.getParameter("upw");
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
	}

}
