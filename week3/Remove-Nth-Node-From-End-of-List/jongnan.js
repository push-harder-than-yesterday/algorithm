var removeNthFromEnd = function (head, n) {
	/////////////////////////////////////////////
	// 처음 접근 방식
	// 맨 마지막 접근까지 가면서 해당 정보들을 배열에 저장
	// 배열의 뒤에서 N번째 노드를 삭제
	/////////////////////////////////////////////

	const nodes = [head];
	let curNode = head;
	while (true) {
		if (curNode.next === null) break;
		curNode = curNode.next;
		nodes.push(curNode);
	}
	const preNode = nodes[nodes.length - n - 1];
	const deleteNode = nodes[nodes.length - n];
	const nextNode = nodes[nodes.length - n + 1];
	// 삭제 노드가 맨 앞 노드일 경우
	if (preNode === undefined && nextNode !== undefined) {
		deleteNode.val = nextNode.val;
		deleteNode.next = nextNode.next;
	}
	// 삭제 노드가 중간에 낀 노드일 경우
	else if (preNode !== undefined && nextNode !== undefined) {
		preNode.next = nextNode;
	}
	// 삭제 노드가 마지막 노드일 경우
	else if (preNode !== undefined && nextNode === undefined) {
		preNode.next = null;
	}
	// 앞 뒤 노드가 존재하지 않을 경우(혼자만 있을 경우)
	else {
		head = null;
	}
	return head;

	//////////////////////////////////////////////////////////////////
	// 솔루션 방식 1
	// 더미 노드를 하나 만들어 맨 앞에 추가
	// 1,2,3,4,5 가 있다면 dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null 인셈
	// 리스트 전체를 돌면서 몇개가 존재하는지 확인 후
	// 지워야할 노드를 찾아 삭제
	// 마지막엔 더미 노드의 next를 반환
	//////////////////////////////////////////////////////////////////

	const dummyNode = new ListNode(0);
	dummyNode.next = head;
	let listLen = 0;
	let cur = head;
	while (cur != null) {
		listLen++;
		cur = cur.next;
	}
	listLen -= n;
	cur = dummyNode;
	while (listLen > 0) {
		listLen--;
		cur = cur.next;
	}
	cur.next = cur.next.next;
	return dummyNode.next;

	////////////////////////////////////////////////////////////////////
	// 솔루션 방식 2
	// 1번 방식은 cur이라는 포인터를 하나만 사용
	// 2번 방식은 2개의 포인터를 사용하여 길이를 측정하지 않고도 뒤에서 N번째 노드를 삭제
	// 시작은 더미 노드를 생성하고 포인터 두개에 할당
	// 앞 포인터를 N + 1만큼 전진(더미 노드로 인해 1 증가)
	// 앞 포인터가 끝까지 도달할때까지 두개의 포인터를 전진
	// 뒷 포인터의 다음 노드가 삭제할 노드
	////////////////////////////////////////////////////////////////////

	const dummyNode = new ListNode(0);
	dummyNode.next = head;
	let f = dummyNode,
		s = dummyNode;
	for (let i = 0; i < n + 1; i++) {
		f = f.next;
	}

	while (f != null) {
		f = f.next;
		s = s.next;
	}

	s.next = s.next.next;
	return dummyNode.next;
};
