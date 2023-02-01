package com.yedam.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.emp.EmpVO;

public class DartDAO {
	// 필드
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "dev";
	String pass = "dev";

	Connection conn;
	Statement stmt = null;
	PreparedStatement psmt = null; // 파라미터 처리(?)
	ResultSet rs = null;
	String sql;

	// 메소드
	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("에러발생.");
			e.printStackTrace();
		}
	}

	// CRUD 처리.
	// 회원가입
	public int addMem(DartVO dart) {
		connect();
		sql = "insert into dart (mem_Id, mem_Pass, mem_Name, mem_Addr, mem_Tel) values(?, ?, ?, ?, ?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dart.getMemId());
			psmt.setString(2, dart.getMemPass());
			psmt.setString(3, dart.getMemName());
			psmt.setString(4, dart.getMemAddr());
			psmt.setString(5, dart.getMemTel());

			r = psmt.executeUpdate(); // 처리된 건수.

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;

	}

	// 로그인
	public int login(String memId, String memPass) { // 어떤 계정에 대한 실제로 로그인을 시도하는 함수, 인자값으로 ID와 Password를 받아 login을 판단함.
		connect();
		sql = "SELECT mem_Pass FROM dart WHERE mem_Id = ?"; // 실제로 DB에 입력될 명령어를 SQL 문장으로 만듬.
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memId);
			rs = psmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌
			if (rs.next()) {
				if (rs.getString(1).equals(memPass)) {
					return 1; // 로그인 성공
				} else {
					System.out.println("✖✖✖✖✖✖비밀번호가 불일치 합니다✖✖✖✖✖✖");
					return 0; // 비밀번호 불일치
				}
			}
			System.out.println("✖✖✖✖✖✖동일한 아이디가 없습니다✖✖✖✖✖✖");
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류
	}

	// 회원조회
	public List<Map<String, Object>> memList() {
		sql = "select * from dart";
		connect();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("mem_id", rs.getString("mem_id"));
				map.put("mem_name", rs.getString("mem_name"));
				map.put("mem_addr", rs.getString("mem_addr"));
				map.put("mem_tel", rs.getString("mem_tel"));

				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 다트 던지기
	public int playDart(DartVO point) {
		connect();
		sql = "update dart set mem_point = ? where mem_id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, point.getMemPoint());
			psmt.setString(2, point.getMemId());
			r = psmt.executeUpdate(); // 처리된 건수.

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;

	}

	// 등수
	public List<Map<String, Object>> memRK() {
		sql = "select * from dart ORDER BY to_number (mem_point) desc";
		connect();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("mem_id", rs.getString("mem_id")); // put(키값, value값)
				map.put("mem_point", rs.getInt("mem_point"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 회원수정
	public int memModify(DartVO modify) {
		connect();
		sql = "update dart set mem_pass = ?, mem_name = ?, mem_addr = ?, mem_tel = ? where mem_id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, modify.getMemPass());
			psmt.setString(2, modify.getMemName());
			psmt.setString(3, modify.getMemAddr());
			psmt.setString(4, modify.getMemTel());
			psmt.setString(5, modify.getMemId());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} // 처리된 건수.
		return r;
	}

	// 회원탈퇴
	public int remove(String memid) {
		connect();
		sql = "delete from dart where mem_id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memid);
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	public List<DartVO> DartVoList() {
		connect();
		sql = "select * from dart";
		List<DartVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DartVO emp = new DartVO();
				emp.setMemId(rs.getString("mem_id"));
				emp.setMemPass(rs.getString("mem_pass"));
				emp.setMemName(rs.getString("mem_name"));
				emp.setMemAddr(rs.getString("mem_addr"));
				emp.setMemTel(rs.getString("mem_tel"));
				emp.setMemPoint(rs.getInt("mem_point"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
