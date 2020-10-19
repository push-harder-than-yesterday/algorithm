//=========================================================
// 접근 방식 1
//---------------------------------------------------------
// 홀수일 경우에는 바로 넘어가고 짝수일 경우에는 리스트의
// 맨 마지막에 새로 붙힌다.
// 이때 짝수의 다음 값을 null로 변경하고 뒤에 붙힌다.
//
// ps..
// 문제를 잘못 이해해서.. 리스트의 밸류를 홀수 짝수로 나누는
// 줄 알았다... 화가 난다..
//=========================================================

var oddEvenList = function (head) {
	if (head === null) return null;
	let tail = head;
	let idx = 0;
	while (tail.next) {
		idx++;
		tail = tail.next;
	}
	idx++;

	if (idx <= 2) return head;

	let cnt = 1;
	let pre = null;
	let cur = head;
	while (cnt <= idx) {
		if (cnt % 2 === 0) {
			pre.next = cur.next;
			cur.next = null;
			tail.next = cur;
			tail = tail.next;
			cur = pre.next;
		} else {
			pre = cur;
			cur = cur.next;
		}
		cnt++;
	}
	return head;
};

//=========================================================
// 솔루션 방식 1
//---------------------------------------------------------
// 기존 head와 evenHead를 나누고 evenHead 짝수 리스트를
// 계속해서 추가한다.
// 마지막에서 head 마지막에 evenHead를 붙힌다.
//=========================================================
var oddEvenList = function (head) {
	if (head === null) return null;
	let odd = head;
	let even = head.next;
	let evenHead = even;
	while (even !== null && even.next !== null) {
		odd.next = even.next;
		odd = odd.next;
		even.next = odd.next;
		even = even.next;
	}
	odd.next = evenHead;
	return head;
};
