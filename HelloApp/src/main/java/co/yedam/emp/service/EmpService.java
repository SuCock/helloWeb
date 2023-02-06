package co.yedam.emp.service;

import java.util.List;
import java.util.Map;

import co.yedam.emp.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> empList(); //목록.
	public int addEmp(EmpVO emp); //등록.
	public EmpVO getEmp(int empId); //조회.
	public int modEmp(EmpVO emp); //수정.
	public Map<String, String> jobList(); //직무목록.
	public int removeEmp(int id); // 삭제
}
