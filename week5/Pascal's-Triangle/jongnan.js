var generate = function (numRows) {
	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | 2차원 배열을 먼저 초기화 한 뒤 위치에 맞는 값 넣기        |
    #===========================================================#
    */
	const pArr = new Array(numRows).fill(0).map((_, i) => new Array(i + 1).fill(0));

	pArr.forEach((row, i, a) =>
		row.forEach((val, j, b) => {
			if (i < 2 || j === 0 || j === b.length - 1) {
				a[i][j] = 1;
				return;
			}
			a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
		})
	);
	return pArr;
};
