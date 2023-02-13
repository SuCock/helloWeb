/**
 * manage.js
 */
console.log("manage.js start.....");
function updateMemberFnc(e) {
	// modifyMember.do 사용자 정보 수정.
	let tr = $(e.target).parent().parent(); // tr과 같다.
	//console.log(tr.find('td:nth-of-typd(2) input').val());
	let id = tr.children().eq(0).text();
	let name = tr.find('td:nth-of-type(2) input').val()
	let phone = tr.find('td:nth-of-type(3) input').val()
	let addr = tr.find('td:nth-of-type(4) input').val()
	let res = tr.find('td:nth-of-type(5) input').val()

	$.ajax({
		url: 'updateMember.do',
		method: 'post',
		data: { id: id, name: name, phone: phone, addr: addr, res: res },
		success: function(result) {
			// 처리된 정보를 화면에 생성.
			console.log(result);
			if (result.retCode == 'Success') {
				tr.replaceWith(makeRow(result.member)); // 새로운 tr로 만들어주는 애.
			} else {
				alert("입력미완!");
			}

		},
		error: function(error) {
			console.log(error);
		}

	})

} // end of updateMemberFnc.
function makeRow(member = {}) { //  member값을 하나 가져온다. ={}은 배열.
	let tr = $('<tr />'); // document.createElement('tr');
	tr.on('dblclick', function(e) {  // 더블클릭하면 수정할 수 있게.
		let id = $(this).children().eq(0).text(); // eq.(i) 가지고 온 하위요소 중에서 i번째 값.
		let name = $(this).children().eq(1).text();
		let phone = $(this).children().eq(2).text();
		let addr = $(this).children().eq(3).text();
		let resp = $(this).children().eq(4).text();

		let nTr = $('<tr />').append(
			$('<td />').text(id), // id는 못바꾸도록.
			$('<td />').append($('<input />').val(name)),
			$('<td />').append($('<input />').val(phone)),
			$('<td />').append($('<input />').val(addr)),
			$('<td />').append($('<input />').val(resp)),
			$('<td />').append($('<button class="btn btn-primary" onclick="updateMemberFnc(event)">수정</button>'))
		)
		nTr = $('#template tr').clone(true);
		nTr.find('input.name').val(name);
		// 새로운 tr로 가존 tr을 대신.
		$(this).replaceWith(nTr);
	})
	tr.append(
		$('<td />').text(member.memberId),
		$('<td />').text(member.memberName),
		$('<td />').text(member.memberPhone),
		$('<td />').text(member.memberAddr),
		$('<td />').text(member.responsibility),
		$('<td />').append($('<button class="btn btn-warning">삭제</button>').attr('mid', member.memberId).on('click', deleteMemberFnc))  // 이름만 있어야 한다. 실행을 넣으면 생성되면서 이벤트가 진해되어 버린다.
	);
	return tr;
}

function deleteMemberFnc(e) {

	if (!window.confirm('삭제하시겠습니까?')) {
		return;
	}

	let user = $(e.target).attr('mid');

	$.ajax({
		url: 'removeMember.do',
		data: { id: user },
		success: function(result) {
			console.log(result);
			if (result.retCode == 'Success') {
				$(e.target).parent().parent().remove();
			} else {
				alert('처리 안됨!!');
			}
		},
		error: function(reject) {
			console.log(reject);
		}

	});

} // end of deleteFnc.

$(document).ready(function() {   // document의 사용준비가 되어지면 실행. 실행시점 때문에. 페이지를 먼저 다 읽고 스크립트 실행.
	
	let clone = $('#template').clone(true);
	console.log(clone.find('tr'));
	let tr = clone.find('tr');
	tr.find('.name').val('test'); // 클래스가 네임인 tr에 test내용을 넣겠다.
	$('#list').append(tr);
	
	
	// 목록가져오는 Ajax 호출.
	console.log($('#list'));
	$.ajax({
		url: 'memberList.do',
		success: function(result) {
			//console.log(result);
			$(result).each(function(idx, item) {
				$('#list').append(makeRow(item));

			})
		},
		error: function(reject) {
			console.log(reject);
		}
	});

	// 등록이벤트.
	$("#addBtn").on("click", function() {
		let id = $('#mid').val(); // element.value 속성읽어오기.
		let name = $('#mname').val();
		let phone = $('#mphone').val();
		let addr = $('#maddr').val();
		let image = $('#mimage')[0].files[0];

		let formData = new FormData();
		formData.append("id", id);
		formData.append("name", name);
		formData.append("phone", phone);
		formData.append("addr", addr);
		formData.append("image", image);

		$.ajax({
			url: 'addMember.do',
			method: 'post',
			data: formData,
			contentType: false, // multi타입.
			processData: false,
			success: function(result) {
				// 처리된 정보를 화면에 생성.
				console.log(result);
				if (result.retCode == 'Success') {
					$('#list').append(makeRow(result.member)); // 데이터를 주면 tr로 만들어서 반환해주는 애.
				} else {
					alert("입력미완!");
				}

			},
			error: function(error) {
				console.log(error);
			}
		})

	})



});



