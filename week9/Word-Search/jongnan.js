/*////////////////////////////////////////////////////////////////
풀이 방식
------------------------------------------------------------------
DFS를 사용하여 board 탐색

재귀를 통해 DFS를 구현한다.
탐색의 시작은 단어의 시작 문자인 곳에서만 확인하면 된다.
움직일 수 있는 방향은 세로와 가로 즉 상하좌우이다.
따라서 다음 위치가 이미 방문한 곳이였는지, 다음 단어의 문자와
같은 곳인지, board의 범위를 벗어나는지 확인 한 뒤 탐색한다.

만약 현재 탐색하고 있는 깊이와 단어의 길이가 같다면 해당
단어가 존재하는 것이므로 탐색을 종료한다.
단어가 존재한다면 다음 탐색들은 모두 무의미하므로 탐색을 
중지한다.
////////////////////////////////////////////////////////////////*/
var exist = function (board, word) {
	let isPass = false;
	const visit = new Array(board.length).fill(0).map((_) => new Array(board[0].length).fill(false));
	for (let i = 0; i < board.length; i++) {
		for (let j = 0; j < board[i].length; j++) {
			//만약 단어를 찾았을 경우 탐색이 무의미
			if (isPass) return isPass;
			//단어의 첫 문자와 비교
			if (board[i][j] !== word[0]) continue;
			visit[i][j] = true;
			isPass = searchWord(board, word, visit, i, j, 1, false);
			//백트래킹
			visit[i][j] = false;
		}
	}
	return isPass;
};

//다음 위치를 반환하는 함수
var getNextDir = function (n, r, c) {
	const dr = [-1, 1, 0, 0];
	const dc = [0, 0, -1, 1];
	return [dr[n] + r, dc[n] + c];
};

//DFS
var searchWord = function (board, word, visit, r, c, dep, isPossible) {
	//깊이와 단어의 길이가 같다면 단어가 존재
	if (word.length === dep) {
		isPossible = true;
	}
	for (let i = 0; i < 4; i++) {
		//단어가 존재한다면 이후 탐색은 무의미
		if (isPossible) return isPossible;
		const [nr, nc] = getNextDir(i, r, c);

		//다음 위치가 유효한 위치인지 판단
		// 1.board 안에 존재하는지
		if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
		// 2.이미 방문했는지, 다음 문자가 적절한지
		if (visit[nr][nc] || board[nr][nc] !== word[dep]) continue;
		visit[nr][nc] = true;
		isPossible = searchWord(board, word, visit, nr, nc, dep + 1, isPossible);
		//백트래킹
		visit[nr][nc] = false;
	}
	return isPossible;
};
