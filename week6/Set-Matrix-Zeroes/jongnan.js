var setZeroes = function (matrix) {
	const m = matrix.length;
	const n = matrix[0].length;

	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | matrix에서 0인 부분을 찾고 0으로 변경될 위치를 다른 배열에|
    | 기록을 해놓은 뒤 마지막에 한번에 0으로 변경               |
    #===========================================================#
    */
	const changedZero = new Array(m).fill(0).map((_) => new Array(n).fill(false));
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (matrix[i][j] === 0) {
				for (let k = 0; k < m; k++) {
					changedZero[k][j] = true;
				}
				for (let k = 0; k < n; k++) {
					changedZero[i][k] = true;
				}
			}
		}
	}
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (changedZero[i][j]) {
				matrix[i][j] = 0;
			}
		}
	}
	/* 
    #===========================================================# 
    | 솔루션 방식 1                                             | 
    |-----------------------------------------------------------|
    | 0인 위치를 따로 저장하고 matrix를 모두 돌아보다가         |
    | 행 혹은 열이 저장되어 있다면 0으로 변경                   |
    | 저장할 때 중복된 row와 col은 제거                         |
    #===========================================================#
    */
	const sr = [];
	const sc = [];
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (matrix[i][j] === 0) {
				if (!sr.includes(i)) sr.push(i);
				if (!sc.includes(j)) sc.push(j);
			}
		}
	}

	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (sr.includes(i) || sc.includes(j)) matrix[i][j] = 0;
		}
	}
};
