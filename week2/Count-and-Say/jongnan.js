var countAndSay = function (n) {
	// 처음 접근 방식
	// n번째 문자열(curStr)을 만들때까지 루프
	// 내부에서는 문자의 연속을 알아야하기 때문에 현재 문자열(prevStr)을 루프
	// 이전과 다음 문자를 비교하면서 체크하고 마지막 문자는 안들어가므로 무조건 넣어주기

	let prevStr = '1';
	if (n === 1) return '1';

	let curStr;
	for (let cnt = 1; cnt < n; cnt++) {
		curStr = '';
		let cntOfChar = 1;
		let prev = prevStr[0];
		for (let i = 1; i < prevStr.length; i++) {
			let next = prevStr[i];
			if (prev === next) {
				cntOfChar += 1;
			} else {
				curStr += cntOfChar + prev;
				cntOfChar = 1;
				prev = next;
			}
		}
		curStr += cntOfChar + prev;
		prevStr = curStr;
	}

	return curStr;
};
