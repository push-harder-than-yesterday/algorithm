var reverse = function (x) {
	// 처음 접근 방식
	// number -> string -> array 변경 후에 reverse 함수 사용
	// 음수의 경우 숫자 맨 앞에 '-' 가 있으므로 뒤집고 나면 맨 뒤에 있으니 이를 앞으로 옮김
	const arr = (x + '').split('').reverse();

	if (x < 0) {
		arr.pop();
		arr.unshift('-');
	}

	const reverseNum = +arr.join('');

	const BOUND_NUM = Math.pow(2, 31);
	if (reverseNum < BOUND_NUM * -1 || reverseNum > BOUND_NUM - 1) return 0;
	return reverseNum;
};
