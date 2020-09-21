var isValidBST = function (root) {
	/////////////////////////////////////////////////////////////////////////////////
	// 처음 접근 방식
	// DFS로 모든 노드를 탐색을 기본적으로 하면서 현재 노드의 부모 노드가 아닌 조상들을 저장하면서 탐색
	// 이는 다음과 같은 예시를 들 수 있음
	//      5
	//     / \
	//    1   6
	//       / \
	//      3   7
	// 다음과 트리가 있을 때, 3을 봐보자
	// 3은 6보다 작으니 기본적인 조건은 만족하였으나, 5의 오른쪽 트리에 존재하므로 무조건 5보다는 커야함
	// 따라서 5를 저장해놓고 6보다 작고 5보다 큰지를 확인
	// 또한, 조상이 자신보다 오른쪽에 있는지 왼쪽에 있는지 넣어야함
	/////////////////////////////////////////////////////////////////////////////////
	return dfs(root, []);

	/////////////////////////////////////////////////////////////////////////////////
	// 솔루션 접근 방식 1
	// 처음 접근 방식과 기본적으로 비슷하나 조상들을 전부 가지고 가는 것이 아닌 해당 서브트리에서 최저값과
	// 최대값을 가지고 다니면서 비교
	// 조상들의 개수만큼 비교하지 않아도 되므로 기존 방식보다 더 빠름
	/////////////////////////////////////////////////////////////////////////////////
	return dfs2(root, null, null);

	/////////////////////////////////////////////////////////////////////////////////
	// 솔루션 접근 방식 2
	// 중위 순회(left -> cur -> right)를 통해 확인
	// BST의 경우 중위 순회를 돌 때, 이전 값은 다음 값 보다 무조건 작음
	// 이 특성을 이용하여 BST인지 확인
	//      5
	//     / \
	//    1   6
	//       / \
	//      3   7
	// 다음과 같은 트리가 존재할 때 중위 순회를 한다면, 1->5->3->6->7
	// 따라서 다음 트리는 BST X
	/////////////////////////////////////////////////////////////////////////////////
	const inOrderArr = inOrder(root, []);
	if (inOrderArr.length === 0) return true;
	let pre = inOrderArr[0];
	for (let i = 1; i < inOrderArr.length; i++) {
		if (pre >= inOrderArr[i]) return false;
		pre = inOrderArr[i];
	}
	return true;
};

const dfs = function (cur, anc) {
	// 현재 노드가 존재하지 않는다면 바로 리턴
	if (cur === null) return true;
	// 조상 확인
	for (let i = 0; i < anc.length; i++) {
		const [ancVal, isLeft] = anc[i];
		// 조상이 왼쪽에 있을 때는 자신이 무조건 커야됨
		if (isLeft && cur.val <= ancVal) return false;
		// 조상이 오른쪽에 있을 때는 자신이 무조건 작아야함
		if (!isLeft && cur.val >= ancVal) return false;
	}

	// 왼쪽 자식들은 조상들이 오른쪽에 존재
	anc.push([cur.val, false]);
	const l = dfs(cur.left, anc);
	anc.pop();

	// 오른쪽 자식들은 조상들이 왼쪽에 존재
	anc.push([cur.val, true]);
	const r = dfs(cur.right, anc);
	anc.pop();

	// 모든 결과 값이 조건을 만족해야지만 BST이기 때문에 && 연산자로 묶어줌
	return l && r;
};

const dfs2 = function (cur, lower, upper) {
	if (cur === null) return true;

	if (lower !== null && cur.val <= lower) return false;
	if (upper !== null && cur.val >= upper) return false;
	if (!dfs2(cur.left, lower, cur.val)) return false;
	if (!dfs2(cur.right, cur.val, upper)) return false;
	return true;
};

const inOrder = function (cur, route) {
	if (cur === null) return route;
	const l = inOrder(cur.left, route);
	route.push(cur.val);
	const r = inOrder(cur.right, route);
	return route;
};
