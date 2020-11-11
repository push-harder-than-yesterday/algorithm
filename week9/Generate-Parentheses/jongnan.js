var generateParenthesis = function (n) {
	return makeParenthesis(n, [], []);
};

/*////////////////////////////////////////////////////////////////
풀이 방식
------------------------------------------------------------------
선택할 수 있는 것은 "(" 혹은 ")" 두 가지가 된다.
여기서 "("은 최대 n개까지만 추가할 수 있으며,
")" 같은 경우, "("와 짝지을 수 있다면 추가가 가능하다.
////////////////////////////////////////////////////////////////*/
var makeParenthesis = function (n, parenthesis, combs) {
	if (n * 2 === parenthesis.length) {
		if (n !== 0) combs.push(parenthesis.join(''));
		return combs;
	}
	if (isPossibleOpen(n, parenthesis)) {
		parenthesis.push('(');
		makeParenthesis(n, parenthesis, combs);
		parenthesis.pop();
	}
	if (isPossibleClose(parenthesis)) {
		parenthesis.push(')');
		makeParenthesis(n, parenthesis, combs);
		parenthesis.pop();
	}
	return combs;
};

var isPossibleOpen = function (n, parenthesis) {
	return n > parenthesis.filter((v) => v === '(').length;
};

var isPossibleClose = function (parenthesis) {
	let state = 0;
	for (let val of parenthesis) {
		if (val === '(') state++;
		else {
			state--;
			if (state < 0) return false;
		}
	}
	return state === 0;
};

/*////////////////////////////////////////////////////////////////
솔루션 풀이 방식
------------------------------------------------------------------
괄호가 가능한 모든 경우의 수를 만들고 난 뒤에 해당 괄호가
적절한지 판단하여 적절한 괄호들만 추가 시키는 방식
////////////////////////////////////////////////////////////////*/

var makeParenthesis = function (n, parenthesis, combs) {
	if (n * 2 === parenthesis.length) {
		if (n !== 0 && isValid(parenthesis)) combs.push(parenthesis.join(''));
	} else {
		parenthesis.push('(');
		makeParenthesis(n, parenthesis, combs);
		parenthesis.pop();
		parenthesis.push(')');
		makeParenthesis(n, parenthesis, combs);
		parenthesis.pop();
	}
	return combs;
};

var isValid = function (parenthesis) {
	let state = 0;
	for (let val of parenthesis) {
		if (val === '(') state++;
		else {
			state--;
			if (state < 0) return false;
		}
	}
	return state === 0;
};
