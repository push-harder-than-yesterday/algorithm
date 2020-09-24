var longestCommonPrefix = function (strs) {
	// 처음 접근 방식
	// 제일 작은 문자열을 찾고 그 문자열의 크기만큼 체크
	// 다른 문자가 발견시 이전까지 찾았던 공통 문자열을 리턴

	const sortedStrs = strs.sort((a, b) => a.length - b.length);
	let commonStr = '';
	if (!sortedStrs[0]) return commonStr;
	for (let i = 0; i < sortedStrs[0].length; i++) {
		const curChar = sortedStrs[0][i];
		for (let j = 0; j < sortedStrs.length; j++) {
			if (curChar !== sortedStrs[j][i]) {
				return commonStr;
			}
		}
		commonStr += curChar;
	}
	return commonStr;
};
