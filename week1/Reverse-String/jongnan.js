var reverseString = function (s) {
	// 처음 접근 방식
	// array에 내장 메소드인 reverse를 사용
	// s.reverse();

	// 다른 방법
	// for문을 사용하여 1 과 N, 2와 N-1 ... 변경
	const limit = Math.floor(s.length / 2);
	for (let i = 0; i < limit; i++) {
		const temp = s[i];
		s[i] = s[s.length - i - 1];
		s[s.length - i - 1] = temp;
	}
};
