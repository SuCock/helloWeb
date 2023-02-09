package com.yedam.notice.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Command;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;
import com.yedam.notice.vo.ReplyVO;

public class ReplyList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nid = req.getParameter("nid");

		NoticeService service = new NoticeServiceImpl();
		List<ReplyVO> list = service.replyList(Integer.parseInt(nid)); // 넘어가는 페이지가 아닌 json의 데이터가 필요하다.

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(list); // json포맷의 데이터를 만들어준다.

		return json + ".json";
	}

}
