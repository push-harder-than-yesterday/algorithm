var reverseList = function (head) {
	///////////////////////////////////////////////
	// 처음 접근 방식
	// 리스트를 돌면서 val만 저장
	// 배열을 거꾸로 돌면서 node들을 생성 및 연결
	// 리스트를 총 두번 돌기 때문에 O(N) 시간 복잡도
	///////////////////////////////////////////////
	if (head === null) return null;

	const values = [head.val];
	let cur = head;
	while (cur.next !== null) {
		cur = cur.next;
		values.push(cur.val);
	}

	let curVal = values.pop();
	const reverse = new ListNode(curVal);
	cur = reverse;
	while (values.length !== 0) {
		curVal = values.pop();
		cur.next = new ListNode(curVal);
		cur = cur.next;
	}

	return reverse;

	///////////////////////////////////////////////////////////////////////////
	// 솔루션 방식 1
	// 현재 노드에서는 이전 노드를 알 수 없으므로 이전 노드들을 저장하면서 바로바로 변경
	// 1 -> 2 -> 3 -> null 일 때, 첫번째 노드인 1의 정보(다음 노드는 무엇인가)를 미리 저장
	// 1의 다음 노드는 2, 이전 노드는 없으므로 null
	// 따라서 1 다음 노드를 이전 노드인 null로 변경하고 다음으로 변경할 노드(2)로 넘어감
	// 반복문을 1번만 돌기 때문에 이전 방법보다 더욱 빠름
	// 시간 복잡도 : O(N)
	///////////////////////////////////////////////////////////////////////////
	let prev = null;
	let cur = head;
	while (cur != null) {
		let next = cur.next;
		cur.next = prev;
		prev = cur;
		cur = next;
	}
	return prev;

	///////////////////////////////////////////////////////////////////////////
	// 솔루션 방식 2
	// 반복문이 아닌 재귀로 노드들을 방문하면서 반대 순서로 저장하기
	///////////////////////////////////////////////////////////////////////////
	// 이해가 가지 않음... 물어볼것!
};
