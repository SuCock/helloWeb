package com.yedam.common;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 반환값이 실행할 페이지를 지정.
		// 업무/페이지.
		return "main/main.tiles";
	}


}
