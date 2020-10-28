/////////////////////////////////////////////////////////
// 접근 방식 1
//-------------------------------------------------------
// BFS 방식을 통해 상하좌우 연결된 땅을 검색하고
// 검색된 땅은 표시를 해두어 재탐색 방지
/////////////////////////////////////////////////////////
var numIslands = function (grid) {
	const m = grid.length;
	const n = grid[0].length;
	const visit = new Array(m).fill(0).map((v) => new Array(n).fill(false));
	let cnt = 0;
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (visit[i][j] || grid[i][j] === '0') continue;
			searchLand(grid, visit, i, j, m, n);
			cnt++;
		}
	}
	return cnt;
};

var searchLand = function (grid, visit, r, c, m, n) {
	const dr = [-1, 1, 0, 0];
	const dc = [0, 0, -1, 1];

	const q = [[r, c]];
	visit[r][c] = true;
	while (q.length !== 0) {
		const [curR, curC] = q.shift();
		for (let d = 0; d < 4; d++) {
			const nr = curR + dr[d];
			const nc = curC + dc[d];
			if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
			if (visit[nr][nc] || grid[nr][nc] === '0') continue;
			visit[nr][nc] = true;
			q.push([nr, nc]);
		}
	}
};
