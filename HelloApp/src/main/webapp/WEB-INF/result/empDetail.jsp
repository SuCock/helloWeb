<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
EmpVO emp = (EmpVO) request.getAttribute("searchVO");
Integer age = (Integer) request.getAttribute("myAge");
String id = (String) request.getAttribute("loginId");
%>
<%=age%>,
<%=id%>
<h3>현채 페이지는 empDetail.do의 결과 emp.Detail.jsp입니다.</h3>
<table class="table">
	<tr>
		<th>사원번호</th>
		<td><%=emp.getEmployeedId()%>
		</td>
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
	<tr>
		<td colspan='2' align="center">
			<button class="btn btn-primary" onclick="location.href='empModForm.do?id=<%=emp.getEmployeedId()%>'">수정</button>
			<button class="btn btn-warning">삭제</button></td>
	</tr>

</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>