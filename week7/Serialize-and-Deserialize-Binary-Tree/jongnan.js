//=========================================================
// 접근 방식 1
//---------------------------------------------------------
// 트리를 배열화하여 이를 스트링으로 바꾼 뒤
// 이를 다시 배열화하여 트리로 변경하는 방식으로 진행하려
// 했으나, 만약 트리가 완전히 편향 트리 즉 한쪽으로 쏠린
// 트리라면 깊이가 1000이 된다.
// 이때 배열화를 한다면 2^1000 + 2^999 ~ + 2^1 개의 배열
// 크기를 가져야 하므로 Heap memory를 다써버리는 오류가
// 발생했다...
//
// 자바스크립트에서는 오브젝트 자체를 스트링으로 바꾸고
// 이를 다시 되돌리는 JSON 객체가 있기에 이를 사용하면
// 바로 풀리나 굉장히 편법같아 다른 방법을 생각해보는 중..
// 이를 스터디때 물어보는게 좋을 것 같음
//=========================================================

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
	//return JSON.stringify(root);
	const arr = tree2Arr(root);
	return arr.reduce((str, val, idx) => {
		str += val === null ? 'null' : val;
		if (idx !== arr.length - 1) str += ',';
		return str;
	}, '');
};

var tree2Arr = function (root) {
	if (root === null) return [];
	const arr = [null, root.val];
	let curDep = 1;
	const q = [];
	q.push([root, 1, curDep + 1]);

	while (q.length !== 0) {
		const [cur, curIdx, nextDep] = q.shift();
		if (curDep !== nextDep) {
			const newDep = new Array(Math.pow(2, nextDep - 1)).fill(null);
			arr.push(...newDep);
			curDep = nextDep;
		}
		const l = curIdx * 2,
			r = curIdx * 2 + 1;
		if (cur.left !== null) {
			arr[l] = cur.left.val;
			q.push([cur.left, l, nextDep + 1]);
		}
		if (cur.right !== null) {
			arr[r] = cur.right.val;
			q.push([cur.right, r, nextDep + 1]);
		}
	}
	for (let i = 0; i < Math.pow(2, curDep - 1); i++) {
		arr.pop();
	}
	return arr;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
	// return JSON.parse(data);
	if (data === '') return null;

	const arr = data.split(',').map((v) => {
		if (v === 'null') return null;
		return +v;
	});

	const trees = arr.map((val) => {
		if (val === null) return null;
		return new TreeNode(val);
	});

	const root = trees[1];
	for (let i = trees.length - 1; i >= 2; i--) {
		if (trees[i] === null) continue;
		const parent = Math.floor(i / 2);
		if (i % 2 === 0) {
			trees[parent].left = trees[i];
		} else {
			trees[parent].right = trees[i];
		}
	}
	return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
