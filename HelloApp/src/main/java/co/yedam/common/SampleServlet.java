package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample") // url에 .do가 붙어야 한다. // ("/*")어떠한 요청이 들어오든 servlet으로 처리하겠다.
public class SampleServlet extends HttpServlet {
	//서블릿. 생명주기: 인스턴스 -> init -> service -> destory
	
	public SampleServlet() {
		System.out.println("생서자 호출.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		System.out.println("init 실행: 서버 실행 후 한번만 실행됨.");
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)throws ServletException, IOException{
		System.out.println("service 실행: 해당 url를 호출할 때마다 실행됨.");
	}
	@Override
	public void destroy() {
		System.out.println("서버가 종료될때 한번만 실행됨.");
	}
}
