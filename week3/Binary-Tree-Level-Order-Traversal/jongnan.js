var levelOrder = function (root) {
	////////////////////////////////////////////////////////////////////
	// 접근 방식 1
	// 모든 tree를 돌 때, 자신의 깊이를 가지고 다니면서 2차원 배열 안에 자신에 위치에 저장
	////////////////////////////////////////////////////////////////////
	return traversal([], root, 0);
};

const traversal = function (arr, node, d) {
	if (node === null) return arr;

	if (arr[d] === undefined) arr.push([]);
	arr[d].push(node.val);
	traversal(arr, node.left, d + 1);
	traversal(arr, node.right, d + 1);

	return arr;
};
