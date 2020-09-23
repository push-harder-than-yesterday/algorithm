var hasCycle = function (head) {
	/* 
    #============================================================# 
    | 처음 접근 방식                                             | 
    |------------------------------------------------------------|
    | 노드들을 하나씩 저장해 놓고 해당 노드가 다시 나오는지 확인 |
    #============================================================# 
    */
	const nodeSet = new Set();
	while (head !== null) {
		if (nodeSet.has(head)) {
			return true;
		} else {
			nodeSet.add(head);
		}
		head = head.next;
	}
	return false;

	/*
    #============================================================# 
    | 솔루션 접근 방식                                           | 
    |------------------------------------------------------------|
    | 두개의 포인터를 사용                                       |
    | 첫번째 포인터는 한칸씩 가는 포인터이며,                    |
    | 두번째 포인터는 두칸씩 가는 포인터                         |
    | 만약, 순환되는 리스트라면 언젠가는 만나게 되어있음         |
    #============================================================# 
    */
	if (head === null || head.next === null) return false;
	let slow = head;
	let fast = head.next;
	while (slow !== fast) {
		if (fast === null || fast.next === null) return false;
		slow = slow.next;
		fast = fast.next.next;
	}
	return true;
};
