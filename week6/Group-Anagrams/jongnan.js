var groupAnagrams = function (strs) {
	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | 단어 하나를 선택하고 나머지 단어들과 비교하며 같은 문자로 |
    | 이루어진 단어를 찾는 방식                                 |
    | 2중 for문 및 문자 개수를 비교해야 하므로 시간 초과        |
    #===========================================================#
    */
	// const checked = new Array(strs.length).fill(false);
	// return strs.reduce((res, str, idx) => {
	// 	if (checked[idx]) return res;
	// 	const ana = [str];
	// 	const len = str.length;
	// 	const strMap = str2Map(str);
	// 	for (let i = idx + 1; i < strs.length; i++) {
	// 		if (checked[i]) continue;
	// 		if (strs[i].length !== len) continue;
	// 		const comStrMap = str2Map(strs[i]);
	// 		let isSame = true;
	// 		for (let key of Object.keys(comStrMap)) {
	// 			if (!strMap[key] || strMap[key] !== comStrMap[key]) {
	// 				isSame = false;
	// 				break;
	// 			}
	// 		}
	// 		if (isSame) {
	// 			ana.push(strs[i]);
	// 			checked[i] = true;
	// 		}
	// 	}
	// 	res.push(ana);
	// 	return res;
	// }, []);

	/* 
    #===========================================================# 
    | 접근 방식 2                                               | 
    |-----------------------------------------------------------|
    | 단어에서의 문자들을 정렬했을 때 아나그램인 문자들을 똑같은|
    | 문자가 되므로 단어들을 모두 정렬하고 원래 문자열과 저장   |
    | 단어들을 모아둔 배열도 정렬(정렬한 문자 기준)하여         |
    | 다른 단어가 나왔을 시 이전 단어들을 모두 한 묶음으로 묶어 |
    | 배열에 추가                                               |
    #===========================================================#
    */
	const sorted = strs
		.map((str) => [str, str.split('').sort().join('')])
		.sort((a, b) => {
			if (a[1] < b[1]) return -1;
			else if (a[1] > b[1]) return 1;
			else return 0;
		});
	let temp = '0';
	let arr = [];
	return sorted.reduce((res, [origin, sortedStr], idx) => {
		if (temp !== sortedStr) {
			if (arr.length !== 0) res.push(arr);
			temp = sortedStr;
			arr = [origin];
		} else {
			arr.push(origin);
		}
		if (idx === sorted.length - 1) {
			res.push(arr);
		}
		return res;
	}, []);

	/* 
    #===========================================================# 
    | 솔루션 방식 1                                             | 
    |-----------------------------------------------------------|
    | 단어가 소문자이기 때문에 #0#0#0...#0 -> #0이 26개인       |
    | 문자열로 나타낼 수 있음                                   |
    | 각 단어마다 #0#0#0...#0 포맷으로 변경 및 해시맵으로 관리  |
    #===========================================================#
    */
	return Object.values(
		strs.reduce((res, str) => {
			const alpha = new Array(26).fill(0);
			str.split('').forEach((c) => {
				const idx = c.charCodeAt(0) - 97;
				alpha[idx]++;
			});
			const curStr = '#' + alpha.join('#');
			if (!res[curStr]) {
				res[curStr] = [str];
			} else {
				res[curStr].push(str);
			}
			return res;
		}, {})
	);
};

var str2Map = function (str) {
	return str.split('').reduce((m, v) => {
		if (!m[v]) {
			m[v] = 1;
		} else {
			m[v] += 1;
		}
		return m;
	}, {});
};
