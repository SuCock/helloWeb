package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.command.AddMember;
import com.yedam.member.command.ImageUpload;
import com.yedam.member.command.Login;
import com.yedam.member.command.LoginForm;
import com.yedam.member.command.Logout;
import com.yedam.member.command.MemberList;
import com.yedam.member.command.MemberManager;
import com.yedam.member.command.ModifyMember;
import com.yedam.member.command.RemoveMember;
import com.yedam.member.command.UpdateMember;
import com.yedam.member.command.myPageForm;
import com.yedam.notice.command.*;

public class FrontController extends HttpServlet {

	private Map<String, Command> map;
	private String charset;

	public FrontController() {
		map = new HashMap<String, Command>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		charset = config.getInitParameter("charset");

		map.put("/main.do", new MainControl());
		map.put("/second.do", new SecondControl());
		// 공지사항.
		map.put("/noticeListWithTables.do", new NoticeListTable()); // 데이터테이블글목록페이징.
		map.put("/noticeAddJson.do", new NoticeAddJson()); // 데이터테이블추가연습용.
		map.put("/noticeListJson.do", new NoticeListJson()); // 데이터테이블연습용.
		map.put("/noticeListAjax.do", new NoticeListAjax()); // ajax형식을 이용한 목록 출력.
		map.put("/noticeDelAjax.do", new NoticeDelAjax()); // ajax형식을 이용한 삭제.
		map.put("/noticeList.do", new NoticeList());
		map.put("/noticeDetail.do", new NoticeDetail());
		map.put("/noticeForm.do", new NoticeForm()); // 글등록화면.
		map.put("/noticeAdd.do", new NoticeAdd()); // 글등록처리.
		
		//댓글.
		map.put("/replyList.do", new ReplyList()); // 댓글목록.
		map.put("/removeReply.do", new RemoveReply()); // 댓글삭제.
		map.put("/addReply.do", new AddReply()); // 댓글등록.
		//회원관련.
		map.put("/loginForm.do", new LoginForm()); // 로그인페이지.
		map.put("/login.do", new Login()); // 로그인처리.
		map.put("/logout.do", new Logout()); // 로그아웃처리.
		map.put("/myPage.do", new myPageForm()); // 마이페이지화면.
		map.put("/modifyMember.do", new ModifyMember()); // 마이페이지수정처리.
		map.put("/imageUpload.do", new ImageUpload()); // 마이페이지이미지없로드.
		
		//관리자 회원관리.
		map.put("/memberManageForm.do", new MemberManager()); // 회원관리페이지.
		map.put("/memberList.do", new MemberList()); // 회원관리페이지-목록(json).
		map.put("/addMember.do", new AddMember()); // 회원관리페이지-등록.
		map.put("/removeMember.do", new RemoveMember()); // 회원관리페이지-삭제.
		map.put("/updateMember.do", new UpdateMember()); // 회원관리페이지-수정.
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);

		String uri = req.getRequestURI(); // 넘어온 uri
		String context = req.getContextPath(); // path
		String page = uri.substring(context.length()); /// main.do 뒷부분 자르기(페이지 구분)
		System.out.println(page);

		Command command = map.get(page);
		String viewPage = command.exec(req, resp);
		// main/main.tiles가 요청이 들어오면

		if(viewPage.endsWith(".tiles")) {			
			RequestDispatcher rd = req.getRequestDispatcher(viewPage);
			rd.forward(req, resp);
			// forwarding 작업.
			// .do 처리는 못해준다.
			//if문으로 .do가 들어오는 상황에 연결해줘야한다.
		}else if(viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
		}else if (viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0, viewPage.length() - 5)); // .json 붙은걸 빼야해서 자른다.
		}
		
	}

}
