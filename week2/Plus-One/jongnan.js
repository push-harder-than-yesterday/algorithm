var plusOne = function (digits) {
	// 처음 접근 방법
	// digits 배열을 문자열로 변경 -> 숫자로 변경 -> +1 -> 다시 문자열 -> split -> 각 값을 숫자로 변경
	// 하지만 이 방법은 자바스크립트에서 안전하게 사용할 수 있는 값을 뛰어 넘을 수 있음
	// digits의 값이 100 이므로 절대 불가능...조건문을 잘 읽자...

	//return (((+digits.join('')) + 1) + '').split('').map((v) => +v);

	// 다음 접근 방식
	// 배열에서 마지막 자리수 부터 덧셈 실시
	// 만약 10이 넘어간다면 위 자리수에 +1, 이를 반복

	// 1을 더하면서 시작해야되므로 carry는 1부터 시작
	let carry = 1;
	for (let i = digits.length - 1; i >= 0; i--) {
		digits[i] += carry;
		// 10이 되었을 경우 0으로 바꾼뒤 다음 자리수로 넘김
		if (digits[i] === 10) {
			digits[i] = 0;
			continue;
		}
		// carry가 더이상 없으므로 0으로 바꾼뒤 바로 반환
		carry = 0;
		return digits;
	}
	// digits의 맨 처음 값에서 +1 을 했을때 10일 경우 return을 해주면 안되므로 여기서 따로 처리
	if (carry === 1) digits.unshift(1);
	return digits;
};
