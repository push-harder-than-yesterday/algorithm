var isPalindrome = function (s) {
	// 처음 접근 방법
	// 대문자 소문자 숫자가 되므로 소문자와 숫자로만 따로 뽑기
	// 이 때, 거꾸로도 추가하여 마지막에 문자열 비교

	const lower = s.toLowerCase();
	let str = '';
	let reverse = '';
	for (let i = 0; i < lower.length; i++) {
		const cur = lower[i];
		if ((cur >= 'a' && cur <= 'z') || (cur >= '0' && cur <= '9')) {
			str += lower[i];
			reverse = lower[i] + reverse;
		}
	}
	console.log(str, reverse);
	return str === reverse;
};
