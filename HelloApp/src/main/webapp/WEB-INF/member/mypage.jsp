<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>현재 페이지는 myPageForm.do의 결과 mypage.jsp입니다.</h3>

<form>
	<table class="table">
		<tr>
			<th>회원아이디</th>
			<td><input type="text" name="mid" value="${vo.memberId }"
				readonly></td>
		</tr>
		<tr>
			<th>회원이름</th>
			<td><input type="text" name="mname" value="${vo.memberName }"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="mpass" value="${vo.memberPw }"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="mphone" value="${vo.memberPhone }"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="mddr" value="${vo.memberAddr }"></td>
		</tr>
		<tr>
		<th>이미지</th><td><img width="150px" src = "images/${vo.image }"></td>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>