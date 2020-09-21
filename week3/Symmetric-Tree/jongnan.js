/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function (root) {
	////////////////////////////////////////////////////////////////////
	// 접근 방식 1
	// 중위 순회를 돌면서 이들을 배열에 저장
	// 저장된 배열을 보게 되면 1번 예시와 같이 트리가 루트를 기준으로 대칭이라면 배열도 동일
	// 예시1 중위순회 : 3 2 4 1 4 2 3
	// 예시2 중위순회 : 2 3 1 2 3
	//
	// 중위순회의 문제점 발견
	// 테케 중 다음과 같은 트리가 존재
	//            5
	//           / \
	//          4   1
	//           \   \
	//            1   4
	//           /   /
	//          2   2
	// 이를 중위 순회로 나타낼 시에는
	// 4 2 1 5 1 2 4 로 통과
	// 다른 방법을 생각할 시간...
	////////////////////////////////////////////////////////////////////

	const inOrderedTree = inOrder(root, []);
	const len = Math.floor(inOrderedTree.length / 2);
	console.log(inOrderedTree);
	for (let i = 0; i < len; i++) {
		if (inOrderedTree[i] !== inOrderedTree[inOrderedTree.length - 1 - i]) return false;
	}
	return true;

	////////////////////////////////////////////////////////////////////
	// 접근 방식 2
	// 트리를 배열에 깊이별로 저장
	// 예제 1을 배열에 넣어보면 1 2 2 3 4 4 3
	// 이제 깊이 별로 비교
	// 0        ->  1
	// 1 ~ 2    -> 2, 2 비교
	// 3 ~ 6    -> 3,4,4,3 비교
	// 깊이 별로 배열을 넣어야 하므로 너비우선탐색(BFS)를 선택
	//
	// 문제 발견
	// 만약 같은 레벨에 null 또한 주어지지 않았다면 채워 넣어야 함
	// 하지만 BFS로만은 그것이 불가능
	////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////
	// 접근 방식 3
	// 트리를 배열에 깊이별로 저장을 하지만 탐색은 DFS로 탐색하며 배열도 미리 생성
	// 새로운 높이를 찾을 때마다 null을 높이만큼 추가하고 이를 변경하는 식
	// 전역 배열을 사용하고 모든 배열을 만들어가므로 시간이 너무 오래 걸림
	////////////////////////////////////////////////////////////////////
	arr = [];
	treeToArr(root, 1, 0);
	let i = 1;
	while (i <= floor) {
		const s = Math.pow(2, i - 1) - 1;
		const len = s + Math.pow(2, i - 1);
		const sub = arr.slice(s, len);
		for (let j = 0; j < Math.floor(sub.length / 2); j++) {
			if (sub[j] !== sub[sub.length - 1 - j]) return false;
		}
		i++;
	}
	return true;

	////////////////////////////////////////////////////////////////////
	// 솔루션 방식 1
	// 분할 정복을 통해 이를 확인
	////////////////////////////////////////////////////////////////////
	return isMirror(root, root);
};

const isMirror = function (t1, t2) {
	if (t1 === null && t2 === null) return true;
	if (t1 === null || t2 === null) return false;
	return t1.val === t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
};

let arr = [];
let floor = 0;

const treeToArr = function (node, d, p) {
	if (node === null) return;
	addArrayFromDep(d);
	floor = Math.max(d, floor);
	arr[p] = node.val;
	treeToArr(node.left, d + 1, p * 2 + 1);
	treeToArr(node.right, d + 1, p * 2 + 2);
};

const addArrayFromDep = function (d) {
	let len = 0;
	for (let i = 0; i < d; i++) {
		len += Math.pow(2, i);
	}
	if (arr.length <= len) {
		const addArr = new Array(len - arr.length);
		addArr.fill(null);
		arr = [...arr, ...addArr];
	}
};

const BFS = function (start) {
	const q = [];
	q.push(start);

	const arr = [];

	while (q.length !== 0) {
		const curNode = q.shift();
		if (curNode === null) {
			arr.push(null);
			continue;
		}
		arr.push(curNode.val);
		q.push(curNode.left, curNode.right);
	}
	return arr;
};

const inOrder = function (node, arr) {
	if (node === null) return arr;

	if (node.left === null && node.right !== null) arr.push(null);
	inOrder(node.left, arr);
	arr.push(node.val);
	if (node.left !== null && node.right === null) arr.push(null);
	inOrder(node.right, arr);

	return arr;
};
