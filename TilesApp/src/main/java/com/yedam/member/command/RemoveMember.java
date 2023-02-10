package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;
import com.yedam.member.vo.MemberVO;

public class RemoveMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = req.getParameter("id");
		

		MemberService service = new MemberServiceMybatis();
		String json = "";

		// req.setAttribute("vo", service.removeMember(Integer.parseInt(mid)));
		if (service.removeMember(id) > 0) {
			// {"retCode": "Success"}
			json = "{\"retCode\": \"Success\"}";
		} else {
			// {"retCode": "Fail"}
			json = "{\"retCode\": \"Fail\"}";
		}
		return json + ".json";
	}

}
