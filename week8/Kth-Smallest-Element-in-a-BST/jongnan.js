/////////////////////////////////////////////////////////
// 접근 방식 1
//-------------------------------------------------------
// BST의 특징을 살려서 inorder 순으로 트리를 순회한다면
// 작은 노드 밸류 순으로 정렬이 가능
/////////////////////////////////////////////////////////
var kthSmallest = function (root, k) {
	const inorderArr = getInorder(root, []);
	return inorderArr[k - 1];
};

var getInorder = function (cur, arr) {
	if (cur === null) return arr;
	if (cur.left !== null) {
		getInorder(cur.left, arr);
	}
	arr.push(cur.val);
	if (cur.right !== null) {
		getInorder(cur.right, arr);
	}
	return arr;
};
