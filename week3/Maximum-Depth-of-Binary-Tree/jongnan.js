var maxDepth = function (root) {
	//////////////////////////
	// 처음 접근 방식
	// DFS를 통해 최대 깊이를 확인
	//////////////////////////

	// 루트가 존재하지 않으면 0
	if (root === null) return 0;

	// DFS를 root부터 실행
	return dfs(root, 1);
};

const dfs = function (cur, d) {
	// 현재 노드가 없을 경우 해당 노드의 깊이는 저장되면 안되므로 -1을 반환하여 비교할때 무시 되도록 함
	if (cur === null) return -1;
	// 자식이 없을 경우에는 끝이므로 현재 깊이를 반환
	if (cur.left === null && cur.right === null) return d;
	// left에 접근
	const l = dfs(cur.left, d + 1);
	// right에 접근
	const r = dfs(cur.right, d + 1);
	// 현재 d, l로 접근했을 때 가장 큰 수, r로 접근했을 때 가장 큰 수
	return Math.max(d, l, r);
};
