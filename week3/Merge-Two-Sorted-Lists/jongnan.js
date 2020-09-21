var mergeTwoLists = function (l1, l2) {
	///////////////////////////////////////////////////////////////////////
	// 처음 접근 방식
	// 두 리스트가 정렬되어 있으므로 각 리스트의 포인터를 하나씩 가지고 있고 이를 비교해 나아감
	// 즉, 1->2->4, 1->3->4 가 존재 할 경우 1, 1을 비교
	// 똑같은 수이므로 왼쪽 혹은 오른쪽 리스트에서 값을 가져옴(왼쪽 선택)
	// 결과 값 : 1
	// 2, 1 이므로 1이 작으므로 오른쪽 선택
	// 결과 값 : 1 -> 1
	// 2, 3 비교 2가 작으므로 왼쪽 선택
	// 결과 값 : 1 -> 1 -> 2
	// 두 값이 null이 될 때 까지 반복
	///////////////////////////////////////////////////////////////////////

	let cur1 = l1,
		cur2 = l2;
	let result = null;
	let curR;
	while (cur1 !== null || cur2 !== null) {
		let n;

		if (cur1 === null && cur2 === null) {
			break;
		} else if (cur1 !== null && cur2 === null) {
			n = cur1;
			cur1 = cur1.next;
		} else if (cur1 === null && cur2 !== null) {
			n = cur2;
			cur2 = cur2.next;
		} else {
			if (cur1.val <= cur2.val) {
				n = cur1;
				cur1 = cur1.next;
			} else {
				n = cur2;
				cur2 = cur2.next;
			}
		}

		if (result === null) {
			result = new ListNode(n.val);
			curR = result;
		} else {
			curR.next = new ListNode(n.val);
			curR = curR.next;
		}
	}
	return result;
};
