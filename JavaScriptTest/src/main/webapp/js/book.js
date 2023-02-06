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

	td = document.createElement("td");
	let del = document.createElement("input");
	del.setAttribute("type", "button");
	del.value = "삭제";
	td.append(del);
	tr.append(td);

	list.append(tr);
});
//저장버튼 
document.getElementById("save").addEventListener('submit', addBookFnc);
//저장기능
function addBookFnc(evnt) {
	evnt.preventDefault();
	let bCode = document.querySelector("#bookCode").value;
	let bName = document.querySelector("#bookName").value;
	let bAouthor = document.querySelector("#author").value;
	let bPress = document.querySelector("#press").value;
	let bPrice = document.querySelector("#price").value;
	
	
	if (!bCode || !bName || !bAouthor || !bPress || !bPrice) {
		alert('필수 입력값을 확인하세요!');
		return;
	}

	let tr = document.createElement("tr");
	let td = document.createElement("td");
	
		for (let prop in book) {
		td = document.createElement("td");
		td.innerText = book[prop];
		tr.append(td);
	}
}



