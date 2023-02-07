<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/errorResult.jsp</title>
</head>
<body>
	<h3>처리중 에러 발생!!</h3>
	<h3>Expression Language (EL)</h3>
	<p>${3>5 }</p>
	<p>${'test' }</p>
	<p>${5-4 }</p>
	<p>${id }</p>
	<p>${id eq null }</p>
	<p>${!id == true }</p>
	<p>${empty id }</p>
	<P>${id eq null }</P>
	<p>${obj }</p>
	<p>ID: ${obj.memberId }</p>
	<p>Name: ${obj.memberName }</p>
	<p>List: ${empList }</p>

	<p>html안에 자바코드 제거. jstl로 바꾸기</p>

	<c:set var="myname" value="홍길동"></c:set>
	<!-- 변수에 값을 받는 태그 -->
	<c:out value="${myname }"></c:out>
	<!-- 값을 출력하는 태그 -->
	<p>${myname }</p>

	<c:set var="score" value="70"></c:set>
	<c:if test="${score == 70 }">
		<p>같습니다</p>
	</c:if>
	<c:if test="${score != 70 }">
		<p>다릅니다</p>
	</c:if>
	<c:if test="${score > 60 }">
		<p>합격!</p>
	</c:if>
	<c:if test="${score < 60 }">
		<p>불합격!</p>
	</c:if>

	<c:choose>
		<c:when test="${score > 90 }">
			<p>A학점</p>
		</c:when>
		<c:when test="${score > 80 }">
			<p>B학점</p>
		</c:when>
		<c:when test="${score > 70 }">
			<p>C학점</p>
		</c:when>
		<c:otherwise>
			<p>D학점</p>
		</c:otherwise>
	</c:choose>

	<c:forEach begin='1' end='10' var='num'>
		<!-- 1에서 10까지 반복 변수명은 num -->
		<p class='<c:out value="${num }"/>'>${num }</p>
	</c:forEach>

	<p>3단 출력하기</p>
	<c:set var="dan" value="3"></c:set>
	<table class="table" border="1">
		<c:forEach begin='1' end='9' var='num'>
			<tr>
				<td>${dan}</td>
				<td>*</td>
				<td>${num}</td>
				<td>=</td>
				<td>${num*dan }</td>
				</r>
				<!-- 클래스에 값이 들어간다는걸 보여준다. 클래스는 없어도 된다. -->
		</c:forEach>
	</table>
	<c:forEach items="${empList }" var="emp">
		<p>사번: ${emp.employeeId }, 이름: ${emp.firstName }, 이메일: ${emp.email }, 직무: ${emp.jobId }</p>
	</c:forEach>

</body>
</html>