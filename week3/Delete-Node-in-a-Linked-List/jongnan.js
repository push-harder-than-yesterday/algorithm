var deleteNode = function (node) {
	// 처음 접근 방식
	// 구조를 살펴보니 node.val은 number type이며, next는 ListNode type

	// 예시 1을 살펴보면 다음과 같은 구조
	// ListNode
	//  val : 4
	//  next : ListNode
	//          val : 5
	//          next : ListNode
	//                  val : 1
	//                  next : ListNode
	//                          val : 9
	//                          next : null

	// 없앨 노드인 5가 주어지면 이를 다음 노드인 1로 변환(next를 통해 1에 접근이 가능)
	node.val = node.next.val;
	node.next = node.next.next;
};
