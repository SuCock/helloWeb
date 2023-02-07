<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
EmpVO emp = (EmpVO) request.getAttribute("searchVO");
String id = (String)session.getAttribute("id");
%>
<%=id%>
<h3>현채 페이지는 empDetail.do의 결과 emp.Detail.jsp입니다.</h3>
<table class="table">
	<tr>
		<th>사원번호</th>
		<td><%=emp.getEmployeeId()%>
		</td>
	</tr>
	<tr>
		<th>FirstName</th>
		<td><%=emp.getFirstName()%></td>
	</tr>
	<tr>
		<th>LastName</th>
		<td><%=emp.getLastName()%></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><%=emp.getEmail()%></td>
	</tr>
	<tr>

		<th>직무</th>
		<td><%=emp.getJobId()%></td>
	</tr>
	<tr>
		<th>입사일자</th>
		<td><%=emp.getHireDate()%></td>
	</tr>
	<% if (id != null){%>
	<tr>
		<td colspan='2' align="center">
			<button class="btn btn-primary" onclick="location.href='empModForm.do?id=<%=emp.getEmployeeId()%>'">수정</button>
			<button class="btn btn-warning" onclick="location.href='empRemove.do?id=<%=emp.getEmployeeId()%>'">삭제</button></td><!-- empRemove.do?id=?  removeEmp(Int id) id를 받아서 삭제하기위한 컨트롤 등록 서비스와 DAO에도 삭제메소드 추가 -->
	</tr>
	<%} else{%>
	<tr>
	<td colspan='2' align="center">Guest는 수정,삭제를 할 수 없습니다.</td>
	</tr>
	<%}%>
</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>