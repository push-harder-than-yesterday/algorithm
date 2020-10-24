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
	// const arr = tree2Arr(root);
	// return arr.reduce((str, val, idx) => {
	// 	str += val === null ? 'null' : val;
	// 	if (idx !== arr.length - 1) str += ',';
	// 	return str;
	// }, '');
	const str = convertTreeToStr(root, '');
	console.log(str);
};

var convertTreeToStr = function (node, str) {
	if (node === null) return '';
	str += `{ val:${node.val}`;
	if (node.left !== null) {
		str += `,left:${convertTreeToStr(node.left, str)}`;
	}
	if (node.right !== null) {
		str += `,right:${convertTreeToStr(node.right, str)}`;
	}
	return (str += '}');
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

//=========================================================
// 접근 방식 2
//---------------------------------------------------------
// 트리 노드를 깊이 우선 탐색을 통해 스트링으로 변경
// [1,2,3,null,null,4,5] ->
//                  {v:1,l:{v:2},r:{v:3,l:{v:4},r:{v:5}}}
// 이를 파싱하면서 다시 트리 노드로 변경
// 파싱시에도 dfs 이용
//=========================================================
/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
	return convertTreeToStr(root, '');
};

var convertTreeToStr = function (node, str) {
	if (node === null) return '';
	let nodeStr = `{v:${node.val}`;
	if (node.left !== null) {
		nodeStr += `,l:${convertTreeToStr(node.left, str)}`;
	}
	if (node.right !== null) {
		nodeStr += `,r:${convertTreeToStr(node.right, str)}`;
	}
	nodeStr += '}';
	return (str += nodeStr);
};

var convertStrToTree = function (str) {
	const inner = str.substring(1, str.length - 1);

	// 첫번째 컴마 검색
	const fci = findNextComma(0, inner);
	// 컴마를 조사할 때 컴마가 존재하지 않는다면 스트링 길이를 반환
	const curVal = +inner.substring(0, fci).split(':')[1];
	const cur = new TreeNode(curVal);

	// 첫번째 컴마가 없다면 자식이 없으므로 바로 리턴
	if (inner[fci] === undefined || inner[fci] !== ',') return cur;

	// 오른쪽 자식만 존재할 때
	if (inner[fci + 1] === 'r') {
		const rEndIdx = sliceChildNode(fci + 3, inner);
		const r = inner.substring(fci + 3, rEndIdx + 1);
		cur.right = convertStrToTree(r);
		return cur;
	}

	//왼쪽 자식 탐색
	const lEndIdx = sliceChildNode(fci + 3, inner);
	const l = inner.substring(fci + 3, lEndIdx + 1);
	cur.left = convertStrToTree(l);

	//또다른 컴마가 존재한다면 오른쪽 자식이 존재
	const sci = findNextComma(lEndIdx, inner);

	//없다면 바로 리턴
	if (!inner[sci] === undefined || inner[sci] !== ',') return cur;

	//오른쪽 자식 탐색
	const rEndIdx = sliceChildNode(sci + 3, inner);
	const r = inner.substring(sci + 3, rEndIdx + 1);
	cur.right = convertStrToTree(r);

	return cur;
};

//자식의 노드를 탐색
//탐색시 자식의 자식의 노드도 존재할 수 있으므로 스택을 이용하여 스택에 아무 값도 없을 때까지 진행
var sliceChildNode = function (start, str) {
	let end = start;
	const s = [str[start]];
	while (end < str.length) {
		end++;
		if (str[end] === '{') s.push(str[end]);
		else if (str[end] === '}') {
			if (s[s.length - 1] === '{') {
				s.pop();
			}
		}
		if (s.length === 0) break;
	}
	return end;
};

var findNextComma = function (i, str) {
	let j = i;
	while (j < str.length) {
		if (str[j] === ',') return j;
		j++;
	}
	return j + 1;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
	if (data === '') return null;
	return convertStrToTree(data);
};
