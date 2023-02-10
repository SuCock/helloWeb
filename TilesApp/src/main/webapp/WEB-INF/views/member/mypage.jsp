<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<h3>현재 페이지는 myPageForm.do의 결과 mypage.jsp입니다.</h3>

<form action="modifyMember.do" method="post">
	<input type="file" id="fileUpload" accept="image/*"
		style="display: none" onchange="imageChangeFnc()">
	<!--  accept="image/*" 이미지 파일만 선택 -->
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
			<th>이미지</th>
			<td><img id="imgSrc" width="150px" src="upload/${vo.image }"></td>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정"
				class="btn btn-primary"></td>
		</tr>
	</table>
</form>
<script>
	//event등록: addEventListener('type', function(){})
	//elem.on('click', function(){})
	$('#imgSrc').on('click', function(){
		$('#fileUpload').click();
	})
	
	function imageChangeFnc(){
		console.log($('#fileUpload')[0].files[0]); // $('#fileUpload')[0].files[0] 선택한 이미지 정보를 가지고 있는 놈.
		let file = $('#fileUpload')[0].files[0]; // 서버 업로드 할 때 필요한 정보.
		
		let formData = new FormData(); // multipart/form-datad을 요청할 때 처리해주는 객체.
		formData.append('id',"${vo.memberId }"); // id와 file만 업로드 해서 서버에 저장하고 데이터베이스에도 변경.
		formData.append('image',file); // Parameter이름과 같아야하나 -> 이름을 주는애 imageUpload에서 받는다.
		
		// 서버에 multipart/form-data 타입: ajax로 요청.
		$.ajax({
			url:'imageUpload.do',
			method: 'post',
			data: formData,
			contentType: false, // multipart요청일 경우에 옵션. 불러올 수 없다. 무조건false로.
			processData: false, // multipart요청일 경우에 옵션.
			success:function(result){
				console.log(result);
				// 화면에서 선택된 이미지가 보여진다.
				let reader = new FileReader();
				reader.onload=function(e){  // 파일을 읽어들일 때 onload 이벤트 발생.
					console.log(e.target);
					$('#imgSrc').attr('src',e.target.result); // 이미지 값.
				}
				reader.readAsDataURL(file);
			},
			error:function(err){
				console.log(err);
			}
		})
		
	}
</script>