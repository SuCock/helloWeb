package co.yedam.emp.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class EmpModifyContorol implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// service: int modEmp(EmpVO) -> serviceImplL moeEmp(EmpVO) -> dao: updateEmp(EmpVO)
		RequestDispatcher rd = null;
		
		

	}

}
