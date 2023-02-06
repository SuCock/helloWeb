<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<%
	Map<String, String> list = (Map<String, String>) request.getAttribute("jobList"); // object -> (EmpVO) 타입으로 반환.
	%>
	<form name = "myFrm" action = "employee.do" method="post">  <!-- employee.do에서 받아준다. EmpControl로 요청 -->
	<table class = "table">
	<tr>
		<th>사원번호:</th>
		<td><input type ="number" name="eid"></td>
		</tr>
		<tr>
		<th>LastName:</th>
		<td><input type ="text" name="last_name"></td>
		</tr>
		<tr>
		<th>이메일:</th>
		<td><input type ="email" name="email"></td>
		</tr>
		<tr>
		<th>입사일자:</th>
		<td><input type ="date" name="hire_date"></td>
		</tr>
		<tr>
		<th>직무:</th>
		<td><select name="job">
		<%for (Entry<String, String> ent : list.entrySet()){
			%>
			<option value="<%=ent.getKey() %>"><%=ent.getValue() %></option>
		<% }%>
		</select></td>
		</tr>
		<tr>
		<td colspan ='2' align = "center"> 
		<input type = "submit" value="전송">
		<input type = "button" value="조회" onclick="empGetFnc()">
		<input type = "button" value="다음" onclick="daumGetFnc()">	
		<a href = "../result/empList.jsp">조회.</a></td>
		</tr>
	</table>
	</form>
	<script>
		console.log(document.forms.myFrm);
		function empGetFnc(){
			document.forms.myFrm.method = 'get'; // button을 누르면 onclick="empGetFnc()"를 실행하고 타입이 get으로 바뀐 정보를 submit한다.
			document.forms.myFrm.action = 'empList.do';
			document.forms.myFrm.submit();
		}
		function daumGetFnc(){
			document.forms.myFrm.method = 'delete'; 
			document.forms.myFrm.submit();
		}
	</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>