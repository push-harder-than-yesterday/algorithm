/*////////////////////////////////////////////////////////////////
풀이 방식
------------------------------------------------------------------
간단한 조합 문제로 숫자에 해당하는 문자들을 모두 사용해 보는 방식을 사용(재귀)
////////////////////////////////////////////////////////////////*/
var letterCombinations = function (digits) {
	return combineLetters(digits, 0, [], []);
};

var getLetter = function (num) {
	return {
		2: ['a', 'b', 'c'],
		3: ['d', 'e', 'f'],
		4: ['g', 'h', 'i'],
		5: ['j', 'k', 'l'],
		6: ['m', 'n', 'o'],
		7: ['p', 'q', 'r', 's'],
		8: ['t', 'u', 'v'],
		9: ['w', 'x', 'y', 'z'],
	}[num];
};

var combineLetters = function (digits, dep, letters, combs) {
	if (dep === digits.length) {
		if (letters.length > 0) combs.push(letters.join(''));
		return combs;
	}
	const curDigitLetters = getLetter(+digits[dep]);
	for (let i = 0; i < curDigitLetters.length; i++) {
		letters.push(curDigitLetters[i]);
		combineLetters(digits, dep + 1, letters, combs);
		letters.pop();
	}
	return combs;
};
