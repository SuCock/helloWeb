package co.yedam.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.common.DataSource;
import co.yedam.emp.vo.EmpVO;
//EmpServiceImpl : jdbc
//EmpservieceMybatis : mybatis

public class EmpServiceMybatis implements EmpService {

	SqlSessionFactory sessionFactory = DataSource.geInstance();
	SqlSession session = sessionFactory.openSession(true); // 자동커밋.

	@Override
	public List<EmpVO> empList() {
		return session.selectList("co.yedam.emp.mapper.EmpMapper.empList"); // namesapce.id
	}

	@Override
	public int addEmp(EmpVO emp) {
		//session.commit(); 데이터를 여러개 넣어야 할 때는 자동 커밋말고 if문을 써서 하나하나 확인하면서 넣게한다. 틀리면 rollback으로.
		int r = session.insert("co.yedam.emp.mapper.EmpMapper.addEmp", emp);
		if(r>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return r; 
	}

	@Override
	public EmpVO getEmp(int empId) {
		// TODO Auto-generated method stub
		return session.selectOne("co.yedam.emp.mapper.EmpMapper.getEmp", empId);
	}

	@Override
	public int modEmp(EmpVO emp) {
		return session.update("co.yedam.emp.mapper.EmpMapper.modEmp",emp);
	}

	@Override
	public Map<String, String> jobList() {
		return null;//session.selectmap("co.yedam.emp.mapper.EmpMapper.jobList");
	}

	@Override
	public int removeEmp(int id) {
		return session.delete("co.yedam.emp.mapper.EmpMapper.removeEmp",id);
	}

}
