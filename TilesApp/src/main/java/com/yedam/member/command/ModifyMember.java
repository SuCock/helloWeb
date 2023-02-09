package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;
import com.yedam.member.vo.MemberVO;

public class ModifyMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mid = req.getParameter("mid");
		String mname = req.getParameter("mname");
		String mpass = req.getParameter("mpass");
		String mphone = req.getParameter("mphone");
		String mddr = req.getParameter("mddr");
		
		MemberVO vo = new MemberVO();
		vo.setMemberId(mid);
		vo.setMemberName(mname);
		vo.setMemberPw(mpass);
		vo.setMemberPhone(mphone);
		vo.setMemberAddr(mddr);
		
		MemberService service = new MemberServiceMybatis();
		service.modifyMember(vo);
		
		return "main/main.tiles";
	}

}
