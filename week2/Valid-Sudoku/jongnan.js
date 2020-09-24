var isValidSudoku = function (board) {
	// 처음 접근 방식

	// 숫자로 채워진 부분만 3가지의 조건에 부합하는지 확인
	// 가로, 세로, 3*3 구역

	for (let r = 0; r < 9; r++) {
		for (let c = 0; c < 9; c++) {
			if (board[r][c] === '.') continue;

			// 가로, 세로 체크
			for (let i = 0; i < 9; i++) {
				if (r === i || c === i) continue;
				if (board[r][c] === board[i][c] || board[r][c] === board[r][i]) return false;
			}

			const sectionR = 3 * Math.floor(r / 3);
			const sectionC = 3 * Math.floor(c / 3);
			// 3*3 구역 체크
			for (let i = sectionR; i < sectionR + 3; i++) {
				for (let j = sectionC; j < sectionC + 3; j++) {
					if (i === r && j === c) continue;
					if (board[i][j] === '.') continue;
					if (board[i][j] === board[r][c]) return false;
				}
			}
		}
	}
	return true;
};
