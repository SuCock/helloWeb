package co.yedam.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.common.DataSource;
import co.yedam.emp.vo.EmpVO;
//EmpServiceImpl : jdbc
//EmpservieceMybatis : mybatis

public class EmpServiceMybatis implements EmpService{

	SqlSessionFactory sessionFactory = DataSource.geInstance();
	SqlSession session = sessionFactory.openSession();
	
	@Override
	public List<EmpVO> empList() {
		return session.selectList("co.yedam.emp.mapper.EmpMapper.empList");   // namesapce.id
	}

	@Override
	public int addEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpVO getEmp(int empId) {
		// TODO Auto-generated method stub
		return session.selectOne("co.yedam.emp.mapper.EmpMapper.getEmp",empId);
	}

	@Override
	public int modEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, String> jobList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeEmp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
