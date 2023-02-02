package com.yedam.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.emp.EmpDAO;
import com.yedam.emp.EmpVO;

	@WebServlet("/dartMemJson")
	public class DartJson extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");

			String id = req.getParameter("id");
			String pass = req.getParameter("pass");
			String name = req.getParameter("name");
			String addr = req.getParameter("addr");
			String phone = req.getParameter("phone");

			DartVO vo = new DartVO();
			vo.setMemId(id);
			vo.setMemPass(pass);
			vo.setMemName(name);
			vo.setMemAddr(addr);
			vo.setMemTel(phone);

			DartDAO dao = new DartDAO();
			if (dao.addMem(vo) > 0) {
				resp.getWriter().print("{\"retCode\":\"Success\"}");
			} else {
				resp.getWriter().print("{\"reCode\":\"Fail\"}");

			}
		}
			
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/json;charset=utf-8"); // text의 json형식의 한글을 utf-8로 바꾸시오.
				DartDAO dao = new DartDAO();
				List<DartVO> list = dao.DartVoList();
				// [{"id": 100, "firstName": "Hong", "email": "Hong@email.com"...},{},{}]
				String json = "[";
				for (int i = 0; i < list.size(); i++) {
					json += "{\"id\":\"" + list.get(i).getMemId() +"\""
							+ ",\"password\":\"" + list.get(i).getMemPass() + "\""
							+ ",\"name\":\"" + list.get(i).getMemName() + "\"" 
							+ ",\"address\":\"" + list.get(i).getMemAddr()+ "\"" 
							+ ",\"telNumber\":\"" + list.get(i).getMemTel() + "\"" 
							+ ",\"point\":\""+ list.get(i).getMemPoint() + "\"" 
							+ "}";
					if (i + 1 != list.size()) {
						json += ",";
					}
				}
				json += "]";

				resp.getWriter().print(json);
			}
		}
	

