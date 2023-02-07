package co.yedam.emp.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceMybatis;
import co.yedam.emp.vo.EmpVO;

public class EmpModifyContorol implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//service : int modEmp(EmpVO) 등록 -> serviceImpl:modEmp(EmpVO) 구현 -> dao 클래스 : updateEmp(EmpVO) 정의
		//1단계-----------------------------------------
		String id = req.getParameter("eid"); // form>input>name속성
		String fn = req.getParameter("fname");
		String ln = req.getParameter("lname");
		String ma = req.getParameter("email");
		String jb = req.getParameter("job");
		String hi = req.getParameter("hire");
		
		EmpService service = new EmpServiceMybatis();
		EmpVO emp = new EmpVO();
		
		emp.setEmployeeId(Integer.parseInt(id));
		emp.setFirstName(fn);
		emp.setLastName(ln);
		emp.setJobId(jb);
		emp.setHireDate(hi);
		emp.setEmail(ma);
		//-----------------------------------------
		int r = service.modEmp(emp);
		
		RequestDispatcher rd = null;
		
		String method = req.getMethod();
		System.out.println("요청방식 : " + method);
		
		try {
			if( r > 0) { //정상처리되면 목록으로 이동
				resp.sendRedirect("empList.do"); //이동하고 싶은 곳을 지정할 수 있음
			} else {
				rd = req.getRequestDispatcher("errorPage.do");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
