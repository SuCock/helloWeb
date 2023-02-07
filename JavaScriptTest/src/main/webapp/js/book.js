/**
 * 
 */

// bookList배열을 활용해서 처리하도록 하세요.

let bookList = [
	{ bookCode: 'P0206001', bookTitle: '이것이자바다', bookAuthor: '홍성문', bookPress: '신흥출판사', bookPrice: '20000' },
	{ bookCode: 'P0206002', bookTitle: '이것이자바스크립트다', bookAuthor: '홍영웅', bookPress: '우리출판사', bookPrice: '25000' },
]
// 데이터 출력	

bookList.forEach(function(book) {
	let tr = document.createElement("tr");
	let td = document.createElement("td");

	let chk = document.createElement("input");
	chk.setAttribute("type", "checkbox");
	chk.setAttribute("class", "checklist");
	td.append(chk);
	tr.append(td);


	for (let prop in book) {
		td = document.createElement("td");
		td.innerText = book[prop];
		tr.append(td);
	}
	//삭제버튼, 삭제기능
	td = document.createElement("td");
	let del = document.createElement("input");
	del.setAttribute("type", "button");
	del.addEventListener("click", delFnc)
	del.value = "삭제";
	td.append(del);
	tr.append(td);


	list.append(tr);
});
function delFnc(ev) {
	ev.target.parentElement.parentElement.remove();
}
//저장버튼 
document.getElementById("save").addEventListener('click', addBookFnc);
//저장기능
function addBookFnc() {
	let tr = document.createElement("tr");
	let td = document.createElement("td");
	let bCode = document.querySelector("#bookCode").value;
	let bName = document.querySelector("#bookName").value;
	let bAouthor = document.querySelector("#author").value;
	let bPress = document.querySelector("#press").value;
	let bPrice = document.querySelector("#price").value;

	let chk = document.createElement("input");
	chk.setAttribute("type", "checkbox");
	chk.setAttribute("class", "checklist");
	td.append(chk);
	tr.append(td);

	td = document.createElement("td");
	td.append(bCode);
	tr.append(td);

	td = document.createElement("td");
	td.append(bName);
	tr.append(td);

	td = document.createElement("td");
	td.append(bAouthor);
	tr.append(td);

	td = document.createElement("td");
	td.append(bPress);
	tr.append(td);

	td = document.createElement("td");
	td.append(bPrice);
	tr.append(td);

	td = document.createElement("td");
	let del = document.createElement("input");
	del.setAttribute("type", "button");
	del.addEventListener("click", delFnc)
	del.value = "삭제";
	td.append(del);
	tr.append(td);

	if (!bCode || !bName || !bAouthor || !bPress || !bPrice) {
		alert('필수 입력값을 확인하세요!');
		return;
	}
	list.append(tr);
}
//전체체크기능
//1.title 아래의  input 박스찾기
//2.checkbox=true가 되면 list아래에 있는 체크박스들이 true(check.checked == true)

check.addEventListener("change", checkBoxFnc);
function checkBoxFnc() {
	let check = document.getElementById("check");
	let list = document.querySelectorAll("#list input[type='checkbox']")
	if (check.checked == true) {
		list.forEach((c) => {
			c.checked = true;
		})
	}
	else {
		list.forEach((c) => {
			c.checked = false;
		});
	}
};

//3.false면 다 false

//선택 삭제를 누르면 선택된 데이터 삭제(이벤트 실행)
checkDel.addEventListener("click", checkBoxDelFnc);
function checkBoxDelFnc() {
	let list = document.querySelectorAll("#list input[type='checkbox']:checked")
	for(let i = 0; i<list.length; i++){
		list[i].parentElement.parentElement.remove();
	}

}
//list안에 checked된 체크박스를 가져온다.
//삭제를 눌렀을 때 삭제.
