package co.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class SignOnFormControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		//sigon.jsp
		try {
			req.getRequestDispatcher("WEB-INF/member/signOn.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
