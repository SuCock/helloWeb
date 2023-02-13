package com.yedam.notice.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class NoticeListTable implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeService service = new NoticeServiceImpl();
		req.setAttribute("noticeList", service.noticeList()); // 요청정보에 담기.
		return "notice/noticeListTable.tiles";
	}

}