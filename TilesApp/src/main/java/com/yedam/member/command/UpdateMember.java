package com.yedam.member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;
import com.yedam.member.vo.MemberVO;

public class UpdateMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		String res = req.getParameter("res");

		MemberVO vo = new MemberVO();
		vo.setMemberId(id);
		vo.setMemberName(name);
		vo.setMemberPw(pass);
		vo.setMemberPhone(phone);
		vo.setMemberAddr(addr);
		vo.setResponsibility(res);

		MemberService service = new MemberServiceMybatis();

		String json = "";
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("member", vo);
		
		Gson gson = new GsonBuilder().create();

		if (service.modifyMember(vo) > 0) {
			// {"retCode": "Success"}
			resultMap.put("retCode", "Success");
		} else {
			// {"retCode": "Fail"}
			resultMap.put("retCode", "Fail");
		}
		return gson.toJson(resultMap)+".json";
	}

}
