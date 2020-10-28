/////////////////////////////////////////////////////////
// 접근 방식 1
//-------------------------------------------------------
// BFS 방식을 통해 같은 레벨인 노드들을 구함
// 이후, 해당 노드들을 엮어 줌
/////////////////////////////////////////////////////////
var connect = function (root) {
	if (root === null) return null;
	const q = [[root, 0]];
	let l = 1;
	while (q.length !== 0) {
		let pre = null;
		while (q.length !== 0 && q[0][1] < l) {
			const [node, lev] = q.shift();
			if (node.left !== null) {
				q.push([node.left, lev + 1]);
			}
			if (node.right !== null) {
				q.push([node.right, lev + 1]);
			}

			// 노드들 엮어주기
			if (pre === null) {
				pre = node;
				continue;
			}
			pre.next = node;
			pre = pre.next;
		}
		l++;
	}
	return root;
};
