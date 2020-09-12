var myAtoi = function (str) {
	// 처음 접근 방식
	// 우선 양 옆에 공백을 제거 -> 첫 문자가 +,-는 허용 나머지 공간에는 숫자만 허용
	// -> 숫자로 변환 후 isNaN으로 확인 -> int 최대와 최소 확인
	const INT_MAX = Math.pow(2, 31) - 1;
	const INT_MIN = Math.pow(2, 31) * -1;
	let trimed = str.trim();

	let numStr = '';
	if (trimed[0] === '-' || trimed[0] === '+') {
		numStr += trimed[0];
		trimed = trimed.split('').slice(1).join('');
	}
	for (let i = 0; i < trimed.length; i++) {
		if (trimed[i] <= '9' && trimed[i] >= '0') {
			numStr += trimed[i];
		} else break;
	}

	if (isNaN(+numStr)) return 0;
	const num = +numStr;
	if (num < INT_MIN) return INT_MIN;
	if (num > INT_MAX) return INT_MAX;
	return num;
};
