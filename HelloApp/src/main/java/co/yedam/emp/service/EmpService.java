package co.yedam.emp.service;

import java.util.List;

import co.yedam.emp.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> empList(); //목록.
	public int addEmp(EmpVO emp); //등록.
	public EmpVO getEmp(int empId); //조회.
	public EmpVO updateEmp(EmpVO emp); //수정.
}
