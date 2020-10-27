/////////////////////////////////////////////////////////
// 접근 방식 1
//-------------------------------------------------------
// preorder에서는 현재 서브 트리 안에서 루트가 먼저
// 오므로 preorder에서 하나씩 빼서 사용
// inorder를 보고 루트 노드의 왼쪽 서브 트리와 오른쪽 서브
// 트리를 나누고 이를 현재 노드의 자식으로 설정
/////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////
// 리팩토링 후
/////////////////////////////////////////////////////////
var buildTree = function (preorder, inorder) {
	if (preorder.length === 0) return null;
	const root = new TreeNode(preorder.shift());
	const idx = inorder.indexOf(root.val);
	const l = inorder.slice(0, idx);
	if (l.length !== 0) {
		root.left = buildTree(preorder, l);
	}
	const r = inorder.slice(idx + 1);
	if (r.length !== 0) {
		root.right = buildTree(preorder, r);
	}
	return root;
};

/////////////////////////////////////////////////////////
// 리팩토링 전
/////////////////////////////////////////////////////////
var buildTree = function (preorder, inorder) {
	if (preorder.length === 0) return null;
	const root = new TreeNode(preorder.shift());
	const rootIdx = inorder.indexOf(root.val);
	makeTree(preorder, root, inorder.slice(0, rootIdx), inorder.slice(rootIdx + 1));
	return root;
};

var makeTree = function (pre, cur, left, right) {
	if (left.length !== 0) {
		if (pre.length === 0) return;
		const leftRoot = new TreeNode(pre.shift());
		cur.left = leftRoot;
		const leftRootIdx = left.indexOf(leftRoot.val);
		const leftL = left.slice(0, leftRootIdx);
		const leftR = left.slice(leftRootIdx + 1);
		if (leftL.length !== 0 || leftR.length !== 0) {
			makeTree(pre, leftRoot, leftL, leftR);
		}
	}

	if (right.length !== 0) {
		if (pre.length === 0) return;
		const rightRoot = new TreeNode(pre.shift());
		cur.right = rightRoot;
		const rightRootIdx = right.indexOf(rightRoot.val);
		const rightL = right.slice(0, rightRootIdx);
		const rightR = right.slice(rightRootIdx + 1);
		if (rightL.length !== 0 || rightR.length !== 0) {
			makeTree(pre, rightRoot, rightL, rightR);
		}
	}
};
