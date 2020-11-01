/////////////////////////////////////////////////////////
// 접근 방식 1
//-------------------------------------------------------
// BFS 방식을 사용하여 해결
// queue 안에 같은 레벨에 있는 노드들을 모두 빼고
// 뺀 노드들의 자식들을 다음 레벨로 설정하고 큐에 넣음
// 홀수번째로 들어갈 같은 레벨의 노드들은 뒤집어서 넣어야
// 하기 때문에 reverse 메소드를 사용
/////////////////////////////////////////////////////////
var zigzagLevelOrder = function (root) {
	if (root === null) return [];
	const res = [];
	const q = [];
	q.push([root, 0]);
	let l = 1;

	while (q.length !== 0) {
		const curLev = [];
		while (q.length !== 0 && q[0][1] < l) {
			const [cur, curL] = q.shift();
			if (cur.left !== null) q.push([cur.left, l]);
			if (cur.right !== null) q.push([cur.right, l]);
			curLev.push(cur.val);
		}

		if (res.length % 2 === 1) {
			curLev.reverse();
		}
		res.push(curLev);

		l++;
	}
	return res;
};
