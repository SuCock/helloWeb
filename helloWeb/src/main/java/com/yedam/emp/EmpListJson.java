package com.yedam.emp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/empListJson")
public class EmpListJson extends HttpServlet { // 링크이동
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String parm = req.getParameter("param");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String hire = req.getParameter("hire");
		String job = req.getParameter("job");

		EmpVO vo = new EmpVO();
		vo.setEmployeeId(Integer.parseInt(id));
		vo.setLastName(name);
		vo.setEmail(mail);
		vo.setHireDate(hire);
		vo.setJobId(job);

		EmpDAO dao = new EmpDAO();

		// param=update => DB update.
		// param=xxx => DB insert.

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String parm = req.getParameter("param");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String hire = req.getParameter("hire");
		String job = req.getParameter("job");

		EmpVO vo = new EmpVO();
		vo.setEmployeeId(Integer.parseInt(id));
		vo.setLastName(name);
		vo.setEmail(mail);
		vo.setHireDate(hire);
		vo.setJobId(job);

		EmpDAO dao = new EmpDAO();
		if (parm.equals("update")) {
			if (dao.updateEmp(vo) > 0) {
				resp.getWriter().print("{\"retCode\":\"Success\"}");
			} else {
				resp.getWriter().print("{\"reCode\":\"Fail\"}");
			}
		} else {
			if (dao.addEmp(vo) > 0) {
				resp.getWriter().print("{\"retCode\":\"Success\"}");
			} else {
				resp.getWriter().print("{\"reCode\":\"Fail\"}");

			}

		}
	}

	// 제어의 역전(IOC) Inversion Of Control
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("del_id"); // 요청페이지에서 del_id이름으로 파라미터 지정.

		Map<String, Object> map = new HashMap<>();
		map.put("id", id);

		EmpDAO dao = new EmpDAO();
		if (dao.deleteEmp(Integer.parseInt(id)) > 0) {
			// {"retCode":"Success"}
			// resp.getWriter().print("{\"retCode\":\"Success\"}");
			map.put("retCode", "Success"); // jackson_databind 라이브러리 이용.
		} else {
			// {"reCode":"Fail"}
			// resp.getWriter().print("{\"reCode\":\"Fail\"}");
			map.put("retCode", "Fail"); // jackson_databind 라이브러리 이용.
		}
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(map));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8"); // text의 json형식의 한글을 utf-8로 바꾸시오.
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.empVoList();
		// [{"id": 100, "firstName": "Hong", "email": "Hong@email.com"...},{},{}]
		String json = "[";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"id\":" + list.get(i).getEmployeeId() + ", \"firstName\":\"" + list.get(i).getFirstName() + "\""
					+ ",\"lastName\":\"" + list.get(i).getLastName() + "\"" + ",\"email\":\"" + list.get(i).getEmail()
					+ "\"" + ",\"hireDate\":\"" + list.get(i).getHireDate().substring(0, 10) + "\"" + ",\"jobId\":\""
					+ list.get(i).getJobId() + "\"" + "}";
			if (i + 1 != list.size()) {
				json += ",";
			}
		}
		json += "]";

		resp.getWriter().print(json);
	}
}
