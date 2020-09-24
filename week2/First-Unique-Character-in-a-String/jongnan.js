var firstUniqChar = function (s) {
	// 처음 접근 방식
	// 각 문자마다 몇개가 등장하는지 확인 후, 문자들을 돌면서 몇 번째 문자가 한개만 나왔는지 확인

	const strMap = s.split('').reduce((map, char) => {
		if (!map[char]) {
			map[char] = 1;
		} else {
			map[char] += 1;
		}
		return map;
	}, {});
	for (let i = 0; i < s.length; i++) {
		if (strMap[s[i]] === 1) {
			return i;
		}
	}
	return -1;
};
