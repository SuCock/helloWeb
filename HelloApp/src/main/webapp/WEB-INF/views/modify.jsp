<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<form name="myFrm" action="employee.do" method="post">
	<!-- employee.do에서 받아준다. EmpControl로 요청 -->
	<%
	EmpVO emp = (EmpVO) request.getAttribute("searchVO");
	%>

	<h3>현재 페이지는 emp.ModForm.do의 결과 modify.jsp입니다.</h3>
	<table class="table">
	<tr>
	<th>사원번호:</th>
	<td> <input type="text" name="employee_id" value="<%=emp.getEmployeedId()%>"  ></td>
	</tr>
	<tr>
	<th>LastName:</th>
	<td><input type="text" name="last_name" value="<%=emp.getLastName()%>"></td>
	</tr>
	<tr>
	<th>이메일:</th>
	<td><input type="email" name="email" value="<%=emp.getEmail()%>"></td>
	</tr>
	<tr>
	<th>입사일자:</th>
	<td><input type="date" name="hire_date" value="<%=emp.getHireDate()%>"></td>
	</tr>
	<tr>
	<th>직무:</th>
	<td><input type="text" name = "job_Id" value="<%=emp.getJobId()%>">
	<select name="job">
		<option value="IT_PROG">개발자</option>
		<option value="SA_REP" selected>영업사원</option>
		<option value="SA_MAN">영업팀장</option>
	</select>
	</td>
	</tr>
	<tr>
	<td colspan = '2' align = "center">
	<input type="submit" value="수정" onclick="empList.do">
	</td>
	</tr>
</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>