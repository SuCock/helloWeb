package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.emp.command.LoginControl;
import co.yedam.emp.command.ServiceControl;

@WebServlet("*.do")  // 불러오는 url의 키값이므로 중복이 있으면 충돌이 난다.
public class FrontController extends HttpServlet{
	
	// url패턴과 실행할 프로그램과 매핑.
	Map<String, Command>map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/service.do", new ServiceControl());
		map.put("/login.do", new LoginControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url패턴을 확인해서 요청하는 페이지가 어떤건지 찾는다.
		String uri = req.getRequestURI(); //url 요청정보 http://localhost:8081/HelloApp/*.do
		String context = req.getContextPath();  // /HelloApp 이부분만 읽어온다.
		String page = uri.substring(context.length());
		
		System.out.println("url : "+uri);
		System.out.println("context : "+context);
		System.out.println(page);
		
		Command command = map.get(page);
		command.exec(req, resp);
	}
	
	@Override
	public void destroy() {

	}
			
}
	