/* 
#============================================================# 
| 접근 방식 1                                                | 
|------------------------------------------------------------|
| 문자열을 배열로 바꾸며 한글자씩 판단하면서 값을 더함       |
| I, X, C 일 경우 뒤의 글자가 무엇이냐에 따라 값이 달라지므로|
| 뒤에 값을 확인하고 덧셈을 하며, 다음 값은 패스             |
#============================================================#
*/

var romanToInt = function (s) {
	let isPass = false;
	return s.split('').reduce((acc, val, idx, arr) => {
		if (isPass) {
			isPass = false;
			return acc;
		}
		if (val === 'I') {
			if (idx + 1 < arr.length) {
				if (arr[idx + 1] === 'V') {
					isPass = true;
					return acc + 4;
				}
				if (arr[idx + 1] === 'X') {
					isPass = true;
					return acc + 9;
				}
			}
			return acc + 1;
		} else if (val === 'V') {
			return acc + 5;
		} else if (val === 'X') {
			if (idx + 1 < arr.length) {
				if (arr[idx + 1] === 'L') {
					isPass = true;
					return acc + 40;
				}
				if (arr[idx + 1] === 'C') {
					isPass = true;
					return acc + 90;
				}
			}
			return acc + 10;
		} else if (val === 'L') {
			return acc + 50;
		} else if (val === 'C') {
			if (idx + 1 < arr.length) {
				if (arr[idx + 1] === 'D') {
					isPass = true;
					return acc + 400;
				}
				if (arr[idx + 1] === 'M') {
					isPass = true;
					return acc + 900;
				}
			}
			return acc + 100;
		} else if (val === 'D') {
			return acc + 500;
		} else {
			return acc + 1000;
		}
	}, 0);
};
