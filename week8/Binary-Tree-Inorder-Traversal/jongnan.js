var inorderTraversal = function (root) {
	/////////////////////////////////////////////////////////
	// 접근 방식 1
	//-------------------------------------------------------
	// 왼 -> 루트 -> 오 순으로 출력을 해야되므로
	// 재귀를 통해 왼쪽 자식부터 탐색 후
	// 자신의 값을 배열에 추가
	// 그 후에 오른쪽 자식을 탐색
	/////////////////////////////////////////////////////////
	return inorder(root, []);

	/////////////////////////////////////////////////////////
	// 솔루션 방식 1
	//-------------------------------------------------------
	// 스택을 사용하여 재귀와 똑같은 방식으로 진행
	// 스택에 왼쪽 자식들을 모두 push
	// 왼쪽 자식이 없을 경우 마지막 값부터 결과 배열에 추가
	// 및 pop을 하여 오른쪽 자식을 검사
	// 오른쪽 자식에서 왼쪽 자식이 또 있을 수 있으므로
	// 이전 단계를 똑같이 수행
	/////////////////////////////////////////////////////////
	const res = [];
	const s = [];
	let cur = root;
	while (cur !== null || s.length !== 0) {
		while (cur !== null) {
			s.push(cur);
			cur = cur.left;
		}
		cur = s.pop();
		res.push(cur.val);
		cur = cur.right;
	}
	return res;

	/////////////////////////////////////////////////////////
	// 솔루션 방식 2
	//-------------------------------------------------------
	// Morris Traversal 방식을 이용
	//
	// Morris Traversal?
	// root에서부터 시작하며 null이 아닐때까지 반복
	//
	// 만약 왼쪽 자식이 있다면 왼쪽의 서브 트리에서 가장
	// 오른쪽에 있는 자식을 찾음
	// 그리고 현재 노드를 오른쪽 자식 노드로 설정
	// 현재 노드의 왼쪽은 null로 설정
	// 이후 왼쪽 서브 트리에서 똑같이 반복
	//
	// 왼쪽 자식이 존재하지 않는다면
	// 현재 값을 결과 값에 추가하고 오른쪽 자식을 탐색
	/////////////////////////////////////////////////////////
	const res = [];
	let cur = root;
	while (cur !== null) {
		if (cur.left === null) {
			res.push(cur.val);
			cur = cur.right;
		} else {
			const left = cur.left;
			cur.left = null;
			let subCur = left;
			while (subCur.right !== null) {
				subCur = subCur.right;
			}
			subCur.right = cur;
			cur = left;
		}
	}
	return res;
};

var inorder = function (cur, nums) {
	if (cur === null) return nums;
	if (cur.left !== null) {
		inorder(cur.left, nums);
	}
	nums.push(cur.val);
	if (cur.right !== null) {
		inorder(cur.right, nums);
	}
	return nums;
};
