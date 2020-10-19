//============================================================
// 접근 방법 1
// 수를 num으로 변경하여 계산후 다시 리스트로 만드는 것을 생각했으나
// 길이가 100이므로 숫자로 표현이 안됨.
//============================================================
// var addTwoNumbers = function (l1, l2) {
// 	const a = getNum(l1, 0);
// 	const b = getNum(l2, 0);
// 	const sumNums = a + b;
// 	const digitArr = (sumNums + '')
// 		.split('')
// 		.map((v) => +v)
// 		.reverse();

// 	let idx = 0;
// 	const head = new ListNode(digitArr[idx++]);
// 	let cur = head;
// 	while (idx < digitArr.length) {
// 		cur.next = new ListNode(digitArr[idx++]);
// 		cur = cur.next;
// 	}
// 	return head;
// };

// var getNum = function (list, depth) {
// 	if (list.next === null) return list.val * Math.pow(10, depth);
// 	return getNum(list.next, depth + 1) + list.val * Math.pow(10, depth);
// };

var addTwoNumbers = function (l1, l2) {
	//============================================================
	// 접근 방법 2
	// 리스트를 배열로 변경 후에 두개 배열을 더해 다시 리스트화
	//============================================================
	const l1Arr = list2Arr(l1);
	const l2Arr = list2Arr(l2);

	let sumArr;
	if (l1Arr.length < l2Arr.length) {
		sumArr = sumArrs(l1Arr, l2Arr);
	} else {
		sumArr = sumArrs(l2Arr, l1Arr);
	}

	let idx = 0;
	const head = new ListNode(sumArr[idx++]);
	let cur = head;
	while (idx < sumArr.length) {
		cur.next = new ListNode(sumArr[idx++]);
		cur = cur.next;
	}
	return head;

	//============================================================
	// 접근 방법 3
	// 배열로 바꾸지 않고 바로 리스트에서 덧셈
	// 배열로 변경하고 덧셈을 하는 것보다는 시간은 빨라졌으나
	// 조건의 경우 굉장히 까다롭다.
	//============================================================
	const l1Len = getListLen(l1);
	const l2Len = getListLen(l2);
	if (l1Len < l2Len) return sumLists(l2, l1);
	return sumLists(l1, l2);
};

var getListLen = function (l) {
	let cur = l;
	let dep = 0;
	while (cur !== null) {
		cur = cur.next;
		dep++;
	}
	return dep;
};

var sumLists = function (l1, l2) {
	let cur1 = l1;
	let cur2 = l2;
	let carry = 0;
	while (true) {
		cur1.val += cur2.val + carry;
		if (cur1.val >= 10) {
			carry = Math.floor(cur1.val / 10);
			cur1.val %= 10;
		} else {
			carry = 0;
		}

		//리스트 길이가 같을 경우
		if (cur1.next === null && cur2.next === null) {
			if (carry > 0) {
				cur1.next = new ListNode(carry);
			}
			return l1;
		}
		//짧은 리스트가 존재할 경우
		if (cur2.next === null) {
			break;
		}

		cur1 = cur1.next;
		cur2 = cur2.next;
	}
	while (cur1.next !== null) {
		cur1 = cur1.next;
		if (carry > 0) {
			cur1.val += carry;
			if (cur1.val >= 10) {
				carry = Math.floor(cur1.val / 10);
				cur1.val %= 10;
				if (cur1.next === null) {
					cur1.next = new ListNode(carry);
					break;
				}
				continue;
			}
			break;
		}
		break;
	}
	return l1;
};

var list2Arr = function (l1) {
	const arr = [];
	let cur = l1;
	while (cur !== null) {
		arr.push(cur.val);
		cur = cur.next;
	}
	return arr;
};

var sumArrs = function (a1, a2) {
	a1.forEach((v, i) => {
		a2[i] += v;
	});
	let carry = 0;
	const result = a2.map((v, i, a) => {
		if (v >= 10) {
			if (i + 1 === a.length) {
				carry = Math.floor(v / 10);
			} else {
				a[i + 1] += Math.floor(v / 10);
			}
			return v % 10;
			s;
		}
		return v;
	});
	if (carry > 0) {
		result.push(carry);
	}
	return result;
};
